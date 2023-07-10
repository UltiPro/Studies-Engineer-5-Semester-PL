package pl.wipb.ztp.chess;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.awt.geom.AffineTransform;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Chessboard extends JPanel {
	public static final int ZEROX = 23;
	static final int ZEROY = 7;
	private Image image;
	private InterfacePiece dragged = null;
	private Point mouse = null;
	AffineTransform draggedTransform = null;
	private JButton undo, redo;

	private HashMap<Point, InterfacePiece> board = new HashMap<Point, InterfacePiece>(); // zmieniono Piece i na dole
																							// wszędzie także

	public void Drop(InterfacePiece p, int x, int y) {
		repaint();
		board.put(new Point(x, y), p); // jeśli na tych współrzędnych
		// jest już jakaś figura, znika ona z planszy
		// (HashMap nie dopuszcza powtórzeń)
	}

	public InterfacePiece Take(int x, int y) {
		repaint();
		return board.remove(new Point(x, y));
	}

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.drawImage(image, 0, 0, null);
		Graphics2D g2d = (Graphics2D) graphics;
		for (Map.Entry<Point, InterfacePiece> e : board.entrySet()) {
			Point pt = e.getKey(); // od komentować
			InterfacePiece pc = e.getValue();
			pc.draw(g2d, pt.x, pt.y);
		}
		if (mouse != null && dragged != null) {
			dragged.draw(g2d, (mouse.x - 23) / 32, (mouse.y - 7) / 32);
		}
	}

	public void setPiece(int x, int y, int index) {
		Piece type = FactoryPiece.getPieceType(index);
		board.put(new Point(x, y), new Decorator(type));
	}

	Chessboard() {
		// białe
		setPiece(0, 1, 0);
		setPiece(1, 1, 0);
		setPiece(2, 1, 0);
		setPiece(3, 1, 0);
		setPiece(4, 1, 0);
		setPiece(5, 1, 0);
		setPiece(6, 1, 0);
		setPiece(7, 1, 0);
		setPiece(0, 0, 1);
		setPiece(7, 0, 1);
		setPiece(1, 0, 2);
		setPiece(6, 0, 2);
		setPiece(2, 0, 3);
		setPiece(5, 0, 3);
		setPiece(3, 0, 5);
		setPiece(4, 0, 4);
		// czarne
		setPiece(0, 6, 6);
		setPiece(1, 6, 6);
		setPiece(2, 6, 6);
		setPiece(3, 6, 6);
		setPiece(4, 6, 6);
		setPiece(5, 6, 6);
		setPiece(6, 6, 6);
		setPiece(7, 6, 6);
		setPiece(0, 7, 7);
		setPiece(7, 7, 7);
		setPiece(1, 7, 8);
		setPiece(6, 7, 8);
		setPiece(2, 7, 9);
		setPiece(5, 7, 9);
		setPiece(4, 7, 10);
		setPiece(3, 7, 11);

		try {
			image = loadImage("/img/board3.png");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));

		this.addMouseListener(new MouseAdapter() { // trzymanie
			public void mousePressed(MouseEvent ev) {
				Chessboard.this.dragged = Chessboard.this.Take((ev.getX() - 23) / 32, (ev.getY() - 7) / 32);
				if (Chessboard.this.dragged == null)
					return;
				Chessboard.this.draggedTransform = new AffineTransform();
				Chessboard.this.dragged = new SecondDecorator(Chessboard.this.dragged,
						Chessboard.this.draggedTransform);
				Chessboard.this.mouse = ev.getPoint();
			}

			public void mouseReleased(MouseEvent ev) { // puszcanie
				if (Chessboard.this.dragged == null)
					return;
				Chessboard.this.Drop(Chessboard.this.dragged.getDecorated(), (ev.getX() - 23) / 32,
						(ev.getY() - 7) / 32);
				Chessboard.this.dragged = null;
				Chessboard.this.undo.setEnabled(true);
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() { // przeciąganie
			public void mouseDragged(MouseEvent ev) {
				if (Chessboard.this.draggedTransform == null)
					return;
				Chessboard.this.draggedTransform.setToTranslation(ev.getX() - Chessboard.this.mouse.getX(),
						ev.getY() - Chessboard.this.mouse.getY());
				Chessboard.this.repaint();
			}
		});
	}

	class UndoButton implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			System.out.println("UNDO");
			redo.setEnabled(true);
		}
	}

	class RedoButton implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			System.out.println("REDO");
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Chess");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Chessboard board = new Chessboard();

		JToolBar bar = new JToolBar();
		try {
			board.undo = new JButton(new ImageIcon(loadImage("/img/undo.png")));
			board.redo = new JButton(new ImageIcon(loadImage("/img/redo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		board.undo.addActionListener(board.new UndoButton());
		board.redo.addActionListener(board.new RedoButton());
		board.undo.setEnabled(false);
		board.redo.setEnabled(false);
		bar.add(board.undo);
		bar.add(board.redo);
		frame.add(bar, BorderLayout.PAGE_START);
		frame.add(board);
		frame.pack();
		frame.setVisible(true);
	}

	public static Image loadImage(String path) throws IOException {
		InputStream fileName = Chessboard.class.getResourceAsStream(path);
		return ImageIO.read(fileName);
	}
}