package pong;

import java.awt.EventQueue;

public class Main {
	private void createAndShowGUI() {
		Game g = new Game();
		g.start();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				Main m = new Main();
				m.createAndShowGUI();
			}
		});
	}
}
