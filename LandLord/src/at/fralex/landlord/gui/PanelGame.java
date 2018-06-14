package at.fralex.landlord.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import at.fralex.landlord.game.CurrentGame;

public class PanelGame extends JPanel implements ActionListener, MouseMotionListener, MouseListener {

	int clickedX, clickedY, correctX,correctY ;
	
	Timer timer;
	
	
	boolean newClick;

	public PanelGame() {
		timer = new Timer(30, this);
		timer.start();
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		
		newClick = false;
		
	}

	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(0, 255, 255));
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2d.setColor(new Color(0, 0, 0));
		g2d.setFont(new Font("Impact", Font.BOLD, this.getWidth() / 5));
		g2d.drawString(CurrentGame.name, this.getWidth() / -200, this.getHeight() / 2 - 50);
		g2d.fillRect(300, 300, 48, 48);
		CurrentGame.grid.draw(g2d);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		
		
		if(newClick) {
			newClick = false;
			correctX = CurrentGame.grid.x - clickedX;
			correctY = CurrentGame.grid.y - clickedY;
		}
		
		
		
		CurrentGame.grid.setX(e.getX() + correctX);
		CurrentGame.grid.setY( e.getY() + correctY);

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {

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
