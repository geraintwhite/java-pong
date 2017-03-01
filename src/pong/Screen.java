package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
	private boolean paused;


	public Screen() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.BLACK);

		player1 = new Paddle(false);
		player2 = new Paddle(true);

		ball = new Ball();

		paused = true;
	}

	private void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
	    g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		player1.draw(g2d);
		player2.draw(g2d);
		player1.showScore(g2d);
		player2.showScore(g2d);
		ball.draw(g2d);

		if (paused) {
			g2d.setColor(Color.WHITE);
			g2d.setFont(new Font(g2d.getFont().getFontName(), Font.PLAIN, 100));
			g2d.drawString("PAUSED", WIDTH / 2 - 200, HEIGHT / 2 + 40);
		}
	}

	public void tick(boolean[] keys) {
		if (keys[KeyEvent.VK_SPACE]) paused = !paused;
		if (paused) return;

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
