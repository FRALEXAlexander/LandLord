package at.fralex.landlord.game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import at.fralex.landlord.game.objects.GridObject;
import at.fralex.landlord.gui.LoadImages;
import at.fralex.landlord.main.Main;
import at.fralex.landlord.util.Utils;

public class Inputs implements MouseMotionListener, MouseListener {

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
				CurrentGame.iconToDrawAtCursor = null;

			} else {
				CurrentGame.showShop = false;
			}
			return;
		}

		if (CurrentGame.iconToDrawAtCursor != null) {

			if (falseClick) {
				falseClick = false;
				return;
			}

			int[] out = GameUtils.getGridPos(xPos, yPos);

			if (CurrentGame.iconToDrawAtCursor == (LoadImages.objectNexus[0][0])) {
				System.out.println(true);
				CurrentGame.grid.objects[out[0]][out[1]] = new GridObject("nexus", 0, 0, out[0], out[1]);
				CurrentGame.iconToDrawAtCursor = null;
			} else if (CurrentGame.iconToDrawAtCursor == (LoadImages.objectRoad[0][0])) {
				CurrentGame.grid.objects[out[0]][out[1]] = new GridObject("road", 0, 0, out[0], out[1]);
				CurrentGame.iconToDrawAtCursor = null;
			}
			falseClick = true;
		}

	}

	private static void clickInShop(int xPos, int yPos) {

		if (Utils.isPointInRect(xPos, yPos, Main.panelContainer.getWidth() / 2 - 400 + 50,
				Main.panelContainer.getHeight() / 2 - 275 + 50, 64, 64)) {

			CurrentGame.iconToDrawAtCursor = LoadImages.objectNexus[0][0];
		} else if (Utils.isPointInRect(xPos, yPos, Main.panelContainer.getWidth() / 2 - 400 + 124,
				Main.panelContainer.getHeight() / 2 - 275 + 50, 64, 64)) {

			CurrentGame.iconToDrawAtCursor = LoadImages.objectRoad[0][0];
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

}