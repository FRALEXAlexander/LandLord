package at.fralex.landlord.game.gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import at.fralex.landlord.game.CurrentGame;
import at.fralex.landlord.game.GameUtils;
import at.fralex.landlord.game.Inputs;
import at.fralex.landlord.gui.LoadImages;
import at.fralex.landlord.main.Main;
import at.fralex.landlord.util.Utils;

public class DrawShop {

	public static void drawShop(Graphics2D g2d, ImageObserver iob) {
		
		
		
		g2d.drawImage(LoadImages.shopBackground, Main.panelContainer.getWidth() / 2 - 400,
				Main.panelContainer.getHeight() / 2 - 275, iob);
		
		g2d.drawImage(Utils.updateScale(LoadImages.objectNexus[0][0],1), Main.panelContainer.getWidth() / 2 - 400 + 50,
				Main.panelContainer.getHeight() / 2 - 275 + 50, iob);
		
		g2d.drawImage(Utils.updateScale(LoadImages.objectRoad[0][0],1), Main.panelContainer.getWidth() / 2 - 400 + 124,
				Main.panelContainer.getHeight() / 2 - 275 + 50, iob);
		
		

	}

	public static void drawIconAtCursor(Graphics2D g2d, ImageObserver iob) {

		int[] pos = GameUtils.getGridPos(Inputs.currentX, Inputs.currentY);

		if(CurrentGame.objcetToPlace == null) {
			return;
		}
		
		
		
		CurrentGame.objcetToPlace.setPos(pos[0], pos[1]);
		CurrentGame.objcetToPlace.drawObject(g2d, iob);
	}

}