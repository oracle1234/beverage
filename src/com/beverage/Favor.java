package com.beverage;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.beverage.dao.BeverageDAO;
import com.beverage.dto.BeverageDTO;
import com.beverage.dto.FavorDTO;
import com.beverage.dto.MemberDTO;

public class Favor extends JFrame implements MouseListener {
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

		favor.addMouseListener(this);

		JPanel jp2 = new JPanel();
		jp2.add(new JLabel(dto.getName() + "님의 즐겨찾기      "));

		add(BorderLayout.NORTH, jp2);
		add(BorderLayout.CENTER, new JScrollPane(favor));

		setSize(500, 350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	void getlist() {
		model.setRowCount(0);
		favorList = dao.favorSearch();
		for (FavorDTO dto : favorList) {
			Object[] k = { dto.getCafe_name(), dto.getBeverage_name(), dto.getBeverage_price() };
			model.addRow(k);
		}

	}

	public int getConfirmMessage(String msg) {
		JLabel label = new JLabel(msg);
		return JOptionPane.showConfirmDialog(this, label, "메세지", JOptionPane.YES_NO_OPTION);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj == favor && e.getClickCount() == 2) {
			int row = favor.getSelectedRow();
			if (row < 0 || favor.getValueAt(row, 0) == null)
				return;

			int msg = getConfirmMessage("삭제 하시겠습니까?");
			if (msg == 0) {
				dao.favorDel(favorList.get(row).getBeverage_id());
				getlist();
			} else {

			}

		}

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
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
