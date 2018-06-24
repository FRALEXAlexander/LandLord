package at.fralex.landlord.game.gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import at.fralex.landlord.game.CurrentGame;
import at.fralex.landlord.game.GameUtils;
import at.fralex.landlord.game.Inputs;
import at.fralex.landlord.gui.LoadImages;
import at.fralex.landlord.main.Main;

public class DrawShop {

	public static void drawShop(Graphics2D g2d, ImageObserver iob) {

		g2d.drawImage(LoadImages.shopBackground, Main.panelContainer.getWidth() / 2 - 400,
				Main.panelContainer.getHeight() / 2 - 275, iob);

		g2d.drawImage(LoadImages.objectNexus[0][0], Main.panelContainer.getWidth() / 2 - 400 + 50,
				Main.panelContainer.getHeight() / 2 - 275 + 50, iob);
		g2d.drawImage(LoadImages.objectRoad[0][0], Main.panelContainer.getWidth() / 2 - 400 + 124,
				Main.panelContainer.getHeight() / 2 - 275 + 50, iob);

	}

	public static void drawIconAtCursor(Graphics2D g2d, Image img) {

		int[] pos = GameUtils.getGridPos(Inputs.currentX, Inputs.currentY);

		if (img == null || pos == null) {
			return;
		}

		g2d.drawImage(img, pos[0] * CurrentGame.grid.gridSize, pos[1] * CurrentGame.grid.gridSize,
				Main.panelContainer.game);
	}

}