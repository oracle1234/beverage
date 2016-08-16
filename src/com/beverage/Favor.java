package com.beverage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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

public class Favor extends JFrame implements ActionListener {
	MemberDTO dto = MemberDTO.getInstance();
	ArrayList<FavorDTO> favorList;
	BeverageDAO dao = BeverageDAO.getInstance();

	JTable favor;
	DefaultTableModel model;
	JPanel board;
	JButton deleteBtn, reviewBtn;

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

		// favor.addMouseListener(this);

		JPanel jp2 = new JPanel();
		jp2.add(new JLabel(dto.getName() + "님의 즐겨찾기      "));

		reviewBtn = new JButton("보기");
		deleteBtn = new JButton("삭제");
		JPanel jp3 = new JPanel();
		jp3.add(reviewBtn);
		jp3.add(deleteBtn);

		reviewBtn.addActionListener(this);
		deleteBtn.addActionListener(this);

		add(BorderLayout.NORTH, jp2);
		add(BorderLayout.CENTER, new JScrollPane(favor));
		add(BorderLayout.SOUTH, jp3);

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
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		int row = favor.getSelectedRow();
		if (row < 0 || favor.getValueAt(row, 0) == null) {
			JOptionPane.showMessageDialog(this, "선택해주세요");
			return;
		}

		if (obj == reviewBtn) {
			BeverageDTO dto = dao.favoerToReview(favorList.get(favor.getSelectedRow()).getBeverage_id());

			if (dto.getBeverage_id() > 0) {
				new Review(dto);
				dispose();
			} else {
				JOptionPane.showMessageDialog(this, "판매 종료된 상품입니다.");
			}
		} else if (obj == deleteBtn) {
			int msg = getConfirmMessage("삭제 하시겠습니까?");
			if (msg == 0) {
				dao.favorDel(favorList.get(row).getBeverage_id());
				getlist();
			}
		}

	}

}
