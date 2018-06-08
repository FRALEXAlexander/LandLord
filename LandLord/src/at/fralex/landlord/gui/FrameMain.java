package at.fralex.landlord.gui;

import javax.swing.JFrame;

import at.fralex.landlord.main.Main;

public class FrameMain extends JFrame {
	
	public FrameMain() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1280, 720);
		this.add(Main.mainPanel);
		this.setVisible(true);
	}
	
	
}
