package at.fralex.landlord.gui;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class PanelMain extends JPanel {

	PanelGame g;
	PanelMenu m;
	
	public CardLayout layout;
	

	public PanelMain() {
		layout = new CardLayout();
		g = new PanelGame();
		m = new PanelMenu();

		this.setLayout(layout);

		
		this.add(m, "menu");
		this.add(g, "game");
		

	}

}
