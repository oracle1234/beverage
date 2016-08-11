package com.beverage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.Date;
import java.text.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.beverage.dao.BeverageDAO;
import com.beverage.dto.MemberDTO;

class JoinMain extends JFrame implements ActionListener {
	BeverageDAO dao = BeverageDAO.getInstance();
	JPanel p;
	JLabel idL, passwdL, nameL, genderL, emailL, birthL;
	JTextField idF, nameF, emailF, birthF; // 아이디, 이름, 이메일, 생년월일
	JPasswordField passwdF; // 비밀번호
	JRadioButton manR, womanR; // 성별
	JButton btnRegister, btnCancel, btnCheck; // 가입, 취소

	public JoinMain() { // 가입용 생성자

		this.setTitle("회원가입");

		idL = new JLabel("아이디");
		nameL = new JLabel("성명");
		genderL = new JLabel("성별");
		emailL = new JLabel("이메일");
		birthL = new JLabel("생년월일 ex) 19990101");
		passwdL = new JLabel("비밀번호");

		Font font = new Font("sansSerif", 0, 12);

		nameL.setFont(font);
		genderL.setFont(font);
		emailL.setFont(font);
		birthL.setFont(font);

		idF = new JTextField(15);
		nameF = new JTextField(15);
		emailF = new JTextField(20);
		birthF = new JTextField(15);
		passwdF = new JPasswordField(15);

		btnRegister = new JButton("가입");
		btnCancel = new JButton("취소");
		btnCheck = new JButton("ID중복체크");

		manR = new JRadioButton("남", true);
		womanR = new JRadioButton("여", false);
		ButtonGroup group = new ButtonGroup();
		group.add(manR);
		group.add(womanR);

		JPanel buttonP = new JPanel();
		buttonP.add(btnRegister);
		buttonP.add(btnCancel);

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

		JPanel panel2 = new JPanel();
		panel2.add(btnCheck);

		JPanel panel1 = new JPanel(new GridLayout(6, 1));
		panel1.add(idP);
		panel1.add(passwdP);
		panel1.add(nameP);
		panel1.add(birthP);
		panel1.add(genderP);
		panel1.add(emailP);

		JPanel top = new JPanel(new BorderLayout());
		top.setBorder(new TitledBorder("개인정보 입력"));
		top.add("Center", panel1);
		top.add("East", panel2);
		top.add("West", labelP);
		top.add("South", buttonP);

		setLayout(new FlowLayout());

		add("Center", top);

		btnRegister.addActionListener(this);
		btnCancel.addActionListener(this);
		btnCheck.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// int msg = getConfirmMessage("회원가입을 종료하겠습니까?");
				// if (msg == 0)
				dispose();
				// else
				// return;
			}
		});

		setSize(500, 350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	public int getConfirmMessage(String msg) {
		JLabel label = new JLabel(msg);
		label.setFont(new Font("sanSerif", 0, 12));
		label.setForeground(new Color(255, 0, 0)); // Color.red
		return JOptionPane.showConfirmDialog(this, label, "메세지", JOptionPane.YES_NO_OPTION);
	}// end getConfirmMessage()////////////////////////////////////////////////

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == btnRegister) {
			joinMethod();
		} else if (obj == btnCancel) {
//			int msg = getConfirmMessage("회원가입을 종료하겠습니까?");
//			if (msg == 0)
				dispose();
//			else
//				return;
		} else if (obj == btnCheck) {
			idCheckMethod(idF.getText());
		}

	}// end actionPerformed()

	public void joinMethod() {

		String id = "";
		String passwd = "";
		String name = "";
		String birth = "";
		String email = "";
		String gender = "";

		MemberDTO dto = MemberDTO.getInstance();

		// 텍스트필드 빈칸일시 메세지 출력
		if (idF.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
		} else if (passwdF.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요.");
		} else if (nameF.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 입력하세요.");
		} else if (birthF.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "생년월일을 입력하세요.");
		} else if (emailF.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "이메일을 입력하세요.");
		}

		// 글자수 제한
		if (idF.getText().length() >= 12) {
			JOptionPane.showMessageDialog(this, "아이디는 영문, 숫자혼합 12자리까지 허용합니다");
			return;
		}
		if (passwdF.getText().length() >= 12) {
			JOptionPane.showMessageDialog(this, "영문, 숫자혼합 12자리까지 허용합니다");
		}
		if (nameF.getText().length() >= 10) {
			JOptionPane.showMessageDialog(this, "이름이 너무 깁니다");
		}

		if (emailF.getText().matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
			JOptionPane.showMessageDialog(this, "한글은 입력할 수 없습니다.");
		}

		// id = idF.getText();
		passwd = passwdF.getText();
		birth = birthF.getText();
		email = emailF.getText();
		name = nameF.getText();
		gender = manR.isSelected() ? "남" : "여";

		if (idF.getText().length() <= 12 && !idF.getText().equals("")) {
			id = idF.getText();
		}
		/*
		 * else if (passwdF.getText().length() <= 12 &&
		 * !passwdF.getText().equals("")) { passwd = passwdF.getText(); }
		 * 
		 * else if (nameF.getText().length() <= 10 &&
		 * !nameF.getText().equals("")) { name = nameF.getText(); } else if
		 * (birthF.getText().length() == 8 && !nameF.getText().equals("") &&
		 * !birthF.getText().matches(".*[a-Z].*")){ birth = birthF.getText(); }
		 * else if (!emailF.getText().matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*") &&
		 * !emailF.getText().equals("")){ email = emailF.getText(); } name =
		 * nameF.getText(); gender = manR.isSelected() ? "남" : "여";
		 */

		if (birthF.getText().length() != 8 && birthF.getText().matches(".*[a-zA-Z].*")
				&& birthF.getText().matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
			JOptionPane.showMessageDialog(this, "숫자 8자리 형식에 맞게 입력하세요");
		} else {
			DateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
			java.util.Date tempDate = null;

			try {
				tempDate = sdFormat.parse(birthF.getText());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			java.sql.Date date = new Date(tempDate.getTime());

			dto.setName(name);
			dto.setPassword(passwd);
			dto.setBirth_date(date);
			dto.setEmail(email);
			dto.setMember_id(id);
			dto.setGender(gender);
		}

		dao.insertMember(dto);

		// 가입완료 메세지 출력
		if (!dto.getName().equals("") == true && !dto.getMember_id().equals("") == true
				&& !dto.getPassword().equals("") == true && !dto.getBirth_date().equals("") == true
				&& !dto.getEmail().equals("") == true && !dto.getGender().equals("") == true)
			JOptionPane.showMessageDialog(this, "가입이 완료되었습니다.");

	}// end joinMethod()

	private void idCheckMethod(String id) {
		boolean check = false;
		check = dao.idCheck(id);

		if (check == true) {
			JOptionPane.showMessageDialog(this, "중복된 아이디입니다.");
		} else if (!idF.getText().equals("") && check == false && idF.getText().length() <= 12) {
			JOptionPane.showMessageDialog(this, "사용할 수 있는 아이디입니다.");
		} else if (idF.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "중복 체크할 아이디를 입력하세요.");
		} else if (idF.getText().length() > 12) {
			JOptionPane.showMessageDialog(this, "아이디는 영문, 숫자혼합 12자리까지 허용합니다");
		}

	}// end idCheckMethod()

}// end MemberInsert
