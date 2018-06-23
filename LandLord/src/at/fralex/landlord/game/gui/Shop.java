package at.fralex.landlord.game.gui;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

import javax.rmi.CORBA.Util;

import at.fralex.landlord.game.CurrentGame;
import at.fralex.landlord.gui.LoadImages;
import at.fralex.landlord.main.Main;
import at.fralex.landlord.util.Utils;

public class Shop {

	public static void drawShop(Graphics2D g2d, ImageObserver iob) {

		g2d.drawImage(LoadImages.shopBackground, Main.panelContainer.getWidth() / 2 - 400,
				Main.panelContainer.getHeight() / 2 - 275, iob);

		g2d.drawImage(LoadImages.objectNexus[0][0], Main.panelContainer.getWidth() / 2 - 400 + 50,
				Main.panelContainer.getHeight() / 2 - 275 + 50, iob);
		g2d.drawImage(LoadImages.objectRoad[0][0], Main.panelContainer.getWidth() / 2 - 400 + 124,
				Main.panelContainer.getHeight() / 2 - 275 + 50, iob);

	}

	public static void clickInShop(int xPos, int yPos) {

		if (Utils.isPointInRect(xPos, yPos, Main.panelContainer.getWidth() / 2 - 400 + 50,
				Main.panelContainer.getHeight() / 2 - 275 + 50, 64, 64)) {

			CurrentGame.iconToDrawAtCursor = LoadImages.objectNexus[0][0];
		} else if (Utils.isPointInRect(xPos, yPos, Main.panelContainer.getWidth() / 2 - 400 + 124,
				Main.panelContainer.getHeight() / 2 - 275 + 50, 64, 64)) {

			CurrentGame.iconToDrawAtCursor = LoadImages.objectRoad[0][0];
		}
		Main.panelContainer.game.showShop = false;
		CurrentGame.grid.falseClick = true;
	}

}
