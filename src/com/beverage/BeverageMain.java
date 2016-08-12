package com.beverage;

import javax.swing.JFrame;

public class BeverageMain extends JFrame {

	public BeverageMain() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		// new BeverageMain();
		new LoginFrame();
	}

}
