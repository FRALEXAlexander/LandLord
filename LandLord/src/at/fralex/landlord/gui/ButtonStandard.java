package at.fralex.landlord.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonStandard extends JButton {

	public ButtonStandard() {
		
	
		this.setFont(new Font("Arial", Font.PLAIN, 20));
		this.setBorder(null);
		this.setBackground(Color.WHITE);
		
		this.setBorderPainted(false);
		this.setIcon(new ImageIcon("res/test.jpg"));
		
	}
	
	
}
