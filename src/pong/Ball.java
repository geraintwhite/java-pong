package pong;

import java.awt.Color;
import java.awt.Graphics2D;

public class Ball {
	private float x, y;
	private float size;
	private float angle;
	private float velocity;

	public Ball(float x, float y, float size) {
		this.x = x - (size / 2);
		this.y = y - (size / 2);
		this.size = size;
		this.angle = (float) (Math.PI / 4);
		this.velocity = 3;
	}

	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.RED);
		g2d.fillOval((int) x, (int) y, (int) size, (int) size);
	}

	public void tick() {
		float dx = (float) (velocity * Math.sin(angle));
		float dy = (float) (velocity * Math.cos(angle));

		x += dx;
		y += dy;

		if (x < 0) {
			angle = (float) (2 * Math.PI - angle);
			x = 0;
		}

		if (x > Screen.WIDTH - size) {
			angle = (float) (2 * Math.PI - angle);
			x = Screen.WIDTH - size;
		}

		if (y > Screen.HEIGHT - size) {
			angle = (float) (Math.PI - angle);
			y = Screen.HEIGHT - size;
		}

		if (y < 0) {
			angle = (float) (Math.PI - angle);
			y = 0;
		}
	}
}
