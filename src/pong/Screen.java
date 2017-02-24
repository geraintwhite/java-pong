package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Screen extends JPanel {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	private Paddle player1;
	private Paddle player2;

	private Ball ball;


	public Screen() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.BLACK);

		player1 = new Paddle(false);
		player2 = new Paddle(true);

		ball = new Ball();
	}

	private void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
	    g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		player1.draw(g2d);
		player2.draw(g2d);
		ball.draw(g2d);
	}

	public void tick(boolean[] keys) {
		if (keys[KeyEvent.VK_W]) player1.moveUp();
		if (keys[KeyEvent.VK_S]) player1.moveDown();
		if (keys[KeyEvent.VK_UP]) player2.moveUp();
		if (keys[KeyEvent.VK_DOWN]) player2.moveDown();

		player1.tick();
		player2.tick();
		ball.tick(player1, player2);
		ball.collide(player1);
		ball.collide(player2);
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
