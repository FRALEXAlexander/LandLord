package at.fralex.landlord.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import at.fralex.landlord.main.GUIControll;
import at.fralex.landlord.main.Main;
import at.fralex.landlord.main.Menu;

public class PanelMainMenu extends JPanel {

	public ButtonStandard exit,gameMenu;
	boolean firstRun;

	public PanelMainMenu() {

		firstRun = true;
		this.setLayout(null);

		exit = new ButtonStandard("Exit");
		gameMenu = new ButtonStandard("SinglePlayer");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Menu.exit();
			}
		});
		
		gameMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIControll.showPanel("gameMenu");
			}
		});
		this.add(exit);
		this.add(gameMenu);
		
	}

	@Override
	protected void paintComponent(Graphics g) {

		if (firstRun) {
			firstRun = false;

		}

		exit.setBounds(this.getWidth() / 2 - 150, this.getHeight() / 4 * 3, 300, 100);
		gameMenu.setBounds(this.getWidth() / 2 - 150, this.getHeight() / 4 * 2, 300, 100);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(123, 200, 80));
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2d.setColor(new Color(123, 0, 80));
		g2d.setFont(new Font("Impact", Font.BOLD, this.getWidth() / 5));
		g2d.drawString("LandLord", this.getWidth() / 12, this.getHeight() / 3);
	}
}
