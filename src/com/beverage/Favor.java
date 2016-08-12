package com.beverage;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.beverage.dao.BeverageDAO;
import com.beverage.dto.BeverageDTO;
import com.beverage.dto.FavorDTO;
import com.beverage.dto.MemberDTO;

public class Favor extends JFrame {
	MemberDTO dto = MemberDTO.getInstance();
	ArrayList<FavorDTO> favorList;
	BeverageDAO dao = BeverageDAO.getInstance();

	JTable favor;
	DefaultTableModel model;
	JPanel board;
	JButton delete;

	public Favor() {
		JPanel jp1 = new JPanel();
		Object[] obj = { "카페이름", "음료명", "커피가격" };
		model = new DefaultTableModel(obj, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		favor = new JTable(model);
		getlist();

		favor.getTableHeader().setReorderingAllowed(false);
		favor.setRowHeight(20);

		JPanel jp2 = new JPanel();
		jp2.add(new JLabel(dto.getName() + "님의 즐겨찾기      "));

		add(BorderLayout.NORTH, jp2);
		add(BorderLayout.CENTER, new JScrollPane(favor));

		setSize(500, 350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	void getlist() {

		favorList = dao.favorSearch();
		for (FavorDTO dto : favorList) {
			Object[] k = { dto.getCafe_name(), dto.getBeverage_name(), dto.getBeverage_price() };
			model.addRow(k);
		}

	}

}
