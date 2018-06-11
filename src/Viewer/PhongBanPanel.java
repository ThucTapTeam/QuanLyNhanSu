package Viewer;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BUS.PhongBanBUS;
import Model.PhongBan;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class PhongBanPanel extends JPanel {
	private JPanel  contentPane;
	private TableModel tablemodel;
	private JTable table;
	private JTextField tfMaPB;
	private JTextField tfTenPB;
	private JTextField tfMaTP;
	private JTextField tfNgayNhanChuc;
	/**
	 * Create the panel.
	 */
	public void showtable()
	{
		List<String> columns = new ArrayList<String>();
		List<String[]> values = new ArrayList<String[]>();

		columns.add("Mã PB");
		columns.add("Tên PB ");
		columns.add("Mã TP");
		columns.add("Ngày Nhận Chức");
		PhongBanBUS phongbanbus = new PhongBanBUS();
		List<PhongBan> listPB = phongbanbus.getList("select * from PhongBan");
		for (PhongBan phongban : listPB) {
			values.add(new String[] {String.valueOf(phongban.getMaPB()),phongban.getTenPB(),String.valueOf(phongban.getMaTP()),String.valueOf(phongban.getNgayNhanChuc())});
		}
		tablemodel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
	}
	public PhongBanPanel() {
		setLayout(null);

		
		JLabel lbMaPB = new JLabel("MaPB");
		lbMaPB.setBounds(10, 242, 46, 14);
		add(lbMaPB);
		
		tfMaPB = new JTextField();
		tfMaPB.setBounds(67, 238, 129, 20);
		add(tfMaPB);
		tfMaPB.setColumns(10);
		
		JLabel lbTenPB = new JLabel("Ten PB");
		lbTenPB.setBounds(10, 280, 46, 14);
		add(lbTenPB);
		
		tfTenPB = new JTextField();
		tfTenPB.setBounds(67, 277, 129, 20);
		add(tfTenPB);
		tfTenPB.setColumns(10);
		
		JLabel lbMaTP = new JLabel("Ma TP");
		lbMaTP.setBounds(234, 280, 46, 14);
		add(lbMaTP);
		
		tfMaTP = new JTextField();
		tfMaTP.setBounds(333, 277, 129, 20);
		add(tfMaTP);
		tfMaTP.setColumns(10);
		
		JLabel lbNgayNhanChuc = new JLabel("Ngay Nhan Chuc");
		lbNgayNhanChuc.setBounds(234, 244, 89, 14);
		add(lbNgayNhanChuc);
		
		tfNgayNhanChuc = new JTextField();
		tfNgayNhanChuc.setBounds(333, 244, 129, 20);
		add(tfNgayNhanChuc);
		tfNgayNhanChuc.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 724, 220);
		add(panel);
		
		showtable();
		panel.setLayout(null);
		table = new JTable(tablemodel);
		table.setFillsViewportHeight(true);
		table.setBounds(10, 5, 704, 204);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 724, 220);
		panel.add(scrollPane);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PhongBan obj = new PhongBan();
					PhongBanBUS phongbanbus = new PhongBanBUS();
					obj.setMaPB(Integer.parseInt(tfMaPB.getText()));
					obj.setMaTP(Integer.parseInt(tfMaTP.getText()));
					obj.setNgayNhanChuc(Date.valueOf(tfNgayNhanChuc.getText()));
					obj.setTenPB(tfTenPB.getText());
					boolean check = phongbanbus.insert(obj);
					if(check)
						JOptionPane.showInputDialog(null, "Insert Success");
				} catch (Exception e2) {
					JOptionPane.showInputDialog(null, "Insert failed");
				}
				
				
			}
		});
		btnInsert.setBounds(142, 338, 89, 23);
		add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PhongBan obj = new PhongBan();
					PhongBanBUS phongbanbus = new PhongBanBUS();
					obj.setMaPB(Integer.parseInt(tfMaPB.getText()));
					obj.setMaTP(Integer.parseInt(tfMaTP.getText()));
					obj.setNgayNhanChuc(Date.valueOf(tfNgayNhanChuc.getText()));
					obj.setTenPB(tfTenPB.getText());
					boolean check = phongbanbus.update(obj);
					if(check)
						JOptionPane.showInputDialog(null, "Update Success");
				} catch (Exception e2) {
					JOptionPane.showInputDialog(null, "Update failed");
				}
			}
		});
		btnUpdate.setBounds(263, 338, 89, 23);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PhongBan obj = new PhongBan();
					PhongBanBUS phongbanbus = new PhongBanBUS();
					obj.setMaPB(Integer.parseInt(tfMaPB.getText()));
					obj.setMaTP(Integer.parseInt(tfMaTP.getText()));
					obj.setNgayNhanChuc(Date.valueOf(tfNgayNhanChuc.getText()));
					obj.setTenPB(tfTenPB.getText());
					boolean check = phongbanbus.delete(obj);
					if(check)
						JOptionPane.showInputDialog(null, "Delete Success");
				} catch (Exception e2) {
					JOptionPane.showInputDialog(null, "Delete failed");
				}
			}
		});
		btnDelete.setBounds(380, 338, 89, 23);
		add(btnDelete);
	}

}
