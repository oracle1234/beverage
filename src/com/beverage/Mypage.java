package com.beverage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.beverage.dao.BeverageDAO;
import com.beverage.dto.MemberDTO;

public class Mypage extends JFrame implements ActionListener {
	MemberDTO dao = MemberDTO.getInstance();
	BeverageDAO dto = BeverageDAO.getInstance();
	JLabel idL, passwdL, nameL, genderL, emailL, birthL, idF, nameF, birthF;
	JTextField emailF;
	JPasswordField passwdF;
	JRadioButton manR, womanR;
	JButton change;
	JPanel p;

	public Mypage() {

		///////////////// 개인정보 수정/////////////////
		idL = new JLabel("아이디");
		nameL = new JLabel("성명");
		genderL = new JLabel("성별");
		emailL = new JLabel("이메일");
		birthL = new JLabel("생년월일 ex) 19990101");
		passwdL = new JLabel("비밀번호");
		manR = new JRadioButton("남", true);
		womanR = new JRadioButton("여", false);
		ButtonGroup group = new ButtonGroup();
		group.add(manR);
		group.add(womanR);

		idF = new JLabel(dao.getMember_id());
		nameF = new JLabel(dao.getName());
		emailF = new JTextField(20);

		DateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
		String birth = sdFormat.format(dao.getBirth_date());
		birthF = new JLabel(birth);

		passwdF = new JPasswordField(15);

		change = new JButton("수정");
		JPanel buttonC = new JPanel();
		buttonC.add(change);

		JPanel labelP = new JPanel(new GridLayout(6, 1));
		labelP.add(idL);
		labelP.add(passwdL);
		labelP.add(nameL);
		labelP.add(birthL);
		labelP.add(genderL);
		labelP.add(emailL);

		JPanel idP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		idP.add(idF);

		JPanel nameP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameP.add(nameF);

		JPanel genderP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		genderP.add(manR);
		genderP.add(womanR);

		JPanel passwdP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		passwdP.add(passwdF);

		JPanel emailP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		emailP.add(emailF);

		JPanel birthP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		birthP.add(birthF);

		JPanel panel1 = new JPanel(new GridLayout(6, 1));
		panel1.add(idP);
		panel1.add(passwdP);
		panel1.add(nameP);
		panel1.add(birthP);
		panel1.add(genderP);
		panel1.add(emailP);

		JPanel top = new JPanel(new BorderLayout());
		top.setBorder(new TitledBorder("개인정보 수정"));
		top.add("Center", panel1);
		top.add("West", labelP);
		top.add("South", buttonC);

		setLayout(new FlowLayout());

		add("Center", top);

		change.addActionListener(this);

		setSize(500, 350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// 화면 중앙에 창뜨기
		ImageIcon img = new ImageIcon("src/com/beverage/Coffee-toGo-icon.png");
		this.setIconImage(img.getImage());
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension di = tk.getScreenSize();
		Dimension di1 = this.getSize();
		this.setLocation((int) ((di.getWidth() - this.getWidth()) / 2 - (di1.getWidth() - this.getWidth()) / 2),
				(int) ((di.getHeight() - this.getHeight()) / 2 - (di1.getHeight() - this.getHeight()) / 2));
		//

	}

	public static void main(String[] args) {
		new Mypage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == change) {
			this.changeMethod();
		}
	}

	public void changeMethod() {
		String passwd = passwdF.getText();
		String email = emailL.getText();
		dao.setPassword(passwd);
		dao.setEmail(email);

		dto.updateMember(dao);
		if (!dao.getPassword().equals(passwdF) == true && !dao.getEmail().equals(emailL) == true)
			JOptionPane.showMessageDialog(this, "수정이 완료되었습니다.");
		dispose();

	}

}
