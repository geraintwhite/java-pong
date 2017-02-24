package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Paddle {
	private float x, y;
	private float width, height;
	private float velocity;
	private int score;

	public Paddle(boolean right) {
		this.width = 20;
		this.height = 100;
		this.x = right ? (Screen.WIDTH - this.width * 2) : this.width;
		this.y = (Screen.HEIGHT / 2) - (this.height / 2);
		this.velocity = 0;
	}

	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);
		g2d.fillRect((int) x, (int) y, (int) width, (int) height);
	}

	public void tick() {
		velocity = velocity * 0.9f;
		y += velocity;

		if (y + height > Screen.HEIGHT) {
			velocity *= -1;
			y = Screen.HEIGHT - height;
		} else if (y < 0) {
			velocity *= -1;
			y = 0;
		}
	}

	public void moveUp() {
		velocity -= 0.5f;
	}

	public void moveDown() {
		velocity += 0.5f;
	}

	public Rectangle2D getBounds() {
		return new Rectangle2D.Double(x, y, width, height);
	}

	public void addPoint() {
		score++;
	}
}
