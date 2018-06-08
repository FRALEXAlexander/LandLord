package at.fralex.landlord.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenu extends JPanel {

	ButtonStandard exit;
	
	public PanelMenu() {
		exit = new ButtonStandard("Exit");
		
		
		exit.setPreferredSize(new Dimension(300, 100));
		this.add(exit);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(123,200,80));
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		
	}
}
