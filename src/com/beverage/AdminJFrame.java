package com.beverage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.beverage.dao.BeverageDAO;
import com.beverage.dto.BeverageDTO;

public class AdminJFrame extends JFrame implements ActionListener, MouseListener {
	AdminJPanel admin;
	BeverageDAO dao = BeverageDAO.getInstance();

	public static void main(String[] args) {
		new AdminJFrame();
	}

	public AdminJFrame() {
		BeverageDAO dao = BeverageDAO.getInstance();
		admin = new AdminJPanel();

		admin.cafeInBtn.addActionListener(this);
		admin.cafeDelBtn.addActionListener(this);
		admin.b_Insert.addActionListener(this);
		admin.table.addMouseListener(this);

		setTitle("관리자 페이지");
		setContentPane(admin.adminJP());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 770);
		setVisible(true);

	}

	public void refresh() {
		getContentPane().removeAll();
		setContentPane(admin.adminJP());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == admin.cafeInBtn) {
			if (dao.cafeInsert(admin.cafeName.getText()) > 0) {
				JOptionPane.showMessageDialog(admin, "성공");
				admin.cafeName.setText("");
				refresh();
			} else {

			}
		} else if (obj == admin.cafeDelBtn) {
			dao.cafeDelete((String) admin.cafeBox.getSelectedItem());
			JOptionPane.showMessageDialog(admin, "삭제 성공");
			refresh();
		} else if (obj == admin.b_Insert) {
			BeverageDTO dto = new BeverageDTO();
			dto.setCafe_id(admin.b_CafeBox.getSelectedIndex() + 1);
			dto.setBeverage_price(Integer.parseInt(admin.jfPrice.getText()));
			dto.setBeverage_type((String) admin.b_TypeBox.getSelectedItem());
			dto.setBeverage_name(admin.jfName.getText());
			dto.setBeverage_text(admin.jfText.getText());
			dao.cafeBeverageInsert(dto);

			JOptionPane.showMessageDialog(admin, "등록 성공");
			admin.getList();
			refresh();
		}

	}

	public int getConfirmMessage(String msg) {
		JLabel label = new JLabel(msg);
		return JOptionPane.showConfirmDialog(this, label, "메세지", JOptionPane.YES_NO_OPTION);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj == admin.table && e.getClickCount() == 2) {
			int row = admin.table.getSelectedRow();
			if (row < 0 || admin.table.getValueAt(row, 0) == null)
				return;

			int msg = getConfirmMessage("삭제 하시겠습니까?");
			if (msg == 0) {
				dao.cafeBeverageDelete(admin.beverageList.get(row).getBeverage_id());
				admin.getList();
				refresh();
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
