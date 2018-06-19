package at.fralex.landlord.main;

import java.io.File;

import at.fralex.landlord.game.CurrentGame;
import at.fralex.landlord.game.StartNewGame;
import at.fralex.landlord.game.objects.GridObject;
import at.fralex.landlord.gui.FrameMain;
import at.fralex.landlord.gui.PanelContainer;
import at.fralex.landlord.util.CreateIcon;

public class Main {
	public static PanelContainer panelContainer = new PanelContainer();
	public static FrameMain mainFrame = new FrameMain();

	public static void main(String[] args) {

		// CreateIcon.createIcon("Shop", new File("res/test.png"), "Impact",
		// 100,50,"ShopIcon");
		
		StartNewGame.start("");

		CurrentGame.grid.grid[2][2] = new GridObject("nexus", 0, 1, 1, 1);
		
		CurrentGame.grid.grid[3][3] = new GridObject("road", 0, 1, 2, 1);
		
		System.out.println("done");

	}

}
