package at.fralex.landlord.main;

import java.io.File;

import at.fralex.landlord.game.StartNewGame;
import at.fralex.landlord.gui.FrameMain;
import at.fralex.landlord.gui.PanelContainer;

public class Main {
	public static PanelContainer panelContainer = new PanelContainer();
	public static FrameMain mainFrame = new FrameMain();

	
	public static void main(String[] args) {
		
//		CreateIcon.createIcon("Back", new File("res/test.png"), "Impact", 300,100,"ButtonBack");
//		CreateIcon.createIcon("Exit", new File("res/test.png"), "Impact", 300,100,"ButtonExit");
//		CreateIcon.createIcon("Singleplayer", new File("res/test.png"), "Impact", 300,100,"ButtonSingleplayer");
		//CreateIcon.createIcon("", new File("res/test.png"), "Impact", 600,100,"TextfieldName");
		
		StartNewGame.start("Test");
		
		System.out.println("done");
	
	}

}
