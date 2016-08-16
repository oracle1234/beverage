package com.beverage;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.beverage.dao.BeverageDAO;
import com.beverage.dto.BeverageDTO;
import com.beverage.dto.MemberDTO;

public class AdminJPanel extends JPanel {

	// 카페등록
	JTextField cafeName;
	JButton cafeInBtn;
	// 카페삭제
	DefaultComboBoxModel<String> delComboBox;
	JComboBox<String> cafeBox;
	JButton cafeDelBtn;
	// 음료등록
	DefaultComboBoxModel<String> insertComboBox1;
	DefaultComboBoxModel<String> insertComboBox2;
	JComboBox<String> b_CafeBox, b_TypeBox;
	JTextField jfPrice, jfName, jfText;
	JButton b_Insert;
	// 음료삭제
	DefaultTableModel tableModel;
	JTable table;
	ArrayList<BeverageDTO> beverageList;

	public AdminJPanel() {

		// 카페 등록
		cafeName = new JTextField(10);
		cafeInBtn = new JButton("등록");
		// 카페 삭제
		delComboBox = new DefaultComboBoxModel<String>();
		cafeDelBtn = new JButton("삭제");
		// 음료 등록
		insertComboBox1 = new DefaultComboBoxModel<String>();
		// 카페 정보
		jfPrice = new JTextField(10);
		// 음료 구분
		insertComboBox2 = new DefaultComboBoxModel<String>();
		String[] b_type = { "커피", "티", "주스", "기타" };
		for (int i = 0; i < b_type.length; i++) {
			insertComboBox2.addElement(b_type[i]);
		}
		b_TypeBox = new JComboBox<String>(insertComboBox2);
		jfName = new JTextField(10);
		jfText = new JTextField(10);
		b_Insert = new JButton("음료 등록");

		// 음료 삭제
		Object[] obj = { "카페", "음료", "가격" };
		tableModel = new DefaultTableModel(obj, 0) {
			@Override
			// 테이블에 직접 값 입력 못하게 하는 메소드!
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(tableModel);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(20);
	}

	public JPanel adminJP() {
		BeverageDAO.getInstance().cafeSelect();
		// 카페 등록
		// 카페 삭제
		delComboBox.removeAllElements();
		for (int i = 0; i < MemberDTO.getInstance().getCafeList().size(); i++) {
			delComboBox.addElement(MemberDTO.getInstance().getCafeList().get(i).getCafe_name());
		}
		cafeBox = new JComboBox<String>(delComboBox);
		// 음료 등록
		insertComboBox1.removeAllElements();
		for (int i = 0; i < MemberDTO.getInstance().getCafeList().size(); i++) {
			insertComboBox1.addElement(MemberDTO.getInstance().getCafeList().get(i).getCafe_name());
		}
		b_CafeBox = new JComboBox<String>(insertComboBox1);

		// 카페 등록
		JPanel in1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		in1.add(new JLabel("카페 등록"));

		JPanel in2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		in2.add(cafeName);
		in2.add(cafeInBtn);

		JPanel in3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		in3.add(in1);
		in3.add(in2);

		JPanel in4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		in4.add(in3);

		// 카페 삭제
		JPanel del1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		del1.add(new JLabel("카페 삭제"));

		JPanel del2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		del2.add(cafeBox);
		del2.add(cafeDelBtn);

		JPanel del3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		del3.add(del1);
		del3.add(del2);

		JPanel del4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		del4.add(del3);

		// 음료등록
		JPanel bein2 = new JPanel(new GridLayout(5, 2));
		bein2.add(new JLabel("카페"));
		bein2.add(b_CafeBox);
		bein2.add(new JLabel("가격"));
		bein2.add(jfPrice);
		bein2.add(new JLabel("구분"));
		bein2.add(b_TypeBox);
		bein2.add(new JLabel("이름"));
		bein2.add(jfName);
		bein2.add(new JLabel("설명"));
		bein2.add(jfText);
		JPanel bein3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		// bein3.add(bein1);
		bein3.add(bein2);
		bein3.add(b_Insert);
		JPanel bein4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		bein4.add(bein3);

		// 음료 삭제
		JPanel bedel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		bedel1.add(new JLabel("음료 삭제"));
		JPanel bedel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		bedel2.add(new JScrollPane(table));
		JPanel bedel3 = new JPanel();
		bedel3.setLayout(new BoxLayout(bedel3, BoxLayout.Y_AXIS));
		bedel3.add(bedel1);
		bedel3.add(bedel2);

		// main
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.add(in4);
		main.add(del4);
		main.add(bein4);
		main.add(bedel3);
		add(main);

		getList();

		return this;
	}

	public void getList() {
		beverageList = null;
		tableModel.setRowCount(0);
		beverageList = BeverageDAO.getInstance().allBeverageSearch();
		for (BeverageDTO dto : beverageList) {
			Object[] k = { MemberDTO.getInstance().getCafe_map().get(dto.getCafe_id()), dto.getBeverage_name(),
					dto.getBeverage_price() };
			tableModel.addRow(k);
		}
	}

}
