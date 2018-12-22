package at.fralex.landlord.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import at.fralex.landlord.game.CurrentGame;
import at.fralex.landlord.gui.LoadImages;

public class Utils {

	public static Image loadImage(String filepath) {

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;

	}

	public static boolean isPointInRect(int xPos, int yPos, int x, int y, int width, int height) {
		return (xPos >= x) && (xPos <= x + width) && (yPos >= height) && (y <= y + height);

	}

	public static void sleep(int time) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public static void updateScale() {
		
		LoadImages.gridBackground = LoadImages.gridBackground.getScaledInstance(CurrentGame.grid.gridSize, -1, Image.SCALE_REPLICATE);
		LoadImages.objectNexus[0][0] = LoadImages.objectNexus[0][0].getScaledInstance(CurrentGame.grid.gridSize, -1, Image.SCALE_REPLICATE);
		LoadImages.objectRoad[0][0] = LoadImages.objectRoad[0][0].getScaledInstance(CurrentGame.grid.gridSize, -1, Image.SCALE_REPLICATE);
		
	}
	
}
