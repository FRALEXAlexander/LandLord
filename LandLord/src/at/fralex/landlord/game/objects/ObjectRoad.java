package at.fralex.landlord.game.objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import at.fralex.landlord.game.CurrentGame;
import at.fralex.landlord.game.GameUtils;
import at.fralex.landlord.gui.LoadImages;
import at.fralex.landlord.util.Utils;

public class ObjectRoad extends GridObject {

	private int gridX;

	private int gridY;
	private int OBJECTLEVEL;
	private String name;
	private Image objectImage;

	public ObjectRoad(int objectLevel, int gridX, int gridY) {
		this.name = "road";
		this.gridX = gridX;
		this.gridY = gridY;
		setOBJECTLEVEL(objectLevel);
		setObjectImage(LoadImages.objectRoad[getOBJECTLEVEL()][0]);
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

		g2d.drawImage(getObjectImage(), this.gridX * CurrentGame.grid.gridSize,
				this.gridY * CurrentGame.grid.gridSize, iob);

	}

	protected void runtime() {
		Utils.updateRoadTexture(this);
	}

	public int getOBJECTLEVEL() {
		return OBJECTLEVEL;
	}

	public void setOBJECTLEVEL(int oBJECTLEVEL) {
		OBJECTLEVEL = oBJECTLEVEL;
	}

	public Image getObjectImage() {
		return objectImage;
	}

	public void setObjectImage(Image objectImage) {
		this.objectImage = objectImage;
	}

}