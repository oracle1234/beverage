package com.beverage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class BeverageMain extends JFrame {
	AdminJPanel admin;

	public BeverageMain() {
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		admin = new AdminJPanel();
		admin.adminMain();

		setContentPane(admin.adminMain());
		admin.registerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				setContentPane(admin.init());
			}
		});

		admin.submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				setContentPane(admin.adminMain());
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		// new BeverageMain();
		new Main_Frame();
	}

}
