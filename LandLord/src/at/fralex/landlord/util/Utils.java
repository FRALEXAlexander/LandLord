package at.fralex.landlord.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
