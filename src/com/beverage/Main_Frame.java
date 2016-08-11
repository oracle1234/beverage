package com.beverage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.*;

import com.beverage.dao.BeverageDAO;

class Main_Frame extends JFrame implements ActionListener, KeyListener {
	MainPanel main;
	ImageIcon img;

	public Main_Frame() {
		// 타이틀바
		this.setTitle("Beverage Program");
		img = new ImageIcon("src/com/beverage/Coffee-toGo-icon.png");
		this.setIconImage(img.getImage());

		main = new MainPanel();
		add("Center", main);

		javax.swing.UIManager.put("Button.defaultButtonFollowsFocus", true);
		main.memberJoinB.addActionListener(this);
		main.loginB.addActionListener(this);
		main.idT.addKeyListener(this);
		main.passwordT.addKeyListener(this);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int message = getConfirmMessage("정말로 종료하겠습니까?");
				if (message == 0)
					System.exit(0);
				else
					return;
			}
		});

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(330, 510);
		this.setResizable(false);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension di = tk.getScreenSize();
		Dimension di1 = this.getSize();
		this.setLocation((int) ((di.getWidth() - this.getWidth()) / 2 - (di1.getWidth() - this.getWidth()) / 2),
				(int) ((di.getHeight() - this.getHeight()) / 2 - (di1.getHeight() - this.getHeight()) / 2));
		this.setVisible(true);
	}// end Main_Frame()

	public int getConfirmMessage(String message) {
		JLabel label = new JLabel(message);
		label.setFont(new Font("sanSerif", 0, 12));
		label.setForeground(new Color(255, 0, 0));
		return JOptionPane.showConfirmDialog(this, label, "메세지", JOptionPane.YES_NO_OPTION);
	}// end getConfirmMessage()

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == main.memberJoinB)
			memberJoin();
		else if (obj == main.loginB)
			login();
	}// end actionPerformed()

	public void memberJoin() {
	}// end memberJoin()

	public void login() {
		BeverageDAO dao = BeverageDAO.getInstance();
		boolean check = false;
		if (!main.idT.getText().equals("") && !main.passwordT.getText().equals("")) {
			check = dao.getMember(main.idT.getText(), main.passwordT.getText());
			if (check == true) {
				JOptionPane.showMessageDialog(this, "로그인 성공");
				// 로그인 후 화면전환 메소드

			} else {
				JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호를 다시 확인하세요.");
				main.idT.setText("");
				main.passwordT.setText("");
			}
		} else if (!main.idT.getText().equals("") && main.passwordT.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
			main.idT.setText("");
			main.passwordT.setText("");
		} else if (main.idT.getText().equals("") && !main.passwordT.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "아이디를 입력하세요");
			main.idT.setText("");
			main.passwordT.setText("");
		}

	}// end login()

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			login();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}// end Main_Frame