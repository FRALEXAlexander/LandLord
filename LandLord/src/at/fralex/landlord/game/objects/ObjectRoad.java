package at.fralex.landlord.game.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import at.fralex.landlord.game.CurrentGame;
import at.fralex.landlord.gui.LoadImages;

public class ObjectRoad {

	private int GRIDX;
	private int GRIDY;
	private int OBJECTLEVEL;
	BufferedImage icon;

	public ObjectRoad(int objectLevel, int gridX, int gridY) {
		GRIDX = gridX;
		GRIDY = gridY;
		OBJECTLEVEL = objectLevel;
	}

	public void draw(Graphics2D g2d, ImageObserver iob) {

		g2d.drawImage(LoadImages.objectRoad[OBJECTLEVEL][0], GRIDX * CurrentGame.grid.gridSize,
				GRIDY * CurrentGame.grid.gridSize, iob);

	}

}