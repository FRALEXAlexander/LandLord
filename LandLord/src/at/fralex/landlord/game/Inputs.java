package at.fralex.landlord.game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import at.fralex.landlord.game.objects.GridObject;
import at.fralex.landlord.game.objects.ObjectNexus;
import at.fralex.landlord.game.objects.ObjectRoad;
import at.fralex.landlord.gui.LoadImages;
import at.fralex.landlord.main.Main;
import at.fralex.landlord.util.Utils;

public class Inputs implements MouseMotionListener, MouseListener, MouseWheelListener {

	int clickedX, clickedY, correctX, correctY;

	public static int currentX;

	public static int currentY;
	boolean newClick;

	private static boolean falseClick = true;

	public static void clicked(int xPos, int yPos) {

		if (CurrentGame.showShop && xPos > Main.panelContainer.getWidth() / 2 - 400
				&& xPos < Main.panelContainer.getWidth() / 2 + 400 && yPos > Main.panelContainer.getHeight() / 2 - 275
				&& yPos < Main.panelContainer.getHeight() / 2 + 275) {
			clickInShop(xPos, yPos);
		}

		if (xPos > 25 && xPos < 125 && yPos < Main.panelContainer.getHeight() - 25
				&& yPos > Main.panelContainer.getHeight() - 75) {

			if (CurrentGame.showShop == false) {

				CurrentGame.showShop = true;
				CurrentGame.objcetToPlace = null;

			} else {
				CurrentGame.showShop = false;
			}
			return;
		}

		if (CurrentGame.objcetToPlace != null) {

			if (falseClick) {
				falseClick = false;
				return;
			}

			int[] out = GameUtils.getGridPos(xPos, yPos);
			System.out.println(CurrentGame.objcetToPlace.getName());
			if (CurrentGame.objcetToPlace.getName() == "nexus") {
				System.out.println(true);
				CurrentGame.grid.objects[out[0]][out[1]] = new GridObject(new ObjectNexus(0, out[0], out[1]));
				CurrentGame.objcetToPlace = null;
			}else if (CurrentGame.objcetToPlace.getName() == "road") {
				CurrentGame.grid.objects[out[0]][out[1]] = new GridObject(new ObjectRoad(0, out[0], out[1]));
				CurrentGame.objcetToPlace = null;
			}
			falseClick = true;
		}

	}

	private static void clickInShop(int xPos, int yPos) {

		if (Utils.isPointInRect(xPos, yPos, Main.panelContainer.getWidth() / 2 - 400 + 50,
				Main.panelContainer.getHeight() / 2 - 275 + 50, 64, 64)) {

			CurrentGame.objcetToPlace = new GridObject(new ObjectNexus(0,0,0));
		} else if (Utils.isPointInRect(xPos, yPos, Main.panelContainer.getWidth() / 2 - 400 + 124,
				Main.panelContainer.getHeight() / 2 - 275 + 50, 64, 64)) {

			CurrentGame.objcetToPlace = new GridObject(new ObjectRoad(0,0,0));;
		}
		CurrentGame.showShop = false;

	}

	@Override
	public void mouseDragged(MouseEvent e) {

		currentX = e.getX();
		currentY = e.getY();

		if (e.getY() > 50 && e.getY() < Main.panelContainer.game.getHeight() - 100 && !CurrentGame.showShop) {

			if (CurrentGame.showShop && e.getX() < 200) {
				return;
			}

			if (newClick) {
				newClick = false;
				correctX = CurrentGame.grid.gridXPos - clickedX;
				correctY = CurrentGame.grid.gridYPos - clickedY;
			}

			CurrentGame.grid.setX(e.getX() + correctX);
			CurrentGame.grid.setY(e.getY() + correctY);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {

		currentX = e.getX();
		currentY = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		Inputs.clicked(e.getX(), e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		clickedX = e.getX();
		clickedY = e.getY();

		newClick = true;

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getWheelRotation()==1 && CurrentGame.zoom>1) {
			CurrentGame.zoom--;
		}else if(e.getWheelRotation()==-1 && CurrentGame.zoom<3) {
			CurrentGame.zoom++;
		}
		
		CurrentGame.grid.gridSize = CurrentGame.zoom * CurrentGame.gridSizeBase;
		
		Utils.updateScale();
		
		
	}

}