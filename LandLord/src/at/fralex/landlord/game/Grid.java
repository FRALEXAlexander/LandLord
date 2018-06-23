package at.fralex.landlord.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import at.fralex.landlord.game.objects.GridObject;
import at.fralex.landlord.gui.LoadImages;
import at.fralex.landlord.gui.PanelGame;
import at.fralex.landlord.main.Main;

public class Grid {

	public GridObject[][] grid;
	public int gridXPos, gridYPos;
	Random random;
	boolean firstRun;
	public boolean falseClick;
	public int gridSize;

	BufferedImage gridBackground = null;

	public Grid() {
		gridSize = 64;
		random = new Random();
		grid = new GridObject[30][20];
		firstRun = true;
		
		try {
			gridBackground = ImageIO.read(new File("res/game/BackgroundGrid.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setX(int X) {
		gridXPos = X;

		if (gridXPos < -grid.length * gridSize + Main.panelContainer.getWidth()) {
			gridXPos = -grid.length * gridSize + Main.panelContainer.getWidth();
		} else if (gridXPos > 0) {
			gridXPos = 0;
		}
	}

	public void setY(int Y) {
		gridYPos = Y;

		if (gridYPos < -grid[0].length * gridSize + Main.panelContainer.getHeight() - 100) {
			gridYPos = -grid[0].length * gridSize + Main.panelContainer.getHeight() - 100;
		} else if (gridYPos > 50) {
			gridYPos = 50;
		}
	}

	public void draw(Graphics2D g2d, ImageObserver iob) {

		AffineTransform transform = new AffineTransform();
		transform.translate(CurrentGame.grid.gridXPos, CurrentGame.grid.gridYPos);

		AffineTransform saveAT = g2d.getTransform();

		g2d.transform(transform);

		g2d.setFont(new Font("Impact", Font.BOLD, 20));
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {

				g2d.drawImage(gridBackground, i * gridSize, j * gridSize, iob);
			}
		}

		g2d.setColor(Color.BLACK);

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				if (grid[i][j] != null) {
					grid[i][j].drawObject(g2d, 0, iob);
				}
			}
		}

		PanelGame.drawIconAtCursor(g2d, CurrentGame.iconToDrawAtCursor);

		g2d.setTransform(saveAT);
	}

	public int[] getGridPos(int xPos, int yPos) {
		if (yPos > 50 && yPos < Main.panelContainer.getHeight() - 100 && !Main.panelContainer.game.showShop) {
			int gridX = -1;
			int gridY = -1;
			for (int i = 0; i < grid.length; i++) {
				if (xPos > i * gridSize + gridXPos && xPos < i * gridSize + gridSize + gridXPos) {
					gridX = i;
				}
			}

			for (int i = 0; i < grid.length; i++) {
				if (yPos > i * gridSize + gridYPos && yPos < i * gridSize + gridSize + gridYPos) {
					gridY = i;
				}
			}
			System.out.println(gridX + " " + gridY);
			int[] out = { gridX, gridY };
			return out;
		}

		return null;
	}

	public void clicked(int xPos, int yPos) {

		if (xPos > 25 && xPos < 125 && yPos < Main.panelContainer.getHeight() - 25
				&& yPos > Main.panelContainer.getHeight() - 75) {

			if (Main.panelContainer.game.showShop == false) {

				Main.panelContainer.game.showShop = true;
				CurrentGame.iconToDrawAtCursor = null;

			} else {
				Main.panelContainer.game.showShop = false;
			}
			return;
		}

		if (CurrentGame.iconToDrawAtCursor != null) {
			
			if(falseClick) {
				falseClick = false;
				return;
			}
			
			int[] out = getGridPos(xPos, yPos);

			if (CurrentGame.iconToDrawAtCursor == (LoadImages.objectNexus[0][0])) {
				System.out.println(true);
				CurrentGame.grid.grid[out[0]][out[1]] = new GridObject("nexus", 0, 0, out[0], out[1]);
				CurrentGame.iconToDrawAtCursor = null;
			}else if(CurrentGame.iconToDrawAtCursor == (LoadImages.objectRoad[0][0])) {
				CurrentGame.grid.grid[out[0]][out[1]] = new GridObject("road", 0, 0, out[0], out[1]);
				CurrentGame.iconToDrawAtCursor = null;
			}
		}
	}
}