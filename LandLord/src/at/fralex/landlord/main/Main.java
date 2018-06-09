package at.fralex.landlord.main;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import at.fralex.landlord.gui.FrameMain;
import at.fralex.landlord.gui.PanelContainer;
import at.fralex.landlord.util.CreateIcon;

public class Main {
	public static PanelContainer panelContainer = new PanelContainer();
	public static FrameMain mainFrame = new FrameMain();

	
	public static void main(String[] args) {
		
		CreateIcon.createIcon("This is a Test", new File("res/test.png"), "Impact", 2500,400,"test");
	}

}
