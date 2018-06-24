package at.fralex.landlord.game;

import at.fralex.landlord.game.objects.GridObject;
import at.fralex.landlord.main.Main;

public class Grid {

	public GridObject[][] objects;
	public int gridXPos, gridYPos, gridSize;

	public Grid(int gridWidth, int gridHeight, int gridsize) {
		
		gridSize = gridsize;
		objects = new GridObject[gridWidth][gridHeight];

	}

	public void setX(int X) {
		gridXPos = X;

		if (gridXPos < -objects.length * gridSize + Main.panelContainer.getWidth()) {
			gridXPos = -objects.length * gridSize + Main.panelContainer.getWidth();
		} else if (gridXPos > 0) {
			gridXPos = 0;
		}
	}

	public void setY(int Y) {
		gridYPos = Y;

		if (gridYPos < -objects[0].length * gridSize + Main.panelContainer.getHeight() - 100) {
			gridYPos = -objects[0].length * gridSize + Main.panelContainer.getHeight() - 100;
		} else if (gridYPos > 50) {
			gridYPos = 50;
		}
	}

}