package com.beverage;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminJPanel extends JPanel {

	JButton registerBtn;
	JButton deleteBtn;
	JLabel cafeTitle;
	JTextField cafeName;
	JButton submitBtn;

	public AdminJPanel() {
		registerBtn = new JButton("등록");
		deleteBtn = new JButton("삭제");
		cafeTitle = new JLabel("카페등록");
		cafeName = new JTextField(10);
		submitBtn = new JButton("등록");
	}

	public JPanel adminMain() {
		setLayout(new FlowLayout());
		JPanel jp1 = new JPanel(new GridLayout(2, 1));
		jp1.add(registerBtn);
		jp1.add(deleteBtn);
		add(jp1);

		return this;
	}

	public JPanel init() {
		setLayout(new GridLayout(3, 1));
		add("North", cafeTitle);
		add("Center", cafeName);
		add("Center", submitBtn);

		return this;
	}

}
