package pong;

import java.awt.Color;
import java.awt.Graphics2D;

public class Paddle {
	private float x, y;
	private float width, height;
	private float velocity;

	public Paddle(float x, float y, float width, float height) {
		this.x = x - (width / 2);
		this.y = y - (height / 2);
		this.width = width;
		this.height = height;
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
}
