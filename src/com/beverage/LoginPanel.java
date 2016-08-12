package com.beverage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.*;

public class LoginPanel extends JPanel {
	JLabel id, password, imgl;
	JTextField idT;
	JPasswordField passwordT;
	JButton memberJoinB, loginB;
	JPanel labelP, idText, passwordText, top, north, buttonP, up, center, imgP;
	EtchedBorder etch;

	public LoginPanel() {
		id = new JLabel("  아이디      : ");
		password = new JLabel("  비밀번호   : ");

		Font font = new Font("sanSerif", 0, 14);

		id.setFont(font);
		password.setFont(font);

		idT = new JTextField(17);
		passwordT = new JPasswordField(17);

		memberJoinB = new JButton("회원가입");
		memberJoinB.setFont(font);

		loginB = new JButton("로그인");
		loginB.setFont(font);

		imgl = new JLabel();
		imgl.setIcon(new ImageIcon("src/com/beverage/Coffee-toGo-icon.png"));
		etch = new EtchedBorder(EtchedBorder.RAISED);
		imgl.setBorder(etch);

		imgP = new JPanel();
		imgP.add(imgl);

		labelP = new JPanel(new GridLayout(2, 1));
		labelP.add(id);
		labelP.add(password);

		idText = new JPanel(new FlowLayout(FlowLayout.CENTER));
		idText.add(idT);
		passwordText = new JPanel(new FlowLayout(FlowLayout.CENTER));
		passwordText.add(passwordT);

		top = new JPanel(new GridLayout(2, 1));
		top.add(idText);
		top.add(passwordText);

		north = new JPanel(new BorderLayout());
		north.setBorder(new TitledBorder("로그인"));
		north.add("West", labelP);
		north.add("Center", top);

		buttonP = new JPanel();
		buttonP.add(memberJoinB);
		buttonP.add(loginB);

		up = new JPanel(new BorderLayout(0, 5));
		up.add("North", north);
		up.add("South", buttonP);

		center = new JPanel(new BorderLayout(0, 5));
		center.add("North", up);

		setLayout(new BorderLayout(5, 5));
		add("Center", center);
		add("East", new JLabel("  "));
		add("West", new JLabel("  "));
		add("South", imgP);
		add("North", new JLabel("  "));

	}// end MainPanel()
}// end class
