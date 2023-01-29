package pl.wipb.ztp.iter;

import java.util.Iterator;

class Watek implements Runnable {

	private java.awt.Component repainter;
	Iterator<Tile> p;

	public Watek(Iterator<Tile> k, int x, int y, java.awt.Component repainter) {
		this.repainter = repainter;
		this.p = k;
	}

	public void run() {
		while (p.hasNext()) {
			p.next().flip();
			if (repainter != null)
				repainter.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}