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
import javax.swing.JTextField;

import at.fralex.landlord.main.GUIControll;
import at.fralex.landlord.main.Main;
import at.fralex.landlord.main.Menu;

public class PanelGameMenuSP extends JPanel {

	private ButtonStandard back, newGame, loadGame;
	
	
	
	boolean firstRun;

	public PanelGameMenuSP() {

		firstRun = true;
		this.setLayout(null);
		
		back = new ButtonStandard();
		newGame = new ButtonStandard();
		loadGame = new ButtonStandard();

		
		
		
		back.setIcon(new ImageIcon("res/icon/ButtonBack.png"));
		newGame.setIcon(new ImageIcon("res/icon/ButtonNew_Game.png"));
		loadGame.setIcon(new ImageIcon("res/icon/ButtonLoad_Game.png"));
		
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIControll.showPanel("mainMenu");
			}
		});

		newGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIControll.showPanel("newGame");
			}
		});
		loadGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//GUIControll.showPanel("loadGame");
			}
		});

		this.add(back);
		this.add(newGame);
		this.add(loadGame);
	}

	@Override
	protected void paintComponent(Graphics g) {

		if (firstRun) {
			firstRun = false;

		}

		back.setBounds(this.getWidth() / 2 - 150, this.getHeight() / 4 * 3, 300, 100);
		newGame.setBounds(this.getWidth() / 4 - 100, this.getHeight() / 4 * 2, 300, 100);
		loadGame.setBounds(this.getWidth() / 4 * 3 - 200, this.getHeight() / 4 * 2, 300, 100);
		
		
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(123, 200, 80));
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2d.setColor(new Color(123, 0, 80));
		g2d.setFont(new Font("Impact", Font.BOLD, this.getWidth() / 5));
		g2d.drawString("LandLord", this.getWidth() / 12, this.getHeight() / 3);
	}
}
