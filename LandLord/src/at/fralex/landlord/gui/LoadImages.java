package at.fralex.landlord.gui;

import java.awt.Image;

import at.fralex.landlord.util.Utils;

public class LoadImages {
	
	public static Image gridBackground = Utils.loadImage("res/game/BackgroundGrid.png");
	public static Image shopButton = Utils.loadImage("res/game/screen/ShopButton.png");
	public static Image shopBackground = Utils.loadImage("res/game/screen/ShopBackground.png");
	
	public static Image[][] objectNexus = { { Utils.loadImage("res/game/objects/nexus/nexus0.png") } };
	
	
	
	public static Image[][] objectRoad = new Image[1][16];
	 
	
	
	public static void loadImages() {
		
		for (int i = 0; i < 16; i++) {
			objectRoad[0][i] = Utils.loadImage("res/game/objects/road/road"+i+".png");
			System.out.println("res/game/objects/road/road"+i+".png");
		}
		
		
		
	}
	

}