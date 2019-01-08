package at.fralex.landlord.game.objects;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

import at.fralex.landlord.util.Utils;

public class GridObject {

	private GridObject object;
	private String name;
	private int gridX;
	private int gridY;
	
	protected Thread thread;
	
	public GridObject() {
		
	}
	
	
	public GridObject getObject() {
		return object;
	}


	public GridObject(GridObject object) {

		this.object = object;
		
		this.name = object.getName();
		
		
		Runnable run = new Runnable() {

			@Override
			public void run() {
				while (true) {
					Utils.sleep(1000);
					object.runtime();
				}
			}
		};

		thread = new Thread(run);
		thread.start();

	}
	
	protected void runtime() {
		
	}

	public void drawObject(Graphics2D g2d,ImageObserver iob) {
		
		this.object.draw(g2d, iob);
		
	}
	
	
	protected void draw(Graphics2D g2d, ImageObserver iob) {
		
	}


	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	public void setPos(int gridX,int gridY) {
		
		this.object.setGridX(gridX);
		this.object.setGridY(gridY);
		
	}


	public void setGridX(int gridX) {
		// TODO Auto-generated method stub
		
	}


	public void setGridY(int gridY) {
		// TODO Auto-generated method stub
		
	}


	public int getGridX() {
		return gridX;
	}


	public int getGridY() {
		return gridY;
	}
	
}