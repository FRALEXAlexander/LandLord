package at.fralex.landlord.game.objects;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

import javax.rmi.CORBA.Util;

import at.fralex.landlord.util.Utils;

public class GridObject {

	private String OBJECT;
	private int MAPLEVEL;
	private int OBJECTLEVEL;
	private int GRIDX;
	private int GRIDY;

	private ObjectNexus objNexus;
	private ObjectMine objMine;
	private ObjectRoad objRoad;

	public GridObject(String object, int mapLevel, int objectLevel, int gridX, int gridY) {

		OBJECT = object;
		MAPLEVEL = mapLevel;
		OBJECTLEVEL = objectLevel;
		GRIDX = gridX;
		GRIDY = gridY;
		loadObject();

		Runnable run = new Runnable() {

			@Override
			public void run() {
				while (true) {
					Utils.sleep(1000);
				}
			}
		};

		Thread thread = new Thread(run);
		thread.start();

	}

	public void drawObject(Graphics2D g2d, int mapLevel, ImageObserver iob) {

		if (mapLevel == 0) {
			switch (OBJECT) {
			case "nexus":
				objNexus.draw(g2d, iob);
				;
				break;
			case "mine":
				objMine.draw(g2d);
				break;
			case "road":
				objRoad.draw(g2d, iob);
				break;
					
			default:
				break;
			}
		}
	}

	private void loadObject() {

		switch (OBJECT) {
		case "nexus":
			objNexus = new ObjectNexus(OBJECTLEVEL, GRIDX, GRIDY);
			break;
		case "mine":
			objMine = new ObjectMine(OBJECTLEVEL);
			break;
		case "road":
			objRoad = new ObjectRoad(OBJECTLEVEL, GRIDX, GRIDY);
			break;

		default:
			break;
		}

	}

}
