package at.fralex.landlord.gui;

import javax.swing.JFrame;

import at.fralex.landlord.main.Main;

public class FrameMain extends JFrame {

	private static final long serialVersionUID = 1L;

	public FrameMain() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1280, 719);
		this.setTitle("LandLord");
		this.add(Main.panelContainer);
		// this.setResizable(false);
		this.setVisible(true);
	}

}