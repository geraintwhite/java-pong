package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ball {
	private float x, y;
	private float size;
	private float angle;
	private float velocity;

	public Ball() {
		init();
	}

	private void init() {
		this.size = 20;
		this.x = Screen.WIDTH / 2 - (this.size / 2);
		this.y = Screen.HEIGHT / 2 - (this.size / 2);
		this.angle = (float) (Math.PI / 4);
		this.velocity = 3;
	}

	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.RED);
		g2d.fillOval((int) x, (int) y, (int) size, (int) size);
	}

	public void tick(Paddle player1, Paddle player2) {
		float dx = (float) (velocity * Math.sin(angle));
		float dy = (float) (velocity * Math.cos(angle));

		x += dx;
		y += dy;

		if (y < 0 || y > Screen.HEIGHT - size) {
			angle = (float) (Math.PI - angle);
		}

		if (x < 0) {
			player2.addPoint();
			init();
		} else if (x > Screen.WIDTH - size) {
			player1.addPoint();
			init();
		}
	}

	public void collide(Paddle paddle) {
		if (getBounds().intersects(paddle.getBounds())) {
			angle = (float) (2 * Math.PI - angle);
		}
	}

	private Ellipse2D getBounds() {
		return new Ellipse2D.Double(x, y, size, size);
	}
}
