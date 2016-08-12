package com.beverage;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Background extends JFrame{

	ImageIcon back;
	
	public Background() {
		back= new ImageIcon("src/com/beverage/background.jpg");
		
		JPanel jp=new JPanel(){
			public void paintComponent(Graphics g){
				g.drawImage(back.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
				
			}
		};
		
	
				
	}
	
}
