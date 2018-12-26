package at.fralex.landlord.game.objects;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import at.fralex.landlord.game.CurrentGame;
import at.fralex.landlord.gui.LoadImages;

public class ObjectRoad extends GridObject{

	private int gridX;
	




	private int gridY;
	private int OBJECTLEVEL;
	private String name;
	public ObjectRoad(int objectLevel, int gridX, int gridY) {
		this.name = "road";
		this.gridX = gridX;
		this.gridY = gridY;
		OBJECTLEVEL = objectLevel;
		
	}
	@Override
	public String getName() {
		return this.name;
	}

	public int getGridX() {
		return gridX;
	}
	@Override
	public void setGridX(int gridX) {
		this.gridX = gridX;
	}
	public int getGridY() {
		return gridY;
	}
	@Override
	public void setGridY(int gridY) {
		this.gridY = gridY;
	}


	public void draw(Graphics2D g2d, ImageObserver iob) {

		g2d.drawImage(LoadImages.objectRoad[OBJECTLEVEL][0], this.gridX * CurrentGame.grid.gridSize,
				this.gridY * CurrentGame.grid.gridSize, iob);

	}

}