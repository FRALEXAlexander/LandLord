package at.fralex.landlord.game.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

import at.fralex.landlord.game.CurrentGame;
import at.fralex.landlord.game.objects.GridObject;
import at.fralex.landlord.gui.LoadImages;
import at.fralex.landlord.gui.PanelGame;

public class DrawGrid {

	public static void drawGrid(Graphics2D g2d, ImageObserver iob) {

		GridObject[][] objects = CurrentGame.grid.objects;

		AffineTransform transform = new AffineTransform();
		transform.translate(CurrentGame.grid.gridXPos, CurrentGame.grid.gridYPos);
		
		
		
		AffineTransform saveAT = g2d.getTransform();

		g2d.transform(transform);

		g2d.setFont(new Font("Impact", Font.BOLD, 20));
		for (int i = 0; i < objects.length; i++) {
			for (int j = 0; j < objects[i].length; j++) {

				g2d.drawImage(LoadImages.gridBackground, i * CurrentGame.grid.gridSize, j * CurrentGame.grid.gridSize,
						iob);
			}
		}

		g2d.setColor(Color.BLACK);

		for (int i = 0; i < objects.length; i++) {
			for (int j = 0; j < objects[0].length; j++) {

				if (objects[i][j] != null) {
					objects[i][j].drawObject(g2d, 0, iob);
				}
			}
		}

		DrawShop.drawIconAtCursor(g2d, CurrentGame.iconToDrawAtCursor);

		g2d.setTransform(saveAT);
		
		
	}

}