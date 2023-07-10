package pl.wipb.ztp.flies.template;

import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

abstract class Mucha {
	private final double k = 0.03;
	double x, y; // pozycja muchy
	double vx, vy; // predkosc muchy

	public Mucha() {
		x = Math.random();
		y = Math.random();
		vx = k * (Math.random() - Math.random());
		vy = k * (Math.random() - Math.random());
	}

	public void draw(Graphics g) {
		setColor(g);
		Rectangle rc = g.getClipBounds();
		int a = (int) (x * rc.getWidth()),
				b = (int) (y * rc.getHeight());
		g.fillOval(a, b, 5, 5);
	}

	protected abstract void setColor(Graphics g);

	protected abstract void fillOval(Graphics g, int x, int y, int width, int height);

	protected abstract void move();
}

class MuchaZwyczajna extends Mucha {
	public MuchaZwyczajna() {
		super();
	}

	public void move() {
		x += vx;
		y += vy;
		if (x < 0) {
			x = -x;
			vx = -vx;
		}
		if (x > 1) {
			x = 2 - x;
			vx = -vx;
		}
		if (y < 0) {
			y = -y;
			vy = -vy;
		}
		if (y > 1) {
			y = 2 - y;
			vy = -vy;
		}
	}

	protected void setColor(Graphics g) {
		g.setColor(Color.black);
	}

	@Override
	protected void fillOval(Graphics g, int x, int y, int width, int height) {
		g.fillOval(x, y, width, height);
	}
}

class MuchaDrunk extends Mucha {
	private Random random = new Random();

	protected void move() {
		double lenght = Math.sqrt(vx * vx + vy * vy);
		double alfa = Math.acos(vx / lenght);
		double rangeMax = 2 * Math.PI;
		double rangeMin = 0;
		alfa = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
		vx = lenght * Math.cos(alfa);
		vy = lenght * Math.sin(alfa);

		x += vx;
		y += vy;
		if (x < 0) {
			x = -x;
			vx = -vx;
		}
		if (x > 1) {
			x = 2 - x;
			vx = -vx;
		}
		if (y < 0) {
			y = -y;
			vy = -vy;
		}
		if (y > 1) {
			y = 2 - y;
			vy = -vy;
		}
	}

	protected void setColor(Graphics g) {
		g.setColor(Color.red);
	}

	protected void fillOval(Graphics g, int x, int y, int width, int height) {
		g.fillOval(x, y, width, height);
	}
}

class MuchaPunkt extends Mucha {
	private Random random = new Random();
	double r, Ox, Oy, alfa;

	public MuchaPunkt() {
		super();
		r = random.nextDouble() / 10;
		Ox = x;
		Oy = y;
		x = x + r;
		y = y + r;
	}

	protected void move() {
		x = Ox + r * Math.sin(alfa);
		y = Oy + r * Math.cos(alfa);
		alfa = alfa + 0.1;
		if (alfa >= 2 * Math.PI) {
			alfa = 0;
		}
	}

	protected void setColor(Graphics g) {
		g.setColor(Color.blue);
	}

	protected void fillOval(Graphics g, int x, int y, int width, int height) {
		g.fillOval(x, y, width, height);
	}
}