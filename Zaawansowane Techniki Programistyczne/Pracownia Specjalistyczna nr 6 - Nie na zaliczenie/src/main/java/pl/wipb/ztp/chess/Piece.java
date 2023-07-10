package pl.wipb.ztp.chess;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

class Piece implements InterfacePiece {
	public static final int TILESIZE = 32;
	private static Image image;

	static {
		try {
			image = Chessboard.loadImage("/img/pieces4.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int index; // usunięto x, y;

	public Piece(int idx) { // usunięto x, y;
		index = idx;
	}

	public void draw(Graphics2D graphics2d, int x, int y) { // dodano x i y
		graphics2d.drawImage(image, x, y, x + 1, y + 1, index * TILESIZE, 0, (index + 1) * TILESIZE, TILESIZE,
				null);
	}

	/*
	 * @Override
	 * public int getX() {
	 * return x;
	 * }
	 * 
	 * @Override
	 * public int getY() {
	 * return y;
	 * }
	 * 
	 * @Override
	 * public void moveTo(int xx, int yy) {
	 * x = xx;
	 * y = yy;
	 * }
	 */

	public InterfacePiece getDecorated() {
		return null;
	}
}