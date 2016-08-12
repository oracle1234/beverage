package com.beverage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import com.beverage.dto.MemberDTO;
import com.beverage.dto.ReviewDTO;

class Review extends JFrame implements ActionListener {
	JMenuBar menu;
	JPanel jp1, jp2, jp3, sp1, sp2, p1, p2, p3;
	JTextArea ta;
	JButton cofBtn, register;
	JToolBar toolbar;
	ImageIcon coffee, detail2;
	JTextField tf;
	JLabel score, jl;
	DefaultTableModel model;
	JTable table;
	JRadioButton five, four, three, two, one;
	JOptionPane op;
	int jumsu;

	BeverageDTO dto;

	public Review(BeverageDTO beverageDto) {
		this.setTitle(beverageDto.getBeverage_name());
		ImageIcon icon = new ImageIcon("src/com/beverage/Coffee-toGo-icon.png");
		this.setIconImage(icon.getImage());
		dto = beverageDto;
		this.setTitle(dto.getBeverage_name());
		String path = "src/com/beverage/";
		coffee = new ImageIcon(path + "starbuks.JPG");
		Image img = coffee.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
		coffee = new ImageIcon(img);
		cofBtn = new JButton(coffee);

		cofBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BeverageDAO dao = BeverageDAO.getInstance();
				MemberDTO mem = MemberDTO.getInstance();
				dao.favorInsert(mem.getMember_num(), dto.getBeverage_id(), mem.getCafe_map().get(dto.getCafe_id()),
						dto.getBeverage_name());
				op.showMessageDialog(cofBtn, "즐겨찾기에 추가되었습니다.");

			}
		});

		sp1 = new JPanel();
		sp2 = new JPanel();
		score = new JLabel("평점  : " + BeverageDAO.getInstance().levelMethod(dto.getBeverage_id()));
		sp1.add(cofBtn);
		sp2.add(score);

		jp1 = new JPanel();
		jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));
		jp1.add(sp1);
		jp1.add(sp2);

		jp2 = new JPanel();
		ta = new JTextArea(20, 45);
		ta.setText(dto.getBeverage_text());
		jp2.add(ta);

		Object[] obj = { "회원아이디", "리뷰평", "점수" };
		model = new DefaultTableModel(obj, 0) {
			@Override
			public boolean isCellEditable(int row, int column) { // 테이블에 직접 값 입력
																	// X
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
		tf.addActionListener(this);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.setSize(520, 550);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension di = tk.getScreenSize();
		Dimension di1 = this.getSize();
		this.setLocation((int) ((di.getWidth() - this.getWidth()) / 2 - (di1.getWidth() - this.getWidth()) / 2),
				(int) ((di.getHeight() - this.getHeight()) / 2 - (di1.getHeight() - this.getHeight()) / 2));
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
		ArrayList<ReviewDTO> dto = dao.searchMethod(this.dto.getBeverage_id());

		for (ReviewDTO reviewData : dto) {
			Object[] review = { reviewData.getMember_id(), reviewData.getBeverage_review(),
					reviewData.getReview_level() };
			model.addRow(review);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		while (model.getRowCount() != 0)
			model.removeRow(0);
		BeverageDAO dao = BeverageDAO.getInstance();

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
		else {
			jumsu = 0;
		}

		int a = dao.reviewInsert(dto.getBeverage_id(), MemberDTO.getInstance().getMember_id(), tf.getText(), jumsu);

		if (a > 0) {
			ArrayList<ReviewDTO> dto = dao.searchMethod(this.dto.getBeverage_id());
			for (ReviewDTO reviewData : dto) {
				Object[] review = { reviewData.getMember_id(), reviewData.getBeverage_review(),
						reviewData.getReview_level() };
				model.addRow(review);
			}
		}

		tf.setText("");
		tf.requestFocus();

		score.setText("평점 : " + BeverageDAO.getInstance().levelMethod(dto.getBeverage_id()));

	}// actionPerformed()

}