package com.beverage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.beverage.dao.BeverageDAO;
import com.beverage.dto.BeverageDTO;
import com.beverage.dto.MemberDTO;

class Design extends JFrame implements ItemListener, ActionListener, MouseListener {

	JButton searchBtn, favorBtn;
	JTable table;
	JComboBox<String> locBox1, locBox2;
	DefaultTableModel model;
	private int crow = -1;

	ArrayList<BeverageDTO> beverageList;

	public Design() {

		favorBtn = new JButton("즐겨찾기");
		searchBtn = new JButton("검색");
		JPanel jp1 = new JPanel();
		jp1.add(new JLabel("???님 환영합니다.      "));
		jp1.add(favorBtn);

		JPanel jp2 = new JPanel();
		Object[] obj = { "카페이름", "음료명", "커피가격" };
		model = new DefaultTableModel(obj, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		/* table.getColumn(obj) */
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(20);

		DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<String>();
		model1.addElement("커피");
		model1.addElement("티");
		model1.addElement("주스");
		model1.addElement("기타");
		locBox1 = new JComboBox<String>(model1);

		DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<String>();
		model2.addElement("전체");
		model2.addElement("2000~3000");
		model2.addElement("3000~4000");
		model2.addElement("4000~5000");
		model2.addElement("5000~6000");
		model2.addElement("6000~7000");
		locBox2 = new JComboBox<String>(model2);

		jp2.add(new JLabel("음료명: "));
		jp2.add(locBox1);
		jp2.add(new JLabel("가격: "));
		jp2.add(locBox2);
		jp2.add(searchBtn);

		/*
		 * JPanel jp3 = new JPanel(); jp3.setLayout(new BoxLayout(jp3,
		 * BoxLayout.Y_AXIS)); jp3.add(jp1); jp3.add(BorderLayout.SOUTH, table);
		 */

		JPanel jp3 = new JPanel(new GridLayout(2, 1));
		jp3.add(jp1);
		jp3.add(jp2);

		setLayout(new GridLayout(2, 1));
		add(jp3);
		add(new JScrollPane(table));

		// add(BorderLayout.NORTH,jp1);
		// add(BorderLayout.NORTH, jp2);
		// add(BorderLayout.CENTER, new JScrollPane(table));

		searchBtn.addActionListener(this);
		// searchBtn.addMouseListener(this);

		// 즐겨찾기 버튼 연결 실행.
		favorBtn.addActionListener(this);
		table.addMouseListener(this);

		// favorBtn.addMouseListener(this);

		BeverageDAO.getInstance().cafeSelect();
	
		setSize(500, 400);
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj == table && e.getClickCount() == 2) {
			move();
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		// 검색을 누를때
		if (obj == searchBtn) {

			if (model.getRowCount() != 0) {
				model.setRowCount(0);
			}

			BeverageDAO dao = BeverageDAO.getInstance();

			String s1 = (String) locBox1.getSelectedItem();
			String s2 = (String) locBox2.getSelectedItem();

			beverageList = dao.beverageSearch(s1, s2);
			HashMap<Integer, String> map = MemberDTO.getInstance().getCafe_map();
			for (BeverageDTO dto : beverageList) {
				Object[] k = { map.get(dto.getCafe_id()), dto.getBeverage_name(), dto.getBeverage_price() };
				model.addRow(k);
			}
		}
	}// actionPerformed()

	public void move() {
		int row = table.getSelectedRow();
		if (row < 0 || table.getValueAt(row, 0) == null)
			return;
		setRow(row);
		review r = new review(beverageList.get(row));

	}

	public void setRow(int crow) {
		this.crow = crow;
	}// end setRow();

	public int getRow() {
		return crow;
	}

}// end class

public class beverage {

	public static void main(String[] args) {
	
		new Design();

	}

}
