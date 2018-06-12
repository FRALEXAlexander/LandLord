package at.fralex.landlord.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import at.fralex.landlord.game.StartNewGame;
import at.fralex.landlord.main.GUIControll;
import at.fralex.landlord.main.Main;
import at.fralex.landlord.main.Menu;

public class PanelNewGame extends JPanel {

	private ButtonStandard back,startGame;
	
	private TextFieldStandard name;
	
	boolean firstRun;

	public PanelNewGame() {

		firstRun = true;
		this.setLayout(null);

		back = new ButtonStandard();
		startGame = new ButtonStandard();
		
		name = new TextFieldStandard(16);
		
		back.setIcon(new ImageIcon("res/icon/ButtonBack.png"));
		startGame.setIcon(new ImageIcon("res/icon/ButtonStart_Game.png"));
		
		
		name.setFont(new Font("Impact", Font.PLAIN, 75));
		name.setForeground(new Color(20, 40, 120));
		name.setBorder(null);
		name.setOpaque(false);
		
		
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				name.setText("");
				GUIControll.showPanel("gameMenuSP");
			}
		});
		
		startGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				StartNewGame.start(name.getText());
				
			}
		});
		
		
		
		
		this.add(back);
		this.add(startGame);
		this.add(name);
	}

	@Override
	protected void paintComponent(Graphics g) {

		if (firstRun) {
			firstRun = false;

		}

		back.setBounds(50, this.getHeight() -150, 300, 100);
		startGame.setBounds(this.getWidth() -350, this.getHeight() -150, 300, 100);

		name.setBounds(this.getWidth()/2-200, this.getHeight()/2, 600, 100);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(123, 200, 80));
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2d.setColor(new Color(123, 0, 80));
		g2d.setFont(new Font("Impact", Font.BOLD, this.getWidth() / 6));
		g2d.drawString("New Game", this.getWidth() / 12, this.getHeight() / 3);
		g2d.setColor(new Color(0, 0, 0));
		g2d.setFont(new Font("Impact", Font.PLAIN, 100));
		g2d.drawString("Name:", this.getWidth() / 12, this.getHeight() / 2 +75);
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("res/icon/TextfieldName.png"));
		} catch (IOException e) {
		}
		
		g2d.drawImage(img, this.getWidth()/2-200, this.getHeight()/2, this);
		
		//g2d.drawImage(new ImageIcon("res/icon/TextfieldName.png"),this.getWidth()/2-200,this.getHeight()/2 , this);
	}
}
