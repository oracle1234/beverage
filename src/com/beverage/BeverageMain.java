package com.beverage;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import com.beverage.dao.BeverageDAO;

public class BeverageMain extends JFrame {
	AdminJPanel admin;
	

	public BeverageMain() {
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		BeverageDAO.getInstance().cafeSelect();
		
		admin = new AdminJPanel();
		setContentPane(admin);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BeverageMain();
	}

}
