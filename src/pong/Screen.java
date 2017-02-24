package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Screen extends JPanel {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	private Paddle left;
	private Paddle right;

	private Ball ball;


	public Screen() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.BLACK);

		int paddleHeight = 100;
		int paddleWidth = 20;

		left = new Paddle(20, HEIGHT / 2, paddleWidth, paddleHeight);
		right = new Paddle(WIDTH - 20, HEIGHT / 2, paddleWidth, paddleHeight);

		ball = new Ball(WIDTH / 2, HEIGHT / 2, 20);
	}

	private void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();

		left.draw(g2d);
		right.draw(g2d);
		ball.draw(g2d);
	}

	public void tick(boolean[] keys) {
		if (keys[KeyEvent.VK_UP]) {
			left.moveUp();
			right.moveDown();
		}

		if (keys[KeyEvent.VK_DOWN]) {
			left.moveDown();
			right.moveUp();
		}

		left.tick();
		right.tick();
		ball.tick();
	}

	public void render() {
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
}
