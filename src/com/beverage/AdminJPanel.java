package com.beverage;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.beverage.dto.MemberDTO;

public class AdminJPanel extends JPanel {

	JTextField cafeName;
	JButton cafeInBtn;

	JComboBox<String> cafeBox;
	JButton cafeDelBtn;

	JButton registerBtn;
	JLabel cafeTitle;

	JComboBox<String> b_CafeBox, b_TypeBox;
	JTextField jfPrice, jfName, jfText;

	public AdminJPanel() {
		// 카페 등록
		cafeName = new JTextField(10);
		cafeInBtn = new JButton("등록");

		// 카페 삭제
		DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<String>();
		for (int i = 1; i <= MemberDTO.getInstance().getCafe_map().size(); i++) {
			model1.addElement(MemberDTO.getInstance().getCafe_map().get(i));
		}
		cafeBox = new JComboBox<String>(model1);
		cafeDelBtn = new JButton("삭제");

		// 음료 등록
		b_CafeBox = new JComboBox<String>(model1);
		jfPrice = new JTextField(10);

		DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<String>();
		model2.addElement("커피");
		model2.addElement("티");
		model2.addElement("주스");
		model2.addElement("기타");
		b_TypeBox = new JComboBox<String>(model2);
		jfName = new JTextField(10);
		jfText = new JTextField(10);

		setLayout(new FlowLayout(FlowLayout.CENTER));

		// 카페 등록
		JPanel in1 = new JPanel();
		in1.add(cafeName);
		in1.add(cafeInBtn);
		JPanel in2 = new JPanel();
		in2.setLayout(new BoxLayout(in2, BoxLayout.Y_AXIS));
		in2.add(new JLabel("카페 등록"));
		in2.add(in1);

		// 카페 삭제
		JPanel del1 = new JPanel(new FlowLayout());
		del1.add(cafeBox);
		del1.add(cafeDelBtn);
		JPanel del2 = new JPanel();
		del2.setLayout(new BoxLayout(del2, BoxLayout.Y_AXIS));
		del2.add(new JLabel("카페 삭제"));
		del2.add(del1);

		// 음료등록
		JPanel bein = new JPanel();
		bein.add(b_CafeBox);
		bein.add(jfPrice);
		bein.add(b_TypeBox);
		bein.add(jfName);
		bein.add(jfText);
		JPanel bein2 = new JPanel();
		bein2.setLayout(new BoxLayout(bein2, BoxLayout.Y_AXIS));
		bein2.add(new JLabel("음료 등록"));
		bein2.add(bein);

		// main
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.add(new JLabel("관리자페이지"));
		main.add(in2);
		main.add(del2);
		main.add(bein);

		add(main);

	}

}
