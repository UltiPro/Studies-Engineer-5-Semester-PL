package pl.wipb.ztp.flies.strategy;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Muchy extends JPanel implements Runnable {
	private Mucha[] ar;
	Random rnd = new Random();

	public Muchy() {
		this.setPreferredSize(new Dimension(640, 480));
		ar = new Mucha[30];
		for (int i = 0; i < ar.length; ++i) {
			int number = rnd.nextInt(3);
			if (number == 2)
				ar[i] = new Mucha(new MuchaPunkt());
			else if (number == 1)
				ar[i] = new Mucha(new MuchaDrunk());
			else
				ar[i] = new Mucha(new MuchaZwyczajna());
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < ar.length; ++i)
			ar[i].draw(g);
	}

	@Override
	public void run() {
		while (true) {
			for (int i = 0; i < ar.length; ++i)
				ar[i].move();
			repaint();
			try {
				Thread.currentThread();
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.setProperty("sun.java2d.opengl", "true");
		JFrame frame = new JFrame("Muchy");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Muchy m = new Muchy();
		frame.getContentPane().add(m);
		frame.pack();
		frame.setVisible(true);
		new Thread(m).start();
	}
}