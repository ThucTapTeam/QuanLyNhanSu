package Viewer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BUS.ThanNhanBUS;
import Model.ThanNhan;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ThanNhanPanel extends JPanel {

	private JPanel  contentPane;
	private TableModel tablemodel;
	private JTable table;
	private JTextField tfMaNV;
	private JTextField tfTenTN;
	private JTextField tfNgaySinh;
	private JTextField tfGioiTinh;
	private ButtonGroup group;
	/**
	 * Create the panel.
	 */
	public void showtable()
	{
		List<String> columns = new ArrayList<String>();
		List<String[]> values = new ArrayList<String[]>();

		columns.add("Mã NV");
		columns.add("Tên ");
		columns.add("Ngày sinh");
		columns.add("Giới tính");
		columns.add("Quan Hệ");
		ThanNhanBUS thannhanbus = new ThanNhanBUS();
		List<ThanNhan> listthannhan = thannhanbus.getList("select * from ThanNhan");
		for (ThanNhan thannhan : listthannhan) {
			values.add(new String[] {String.valueOf(thannhan.getMaNV()),thannhan.getTenTN(),String.valueOf(thannhan.getNgaySinh()),thannhan.getGioiTinh(),thannhan.getQuanHe() });
		}
		tablemodel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
	}
	public ThanNhanPanel() {
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(303, 273, 119, 24);
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JRadioButton radBoy = new JRadioButton("Nam");
		panel_1.add(radBoy);
	
		JRadioButton radGirl = new JRadioButton("Nu");
		panel_1.add(radGirl);
		
		group = new ButtonGroup();
		group.add(radBoy);
		group.add(radGirl);
		
		
		setLayout(null);

		
		JLabel lbMaNV = new JLabel("MaNV");
		lbMaNV.setBounds(10, 242, 46, 14);
		add(lbMaNV);
		
		tfMaNV = new JTextField();
		tfMaNV.setEnabled(false);
		tfMaNV.setBounds(67, 238, 129, 20);
		add(tfMaNV);
		tfMaNV.setColumns(10);
		
		JLabel lbTenTN = new JLabel("Ten");
		lbTenTN.setBounds(10, 280, 46, 14);
		add(lbTenTN);
		
		tfTenTN = new JTextField();
		tfTenTN.setBounds(67, 277, 129, 20);
		add(tfTenTN);
		tfTenTN.setColumns(10);
		
		JLabel lbNgaySinh = new JLabel("Ngay Sinh");
		lbNgaySinh.setBounds(10, 318, 46, 14);
		add(lbNgaySinh);
		
		tfNgaySinh = new JTextField();
		tfNgaySinh.setBounds(67, 315, 129, 20);
		add(tfNgaySinh);
		tfNgaySinh.setColumns(10);
		
		JLabel lbGioiTinh = new JLabel("Gioi Tinh");
		lbGioiTinh.setBounds(234, 244, 59, 14);
		add(lbGioiTinh);
		
		tfGioiTinh = new JTextField();
		tfGioiTinh.setBounds(303, 244, 129, 20);
		add(tfGioiTinh);
		tfGioiTinh.setColumns(10);
		
		JLabel lbQuanHe = new JLabel("Quan He");
		lbQuanHe.setBounds(234, 280, 59, 14);
		add(lbQuanHe);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 724, 220);
		add(panel);
		
		showtable();
		panel.setLayout(null);
		table = new JTable(tablemodel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				TableModel model = table.getModel();
				tfMaNV.setText(model.getValueAt(row, 0).toString());
				tfTenTN.setText(model.getValueAt(row, 1).toString());
			}
		});
		table.setFillsViewportHeight(true);
		table.setBounds(10, 5, 704, 204);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 724, 220);
		panel.add(scrollPane);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ThanNhan obj = new ThanNhan();
					ThanNhanBUS thanhanbus = new ThanNhanBUS();
					obj.setMaNV(Integer.parseInt(tfMaNV.getText()));
					obj.setTenTN(tfTenTN.getText());
					obj.setNgaySinh(java.sql.Date.valueOf(tfNgaySinh.getText()));
					if(radBoy.isSelected())
						obj.setGioiTinh(true);
					if(radGirl.isSelected())
						obj.setGioiTinh(false);
					boolean check = thanhanbus.update(obj);
					if(check)
						JOptionPane.showMessageDialog(null, "Update Success");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Update Failed");

					// TODO: handle exception
				}
			}
		});
		btnUpdate.setBounds(234, 387, 89, 23);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ThanNhan obj = new ThanNhan();
					ThanNhanBUS thanhanbus = new ThanNhanBUS();
					obj.setMaNV(Integer.parseInt(tfMaNV.getText()));
					obj.setTenTN(tfTenTN.getText());
					obj.setNgaySinh(java.sql.Date.valueOf(tfNgaySinh.getText()));
					boolean check = thanhanbus.delete(obj);
					if(check)
						JOptionPane.showMessageDialog(null, "Update Success");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Update Failed");

					// TODO: handle exception
				}
			}
		});
		btnDelete.setBounds(343, 387, 89, 23);
		add(btnDelete);
	}
}
