package at.fralex.landlord.gui;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class PanelContainer extends JPanel {

	PanelGameMenuSP gameMenuSP;
	PanelMainMenu mainMenu;
	PanelSettings settings;
	PanelNewGame newGame;
	PanelLoadGame loadGame;
	PanelGame game;
	
	public CardLayout layout;
	

	public PanelContainer() {
		
		layout = new CardLayout();
		
		gameMenuSP = new PanelGameMenuSP();
		mainMenu = new PanelMainMenu();
		settings = new PanelSettings();
		newGame = new PanelNewGame();
		loadGame = new PanelLoadGame();
		game = new PanelGame();
		
		this.setLayout(layout);

		
		this.add(mainMenu, "mainMenu");
		this.add(gameMenuSP, "gameMenuSP");
		this.add(settings, "settings");
		this.add(newGame,"newGame");
		this.add(loadGame,"loadGame");
		this.add(game,"game");

	}

}
