package at.fralex.landlord.game.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import at.fralex.landlord.game.CurrentGame;

public class ObjectNexus {

	private int GRIDX;
	private int GRIDY;
	private int OBJECTLEVEL;
	BufferedImage icon ;
	public ObjectNexus(int objectLevel, int gridX, int gridY) {
		GRIDX = gridX;
		GRIDY = gridY;
		OBJECTLEVEL = objectLevel;
	}

	public void draw(Graphics2D g2d, ImageObserver iob) {

		switch (OBJECTLEVEL) {
		case 1:
			
			try {
				icon = ImageIO.read(new File("res/game/objects/nexus/nexus0.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g2d.drawImage(icon, GRIDX * CurrentGame.grid.gridSize, GRIDY * CurrentGame.grid.gridSize,iob);
			
			break;

		default:
			break;
		}

	}

}
