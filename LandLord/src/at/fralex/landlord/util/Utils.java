package at.fralex.landlord.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import at.fralex.landlord.game.CurrentGame;
import at.fralex.landlord.game.objects.GridObject;
import at.fralex.landlord.game.objects.ObjectRoad;
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
	
	

	public static Image updateScale(Image image, int scale) {
		
		
		return image.getScaledInstance(CurrentGame.gridSizeBase * scale, -1, Image.SCALE_REPLICATE);
		
		
	}

	public static void updateScale() {
		LoadImages.objectNexus[0][0] = LoadImages.objectNexus[0][0].getScaledInstance(CurrentGame.grid.gridSize, -1, Image.SCALE_REPLICATE);
		
		
		for (int i = 0; i < LoadImages.objectRoad[0].length; i++) {
			
		
		LoadImages.objectRoad[0][i] = LoadImages.objectRoad[0][i].getScaledInstance(CurrentGame.grid.gridSize, -1, Image.SCALE_REPLICATE);
		}
		
		
		LoadImages.gridBackground = LoadImages.gridBackground.getScaledInstance(CurrentGame.grid.gridSize, -1, Image.SCALE_REPLICATE);
		
	}

	public static void updateRoadTexture(ObjectRoad road) {
		
		boolean[] sides = { false, false, false, false };

		// oben
		try {
			if (CurrentGame.grid.objects[road.getGridX()][road.getGridY() - 1] != null) {
				sides[0] = true;
			} else {
				sides[0] = false;
			}
		} catch (Exception e) {
			sides[0] = false;
		};
		// rechts
		try {
		if (CurrentGame.grid.objects[road.getGridX() + 1][road.getGridY()] != null) {
			sides[1] = true;
		} else {
			sides[1] = false;
		}
		} catch (Exception e) {
			sides[1] = false;
		};
		// unten
		try {
		if (CurrentGame.grid.objects[road.getGridX()][road.getGridY() + 1] != null) {
			sides[2] = true;
		} else {
			sides[2] = false;
		}
		} catch (Exception e) {
			sides[2] = false;
		};
		// links
		try {
		if (CurrentGame.grid.objects[road.getGridX() - 1][road.getGridY()] != null) {
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
		
		road.setObjectImage(LoadImages.objectRoad[road.getOBJECTLEVEL()][graphic]);
		System.out.println(graphic);
		
		
		
	}
	
	
}
