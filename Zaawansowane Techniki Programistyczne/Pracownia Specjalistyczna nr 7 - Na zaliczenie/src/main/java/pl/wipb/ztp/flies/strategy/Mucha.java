package pl.wipb.ztp.flies.strategy;

import java.util.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

interface Strategia {
	public void setColor(Graphics g);

	public void moveMethod(Mucha mucha);
}

class Mucha {

	private final double k = 0.03;
	double x, y; // pozycja muchy
	double vx, vy; // predkosc muchy
	private Strategia strategy;

	public Mucha(Strategia strategy) {
		this.strategy = strategy;
		x = Math.random();
		y = Math.random();
		vx = k * (Math.random() - Math.random());
		vy = k * (Math.random() - Math.random());
	}

	public void draw(Graphics g) {
		strategy.setColor(g);
		Rectangle rc = g.getClipBounds();
		int a = (int) (x * rc.getWidth()),
				b = (int) (y * rc.getHeight());
		g.fillOval(a, b, 5, 5);
	}

	public void move() {
		strategy.moveMethod(this);
	}
}

class MuchaZwyczajna implements Strategia {
	@Override
	public void moveMethod(Mucha mucha) {
		mucha.x += mucha.vx;
		mucha.y += mucha.vy;
		if (mucha.x < 0) {
			mucha.x = -mucha.x;
			mucha.vx = -mucha.vx;
		}
		if (mucha.x > 1) {
			mucha.x = 2 - mucha.x;
			mucha.vx = -mucha.vx;
		}
		if (mucha.y < 0) {
			mucha.y = -mucha.y;
			mucha.vy = -mucha.vy;
		}
		if (mucha.y > 1) {
			mucha.y = 2 - mucha.y;
			mucha.vy = -mucha.vy;
		}
	}

	@Override
	public void setColor(Graphics g){
		g.setColor(Color.black);
	}
}

class MuchaDrunk implements Strategia {
	private Random random = new Random();

	@Override
	public void setColor(Graphics g) {
		g.setColor(Color.red);
	}

	@Override
	public void moveMethod(Mucha mucha) {
		double lenght = Math.sqrt(mucha.vx * mucha.vx + mucha.vy * mucha.vy);
		double alfa = Math.acos(mucha.vx / lenght);
		double rangeMax = 2 * Math.PI;
		double rangeMin = 0;
		alfa = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
		mucha.vx = lenght * Math.cos(alfa);
		mucha.vy = lenght * Math.sin(alfa);

		mucha.x += mucha.vx;
		mucha.y += mucha.vy;
		if (mucha.x < 0) {
			mucha.x = -mucha.x;
			mucha.vx = -mucha.vx;
		}
		if (mucha.x > 1) {
			mucha.x = 2 - mucha.x;
			mucha.vx = -mucha.vx;
		}
		if (mucha.y < 0) {
			mucha.y = -mucha.y;
			mucha.vy = -mucha.vy;
		}
		if (mucha.y > 1) {
			mucha.y = 2 - mucha.y;
			mucha.vy = -mucha.vy;
		}
	}
}

class MuchaPunkt implements Strategia {
	private Random random = new Random();
	private double r = random.nextDouble() / 40;
	public double Ox;
	public double Oy;
	public double alfa;

	@Override
	public void setColor(Graphics g) {
		g.setColor(Color.blue);
	}

	@Override
	public void moveMethod(Mucha mucha) {
		Ox = mucha.x;
		Oy = mucha.y;
		mucha.x = mucha.x + r;
		mucha.y = mucha.y + r;
		mucha.x = Ox + r * Math.sin(alfa);
		mucha.y = Oy + r * Math.cos(alfa);
		alfa = alfa + 0.1;
		if (alfa >= 2 * Math.PI)
			alfa = 0;
	}
}