		package at.fralex.landlord.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import at.fralex.landlord.main.GUIControll;
import at.fralex.landlord.main.Main;
import at.fralex.landlord.main.Menu;

public class PanelMainMenu extends JPanel {

	public ButtonStandard exit,gameMenuSP,settings;
	boolean firstRun;

	public PanelMainMenu() {

		firstRun = true;
		this.setLayout(null);

		exit = new ButtonStandard();
		
		gameMenuSP = new ButtonStandard();
		settings = new ButtonStandard();
		
		
		exit.setIcon(new ImageIcon("res/icon/ButtonExit.png"));
		gameMenuSP.setIcon(new ImageIcon("res/icon/ButtonSingleplayer.png"));
		settings.setIcon(new ImageIcon("res/icon/ButtonSettings.png"));
		
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Menu.exit();
			}
		});
		
		gameMenuSP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIControll.showPanel("gameMenuSP");
			}
		});
		
		settings.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIControll.showPanel("settings");
			}
		});
		
		this.add(exit);
		this.add(gameMenuSP);
		this.add(settings);
	}

	@Override
	protected void paintComponent(Graphics g) {

		if (firstRun) {
			firstRun = false;

		}

		exit.setBounds(this.getWidth()- 350, this.getHeight() - 150, 300, 100);
		settings.setBounds(50, this.getHeight() -150, 300, 100);
		gameMenuSP.setBounds(this.getWidth() / 2 - 150, this.getHeight() / 4 * 2, 300, 100);
		

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(123, 200, 80));
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2d.setColor(new Color(123, 0, 80));
		g2d.setFont(new Font("Impact", Font.BOLD, this.getWidth() / 5));
		g2d.drawString("LandLord", this.getWidth() / 12, this.getHeight() / 3);
	}
}
