package at.fralex.landlord.game;

import at.fralex.landlord.main.Main;

public class GameUtils {

	public static int[] getGridPos(int xPos, int yPos) {
		
		Grid grid = CurrentGame.grid;
		
		if (yPos > 50 && yPos < Main.panelContainer.getHeight() - 100 && !CurrentGame.showShop) {
			int gridX = -1;
			int gridY = -1;
			for (int i = 0; i < grid.objects.length; i++) {
				if (xPos > i * grid.gridSize + grid.gridXPos && xPos < i * grid.gridSize + grid.gridSize + grid.gridXPos) {
					gridX = i;
				}
			}

			for (int i = 0; i < grid.objects.length; i++) {
				if (yPos > i * grid.gridSize + grid.gridYPos && yPos < i * grid.gridSize + grid.gridSize + grid.gridYPos) {
					gridY = i;
				}
			}

			int[] out = { gridX, gridY };
			return out;
		}

		return null;
	}

}