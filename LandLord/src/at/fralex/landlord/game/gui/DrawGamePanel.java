package at.fralex.landlord.game.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

import at.fralex.landlord.gui.LoadImages;

public class DrawGamePanel {

	public static void drawGamePanel(Graphics2D g2d, int width, int height, ImageObserver iob) {

		g2d.setColor(Color.BLUE);
		g2d.fillRect(0, 0, width, 50);
		g2d.fillRect(0, height, width, -100);

		g2d.drawImage(LoadImages.shopButton, 25, height - 75, iob);

	}

}