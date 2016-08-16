package com.beverage;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.beverage.dao.BeverageDAO;
import com.beverage.dto.ReviewDTO;

public class AdminJPanelReview extends JFrame {

	DefaultTableModel model;
	JTable table;

	ArrayList<ReviewDTO> reviewArr;

	int beverage_id;

	public AdminJPanelReview(int beverage_id) {
		this.beverage_id = beverage_id;

		Object[] obj = { "회원아이디", "한줄평", "점수" };
		model = new DefaultTableModel(obj, 0) {
			@Override
			public boolean isCellEditable(int row, int column) { // 테이블에 직접 값 입력
																	// X
				return false;
			}
		};
		table = new JTable(model);
		table.getColumn(obj[0]).setPreferredWidth(15);
		table.getColumn(obj[2]).setPreferredWidth(3);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(20);

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				BeverageDAO dao = BeverageDAO.getInstance();
				if (e.getClickCount() == 2) {
					int row = table.getSelectedRow();
					if (row < 0 || table.getValueAt(row, 0) == null)
						return;

					int msg = getConfirmMessage("삭제 하시겠습니까?");
					if (msg == 0) {
						dao.reviewDelete(beverage_id, reviewArr.get(row).getMember_id());
						showData();
					}

				}
			}
		});

		add(new JScrollPane(table));
		showData();

		// 화면 설정
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 200);
		setTitle("리뷰 관리");
		ImageIcon img = new ImageIcon("src/com/beverage/Coffee-toGo-icon.png");
		this.setIconImage(img.getImage());
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension di = tk.getScreenSize();
		Dimension di1 = this.getSize();
		setLocation((int) ((di.getWidth() - this.getWidth()) / 2 - (di1.getWidth() - this.getWidth()) / 2),
				(int) ((di.getHeight() - this.getHeight()) / 2 - (di1.getHeight() - this.getHeight()) / 2));
		setVisible(true);
	}

	public int getConfirmMessage(String msg) {
		JLabel label = new JLabel(msg);
		return JOptionPane.showConfirmDialog(this, label, "리뷰 삭제", JOptionPane.YES_NO_OPTION);
	}

	public void showData() {
		BeverageDAO dao = BeverageDAO.getInstance();
		reviewArr = dao.searchMethod(beverage_id);

		model.setRowCount(0);
		for (ReviewDTO reviewData : reviewArr) {
			Object[] review = { reviewData.getMember_id(), reviewData.getBeverage_review(),
					reviewData.getReview_level() };
			model.addRow(review);
		}
	}

}
