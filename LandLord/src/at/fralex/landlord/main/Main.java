package at.fralex.landlord.main;

import at.fralex.landlord.game.CurrentGame;
import at.fralex.landlord.game.StartNewGame;
import at.fralex.landlord.game.objects.GridObject;
import at.fralex.landlord.game.objects.ObjectBackground;
import at.fralex.landlord.game.objects.ObjectNexus;
import at.fralex.landlord.game.objects.ObjectRoad;
import at.fralex.landlord.gui.FrameMain;
import at.fralex.landlord.gui.PanelContainer;
import at.fralex.landlord.util.Utils;

public class Main {
	public static PanelContainer panelContainer = new PanelContainer();
	public static FrameMain mainFrame = new FrameMain();

	public static void main(String[] args) {

		// CreateIcon.createIcon("Shop", new File("res/test.png"), "Impact",
		// 100,50,"ShopIcon");

		StartNewGame.start("");

	
		
		
		
		
		CurrentGame.grid.objects[1][1] = new GridObject(new ObjectNexus(0, 1, 1));

		//CurrentGame.grid.objects[2][1] = new GridObject(new ObjectRoad(0, 2, 1));

		System.out.println("done");

	}

}
