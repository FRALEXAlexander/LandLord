package at.fralex.landlord.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

import at.fralex.landlord.game.CurrentGame;
import at.fralex.landlord.game.GameUtils;
import at.fralex.landlord.game.Inputs;
import at.fralex.landlord.game.gui.DrawGamePanel;
import at.fralex.landlord.game.gui.DrawGrid;
import at.fralex.landlord.game.gui.DrawShop;
import at.fralex.landlord.main.Main;

public class PanelGame extends JPanel implements ActionListener {

	private Inputs inputs = new Inputs();

	private Timer timer;

	public PanelGame() {

		timer = new Timer(30, this);
		timer.start();

		this.addMouseMotionListener(inputs);
		this.addMouseListener(inputs);

	}

	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		DrawGrid.drawGrid(g2d, this);
		DrawGamePanel.drawGamePanel(g2d, this.getWidth(), this.getHeight(),this);

		if (CurrentGame.showShop) {
			DrawShop.drawShop(g2d, this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

}