package at.fralex.landlord.game;

import at.fralex.landlord.main.GUIControll;

public class StartNewGame {

	public static void start(String name) {
		
		CurrentGame.name = name;
		CurrentGame.grid = new Grid();
		GUIControll.showPanel("game");
		
	}

}
