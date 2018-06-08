package at.fralex.landlord.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class ButtonStandard extends JButton {

	public ButtonStandard(String text) {
		
		this.setText(text);
		this.setFont(new Font("Arial", Font.PLAIN, 20));
		this.setBorder(null);
		this.setBackground(Color.WHITE);
	}
	
}
