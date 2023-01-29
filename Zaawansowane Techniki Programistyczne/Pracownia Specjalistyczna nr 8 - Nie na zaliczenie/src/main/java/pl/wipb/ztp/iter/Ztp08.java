package pl.wipb.ztp.iter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JFrame;

public class Ztp08 {

	static final int TILESIZE = 40;

	public static void main(String[] args) {
		System.setProperty("sun.java2d.opengl", "true");

		// konstruowanie okna
		JFrame frame = new JFrame("Iterator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final Kafelki kafelki = new Kafelki(16, 9, TILESIZE);
		frame.getContentPane().add(kafelki);
		frame.pack();
		frame.setVisible(true);

		// reakcja na kliknięcie uruchomienie wątku z iteracją
		kafelki.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX() / TILESIZE;
				int y = e.getY() / TILESIZE;
				Iterator<Tile> iter;// = p.firstIter(x,y);
				Random rnd = new Random();
				int versionIter = rnd.nextInt(4);
				if (versionIter == 0)
					iter = kafelki.firstIter(x, y);
				else if (versionIter == 1)
					iter = kafelki.secondIter(x, y);
				else if (versionIter == 3)
					iter = kafelki.thirdIter(x, y);
				else
					iter = kafelki.fourIter(x, y);
				new Thread(new Watek(iter, x, y, kafelki)).start();
			}
		});

		// reakcja na ruch - podświetlenie wskazanego kafelka
		kafelki.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int x = e.getX() / TILESIZE;
				int y = e.getY() / TILESIZE;
				kafelki.highlight(x, y);
			}
		});
	}
}