package at.fralex.landlord.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import at.fralex.landlord.game.CurrentGame;

public class PanelGame extends JPanel implements ActionListener, MouseMotionListener, MouseListener {

	int clickedX, clickedY, correctX, correctY;

	Timer timer;

	boolean newClick;

	public boolean showShop;

	public PanelGame() {

		timer = new Timer(30, this);
		timer.start();
		this.addMouseMotionListener(this);
		this.addMouseListener(this);

		newClick = false;
		showShop = false;
	}

	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(new Color(0, 255, 255));
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

		CurrentGame.grid.draw(g2d, this);

		g2d.setColor(Color.BLUE);
		g2d.fillRect(0, 0, this.getWidth(), 50);
		g2d.fillRect(0, this.getHeight(), this.getWidth(), -100);
		g2d.setColor(Color.GRAY);

		BufferedImage shopIcon = null;
		try {
			shopIcon = ImageIO.read(new File("res/game/screen/ShopIcon.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		g2d.drawImage(shopIcon, 25, this.getHeight() - 75, this);
		if (showShop) {
			g2d.fillRect(0, 50, 200, this.getHeight() - 150);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		if (e.getY() > 50 && e.getY() < this.getHeight() - 100) {
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
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		CurrentGame.grid.clicked(e.getX(), e.getY());
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
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

}
