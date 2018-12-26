package at.fralex.landlord.game;

import at.fralex.landlord.main.GUIControll;

public class StartNewGame {

	public static void start(String name) {

		CurrentGame.name = name;
		CurrentGame.zoom = 1;
		CurrentGame.gridSizeBase = 64;
		CurrentGame.grid = new Grid(30, 20);
		GUIControll.showPanel("game");

	}

}