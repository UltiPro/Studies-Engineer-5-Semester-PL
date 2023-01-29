package pl.wipb.ztp.iter;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;

//macierz kafelków
class Kafelki extends JPanel {

	private Tile[][] matrix;
	private int tilesize;
	// kafelek podświetlony (myszką)
	private int hx = -1, hy = -1;

	// inicjalizacja macierzy
	public Kafelki(int cols, int rows, int tilesize) {
		this.setPreferredSize(new Dimension(cols * tilesize, rows * tilesize));
		this.tilesize = tilesize;
		matrix = new Tile[rows][cols];
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[i].length; ++j)
				matrix[i][j] = new Tile();
		}
	}

	// rysowanie macierzy (oraz jednego podświetlonego)
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[i].length; ++j) {
				if (i == hy && j == hx)
					g.setColor(matrix[i][j].getColor().brighter());
				else
					g.setColor(matrix[i][j].getColor());
				g.fillRect(j * tilesize, i * tilesize + 1, tilesize - 1, tilesize - 1);
			}
		}
	}

	// podświetl
	public void highlight(int x, int y) {
		hx = x;
		hy = y;
		repaint();
	}

	public Iterator<Tile> firstIter(int x, int y) {
		Iterator<Tile> iter = new Iterator<Tile>() {
			private int hx = x;
			private int hy = y;

			@Override
			public boolean hasNext() {
				if (hy == matrix.length)
					return false;
				return true;
			}

			@Override
			public Tile next() {
				Tile tileNextOne = matrix[hy][hx];
				hx = (hx + 1) % matrix[0].length;
				if (hx == 0)
					hy++;
				return tileNextOne;
			}
		};
		return iter;
	}

	public Iterator<Tile> secondIter(int x, int y) {
		Iterator<Tile> iter = new Iterator<Tile>() {
			private int hx = x;
			private int hy = y;

			@Override
			public boolean hasNext() {
				if (hx == matrix[0].length)
					return false;
				return true;
			}

			@Override
			public Tile next() {
				Tile tileNextOne = matrix[hy][hx];
				hy = (hy + 1) % matrix.length;
				if (hy == 0)
					hx++;
				return tileNextOne;
			}
		};
		return iter;
	}

	public Iterator<Tile> thirdIter(int x, int y) {
		Iterator<Tile> iter = new Iterator<Tile>() {
			private int hx = x;
			private int hy = y;
			private int pom = hx;

			@Override
			public boolean hasNext() {
				if (hy < 0)
					return false;
				return true;
			}

			@Override
			public Tile next() {
				Tile tileNextOne = matrix[hy][hx];
				hx = hx - 1;
				if (hx < 0) {
					hx = pom;
					hy--;
				}
				return tileNextOne;
			}
		};
		return iter;
	}

	public Iterator<Tile> fourIter(int x, int y) {
		Iterator<Tile> iter = new Iterator<Tile>() {
			private int hx = x;
			private int hy = y;
			private int pom = hy;

			@Override
			public boolean hasNext() {
				if (hx < 0)
					return false;
				return true;
			}

			@Override
			public Tile next() {
				Tile tileNextOne = matrix[hy][hx];
				hy = hy - 1;
				if (hy < 0) {
					hy = pom;
					hx--;
				}
				return tileNextOne;
			}
		};
		return iter;
	}
}