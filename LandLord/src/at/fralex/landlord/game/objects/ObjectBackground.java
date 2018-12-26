package at.fralex.landlord.game.objects;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import at.fralex.landlord.game.CurrentGame;
import at.fralex.landlord.gui.LoadImages;

public class ObjectBackground extends GridObject{

	private int GRIDX;
	private int GRIDY;
	private int OBJECTLEVEL;

	public ObjectBackground(int objectLevel, int gridX, int gridY) {
		
		GRIDX = gridX;
		GRIDY = gridY;
		OBJECTLEVEL = objectLevel;
		
	}
	@Override
	protected void draw(Graphics2D g2d, ImageObserver iob) {

		g2d.drawImage(LoadImages.gridBackground, GRIDX * CurrentGame.grid.gridSize,
				GRIDY * CurrentGame.grid.gridSize, iob);

	}

}