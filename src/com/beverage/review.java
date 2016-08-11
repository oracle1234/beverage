package com.beverage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.beverage.dao.BeverageDAO;
import com.beverage.dto.BeverageDTO;
import com.beverage.dto.ReviewDTO;

class review extends JFrame implements ActionListener, ItemListener {
	JMenuBar menu;
	JPanel jp1, jp2, jp3, sp1, sp2, p1, p2, p3;
	JTextArea ta;
	JButton cofBtn, register;
	JToolBar toolbar;
	ImageIcon coffee;
	JTextField tf;
	JLabel score, jl;
	DefaultTableModel model;
	JTable table;
	JRadioButton five, four, three, two, one;
	int jumsu;

	public review(BeverageDTO beverageDto) {
		this.setTitle(beverageDto.getBeverage_name());
		String path = "src/com/beverage/";
		coffee = new ImageIcon(path + "starbuks.JPG");
		Image img = coffee.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
		coffee = new ImageIcon(img);
		cofBtn = new JButton(coffee);

		sp1 = new JPanel();
		sp2 = new JPanel();
		score = new JLabel("평점   " + BeverageDAO.getInstance().levelMethod());
		sp1.add(cofBtn);
		sp2.add(score);

		jp1 = new JPanel();
		jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));
		jp1.add(sp1);
		jp1.add(sp2);

		jp2 = new JPanel();
		ta = new JTextArea(20, 45);
		ta.setText(beverageDto.getBeverage_text());
		jp2.add(ta);

		Object[] obj = { "회원아이디", "리뷰평", "점수" };
		model = new DefaultTableModel(obj, 0) {
			@Override
			public boolean isCellEditable(int row, int column) { // 테이블에 직접 값 입력
																	// 못하게 하는
																	// 메소드!
				return false;
			}
		};

		p1 = new JPanel();
		table = new JTable(model);
		table.getColumn(obj[0]).setPreferredWidth(15);
		table.getColumn(obj[2]).setPreferredWidth(3);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(20);

		p2 = new JPanel();
		tf = new JTextField(33);
		jl = new JLabel("한줄평");
		register = new JButton("등록");
		p2.add(jl);
		p2.add(tf);
		p2.add(register);

		five = new JRadioButton("5", true);
		four = new JRadioButton("4", true);
		three = new JRadioButton("3", true);
		two = new JRadioButton("2", true);
		one = new JRadioButton("1", true);

		ButtonGroup bg = new ButtonGroup();
		bg.add(five);
		bg.add(four);
		bg.add(three);
		bg.add(two);
		bg.add(one);

		p3 = new JPanel();
		p3.add(new JLabel("점수 "));
		p3.add(five);
		p3.add(four);
		p3.add(three);
		p3.add(two);
		p3.add(one);

		jp3 = new JPanel();
		jp3.setLayout(new BoxLayout(jp3, BoxLayout.Y_AXIS));
		jp3.add(p1.add(new JScrollPane(table)));
		jp3.add(p3);
		jp3.add(p2);

		setLayout(new GridLayout(3, 1));
		add(jp1);
		add(jp2);
		add(jp3);

		showData();

		register.addActionListener(this);
		five.addItemListener(this);
		four.addItemListener(this);
		three.addItemListener(this);
		two.addItemListener(this);
		one.addItemListener(this);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int msg = getConfirmMessage("창을 닫으시겠습니까?");
				if (msg == 0)
					dispose();
				else
					return;
			}
		});

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.setSize(520, 550);
		this.setVisible(true);

	}

	public int getConfirmMessage(String msg) {
		JLabel label = new JLabel(msg);
		label.setFont(new Font("sanSerif", 0, 12));
		label.setForeground(new Color(255, 0, 0)); // Color.red
		return JOptionPane.showConfirmDialog(this, label, "메세지", JOptionPane.YES_NO_OPTION);
	}// end getConfirmMessage()////////////////////////////////////////////////

	public void showData() {
		BeverageDAO dao = BeverageDAO.getInstance();

		ArrayList<ReviewDTO> dto = dao.searchMethod();

		for (ReviewDTO reviewData : dto) {
			Object[] review = { "ddd", reviewData.getBeverage_review(), reviewData.getReview_levle() };
			model.addRow(review);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BeverageDAO dao = BeverageDAO.getInstance();
		int a = dao.reviewInsert(13, tf.getText(), jumsu);

		if (a > 0) {
			ArrayList<ReviewDTO> dto = dao.searchMethod();

			for (ReviewDTO reviewData : dto) {
				Object[] review = { "ddd", reviewData.getBeverage_review(), reviewData.getReview_levle() };
				model.addRow(review);
			}
		}
		tf.setText("");
		tf.requestFocus();

	}// actionPerformed()

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();

		if (five.isSelected())
			jumsu = Integer.parseInt(five.getText());
		else if (four.isSelected())
			jumsu = Integer.parseInt(four.getText());
		else if (three.isSelected())
			jumsu = Integer.parseInt(three.getText());
		else if (two.isSelected())
			jumsu = Integer.parseInt(two.getText());
		else if (one.isSelected())
			jumsu = Integer.parseInt(one.getText());

	}// itemStateChanged

}