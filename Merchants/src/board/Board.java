package board;
import processing.core.PApplet;

import javax.swing.JOptionPane;

import bla269.shapes.Rectangle;
import other.Player;

public class Board extends PApplet {

	private int stage;
	private static final int menuPage = 1, rulePage = 2, rulePage2 = 3, boardPage = 4, transPage = 5, endPage = 6;
	private Rectangle backBtn;

	private Rectangle nextStageBtn, ruleBtn;

	// Game fields
	private Player[] players = new Player[4];
	private int numPlayers, numTurns, curPlayer;
	private Tile[][] tiles = new Tile[15][15];

	public Board() {
		stage = menuPage;
		nextStageBtn = new Rectangle(150, 150, 200, 75);
		nextStageBtn.setfill(0, 180, 255);
		nextStageBtn.setStroke(0, 180, 255);

		ruleBtn = new Rectangle(150, 250, 200, 75);
		ruleBtn.setfill(0, 180, 255);
		ruleBtn.setStroke(0, 180, 255);

		backBtn = new Rectangle(25, 400, 50, 50);

	}

	public void draw() {
		background(255);
		if (stage == menuPage) {
			nextStageBtn.draw(this);
			ruleBtn.draw(this);
		} else if (stage == rulePage) {
			backBtn.draw(this);
		} else if (stage == rulePage2) {
			backBtn.draw(this);
		} else if (stage == boardPage) {
			nextStageBtn.draw(this);
			ruleBtn.draw(this);
			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 16; j++) {
					line(60 * i, 0, 60 * i, 900);
					line(0, 60 * i, 900, 60 * i);
				}
			}
		} else if (stage == transPage) {
			nextStageBtn.draw(this);

		} else if (stage == endPage) {

		}

	}

	public void mousePressed() {
		if (stage == menuPage) {
			if (nextStageBtn.isPointInside(mouseX, mouseY)) {
				String input;
				do {
					input = JOptionPane.showInputDialog("Enter number of players. 1-4 players");
				} while (!validIntegerInput(input)
						|| !(input.compareTo("0") > 0 && input.compareTo("5") < 0 && input.length() == 1));
				numPlayers = Integer.parseInt(input);

				for (int i = 0; i < numPlayers; i++) {
					input = JOptionPane.showInputDialog("Enter the name for player " + (i + 1));

					players[i] = new Player(i, 100, input);

				}

				do {
					input = JOptionPane.showInputDialog("How many turns should the game last?");
				} while (!validIntegerInput(input));
				numTurns = Integer.parseInt(input);

				nextStageBtn = new Rectangle(1000, 100, 50, 50);
				ruleBtn = new Rectangle(1000, 200, 50, 50);

				stage = boardPage;
			} else if (ruleBtn.isPointInside(mouseX, mouseY)) {
				stage = rulePage;
			}
		} else if (stage == rulePage) {
			if (backBtn.isPointInside(mouseX, mouseY)) {
				stage = menuPage;
			}
		} else if (stage == rulePage2) {
			if (backBtn.isPointInside(mouseX, mouseY)) {
				stage = boardPage;
			}
		} else if (stage == boardPage) {
			if (nextStageBtn.isPointInside(mouseX, mouseY)) {
				stage = transPage;
			} else if (ruleBtn.isPointInside(mouseX, mouseY)) {
				stage = rulePage2;
			}
		} else if (stage == transPage) {
			if (nextStageBtn.isPointInside(mouseX, mouseY)) {
				String input;
				stage = boardPage;
			}

		} else if (stage == endPage) {

		}
	}

	private boolean validIntegerInput(String x) {
		if (x.length() == 0)
			return false;
		for (int i = 0; i < x.length(); i++) {
			if (!(x.charAt(i) >= '0' && x.charAt(i) <= '9')) {
				return false;
			}
		}
		return true;
	}

}