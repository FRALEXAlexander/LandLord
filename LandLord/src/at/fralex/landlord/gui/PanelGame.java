package at.fralex.landlord.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import at.fralex.landlord.game.CurrentGame;

public class PanelGame extends JPanel {

	public PanelGame() {

	}

	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(255, 0, 255));
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2d.setColor(new Color(0, 0, 0));
		g2d.setFont(new Font("Impact", Font.BOLD, this.getWidth() / 5));
		g2d.drawString(CurrentGame.name, this.getWidth() / -200, this.getHeight() / 2 - 50);

	}

}
