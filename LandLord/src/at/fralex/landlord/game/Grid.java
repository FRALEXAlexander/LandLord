package at.fralex.landlord.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Random;

import at.fralex.landlord.main.Main;

public class Grid {

	private String[][][] grid;
	public int x, y,width,height;
	Random random;
	boolean firstRun;

	public Grid() {

		random = new Random();
		grid = new String[30][30][1];
		firstRun = true;
		
		width = 48*10;
		height = 48 * 10;
	}

	public void setX(int X) {
		x =  X;
		
		if (x < -grid.length * 48 + Main.panelContainer.getWidth() ) {
			x = -grid.length * 48 + Main.panelContainer.getWidth();
		} 
		else if (x > 0) {
			x = 0 ;
		}
	}

	public void setY(int Y) {
		y =  Y;
		
		
		if (y < -grid.length * 48 + Main.panelContainer.getHeight() ) {
			y = -grid.length * 48 + Main.panelContainer.getHeight();
		} 
		else if (y > 0) {
			y = 0 ;
		}
	}

	public void draw(Graphics2D g2d) {
		g2d.setFont(new Font("Impact", Font.BOLD, 20));
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {

				if (firstRun) {

					g2d.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
					
				}

				g2d.fillRect(x + i * 48, y + j * 48, 48, 48);
				
			}
		}
		g2d.setColor(Color.BLACK);
				g2d.drawString("1", x+20, y+20);
				g2d.drawString("1", x +48*30 -20, y + 48*30 -20);
		// firstRun = false;

	}
}
