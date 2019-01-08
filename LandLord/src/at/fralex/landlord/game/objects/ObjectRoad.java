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
		OBJECTLEVEL = objectLevel;
		objectImage = LoadImages.objectRoad[OBJECTLEVEL][0];
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

		g2d.drawImage(objectImage, this.gridX * CurrentGame.grid.gridSize,
				this.gridY * CurrentGame.grid.gridSize, iob);

	}

	protected void runtime() {
		boolean[] sides = { false, false, false, false };

		// oben
		try {
			if (CurrentGame.grid.objects[this.gridX][this.gridY - 1] != null) {
				sides[0] = true;
			} else {
				sides[0] = false;
			}
		} catch (Exception e) {
			sides[0] = false;
		};
		// rechts
		try {
		if (CurrentGame.grid.objects[this.gridX + 1][this.gridY] != null) {
			sides[1] = true;
		} else {
			sides[1] = false;
		}
		} catch (Exception e) {
			sides[1] = false;
		};
		// unten
		try {
		if (CurrentGame.grid.objects[this.gridX][this.gridY + 1] != null) {
			sides[2] = true;
		} else {
			sides[2] = false;
		}
		} catch (Exception e) {
			sides[2] = false;
		};
		// links
		try {
		if (CurrentGame.grid.objects[this.gridX - 1][this.gridY] != null) {
			sides[3] = true;
		} else {
			sides[3] = false;
		}
		} catch (Exception e) {
			sides[3] = false;
		};
		for (int j = 0; j < sides.length; j++) {
			System.out.print(sides[j] + " ");
		}
		System.out.println();
		
		int graphic = 0;
		
		if(sides[0]) {
			graphic+=1;
		}
		if(sides[1]) {
			graphic+=2;
		}
		if(sides[2]) {
			graphic+=4;
		}
		if(sides[3]) {
			graphic+=8;
		}
		
		objectImage = LoadImages.objectRoad[OBJECTLEVEL][graphic];
		System.out.println(graphic);
		
	}

}