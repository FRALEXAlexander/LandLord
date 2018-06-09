package at.fralex.landlord.gui;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class PanelContainer extends JPanel {

	PanelGameMenu gameMenu;
	PanelMainMenu mainMenu;
	
	public CardLayout layout;
	

	public PanelContainer() {
		layout = new CardLayout();
		gameMenu = new PanelGameMenu();
		mainMenu = new PanelMainMenu();

		this.setLayout(layout);

		
		this.add(mainMenu, "menu");
		this.add(gameMenu, "gameMenu");
		

	}

}
