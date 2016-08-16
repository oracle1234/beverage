package com.beverage;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.beverage.dao.BeverageDAO;
import com.beverage.dto.BeverageDTO;
import com.beverage.dto.MemberDTO;

public class AdminJFrame extends JFrame implements ActionListener, MouseListener {
	AdminJPanel admin;
	BeverageDAO dao = BeverageDAO.getInstance();

	public AdminJFrame() {
		BeverageDAO dao = BeverageDAO.getInstance();
		admin = new AdminJPanel();

		admin.cafeInBtn.addActionListener(this);
		admin.cafeDelBtn.addActionListener(this);
		admin.b_Insert.addActionListener(this);
		admin.table.addMouseListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 770);
		setTitle("관리자 페이지");
		setContentPane(admin.adminJP());
		setVisible(true);

		// 화면 중간
		ImageIcon img = new ImageIcon("src/com/beverage/Coffee-toGo-icon.png");
		this.setIconImage(img.getImage());
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension di = tk.getScreenSize();
		Dimension di1 = this.getSize();
		this.setLocation((int) ((di.getWidth() - this.getWidth()) / 2 - (di1.getWidth() - this.getWidth()) / 2),
				(int) ((di.getHeight() - this.getHeight()) / 2 - (di1.getHeight() - this.getHeight()) / 2));

	}

	public void refresh() {
		getContentPane().removeAll();
		setContentPane(admin.adminJP());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == admin.cafeInBtn) {
			if (admin.cafeName.getText().length() > 0) {
				if (dao.cafeInsert(admin.cafeName.getText()) > 0) {
					showMessage("카페 등록 성공");
					admin.cafeName.setText("");
					refresh();
				}
			} else {
				showMessage("등록할 카페를 입력하세요.");
			}

		} else if (obj == admin.cafeDelBtn) {
			dao.cafeDelete((String) admin.cafeBox.getSelectedItem());
			showMessage("카페 삭제 성공");
			refresh();
		} else if (obj == admin.b_Insert) {

			if (admin.jfPrice.getText().length() > 0 && admin.jfName.getText().length() > 0
					&& admin.jfText.getText().length() > 0) {
				BeverageDTO dto = new BeverageDTO();

				dto.setCafe_id(
						MemberDTO.getInstance().getCafeList().get(admin.b_CafeBox.getSelectedIndex()).getCafe_id());
				dto.setBeverage_price(Integer.parseInt(admin.jfPrice.getText()));
				dto.setBeverage_type((String) admin.b_TypeBox.getSelectedItem());
				dto.setBeverage_name(admin.jfName.getText());
				dto.setBeverage_text(admin.jfText.getText());
				if (dao.cafeBeverageInsert(dto) > 0) {
					showMessage("음료 등록 성공");
					admin.jfPrice.setText("");
					admin.jfName.setText("");
					admin.jfText.setText("");
				}
				admin.getList();
				refresh();
			} else {
				showMessage("정보를 입력해주세요.");
			}

		}

	}

	public void showMessage(String str) {
		JOptionPane.showMessageDialog(this, str);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj == admin.table && e.getClickCount() == 2) {
			int row = admin.table.getSelectedRow();
			if (row < 0 || admin.table.getValueAt(row, 0) == null)
				return;

			Object[] options = { "리뷰 관리", "음료 삭제" };
			int n = JOptionPane.showOptionDialog(this, "리뷰관리와 음료 삭제중 선택", "음료", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			switch (n) {
			case 0:
				new AdminJPanelReview(admin.beverageList.get(row).getBeverage_id());
				break;
			case 1:
				dao.cafeBeverageDelete(admin.beverageList.get(row).getBeverage_id());
				admin.getList();
				refresh();
				break;
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
