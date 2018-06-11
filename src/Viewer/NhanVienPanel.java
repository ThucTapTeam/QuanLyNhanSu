package Viewer;

import java.util.ArrayList;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import BUS.NhanVienBUS;
import Model.NhanVien;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;


public class NhanVienPanel extends JPanel {
	private JPanel  contentPane;
	private TableModel tablemodel;
	private JTextField tfMaNV;
	private JTextField tfTenNV;
	private JTextField tfHoNV;
	private JTextField tfNgaySinh;
	private JTextField tfLuong;
	private JTextField tfMaPB;
	private JTextField tfDiaChi;
	private ButtonGroup group;
	private JTable table;

	/**
	 * Create the panel.
	 */
	
	public void showtable()
	{
		List<String> columns = new ArrayList<String>();
		List<String[]> values = new ArrayList<String[]>();

		columns.add("Mã NV");
		columns.add("Tên NV");
		columns.add("Họ NV");
		columns.add("Ngày sinh");
		columns.add("Địa chỉ");
		columns.add("Giới tính");
		columns.add("Lương");
		columns.add("Mã PB");
		NhanVienBUS nhanvienbus = new NhanVienBUS();
		List<NhanVien> listnhanvien = nhanvienbus.getList("select * from nhanvien");
		for (NhanVien nhanvien : listnhanvien) {
			values.add(new String[] {String.valueOf(nhanvien.getMaNV()),nhanvien.getTenNV(),nhanvien.getHoNV(),String.valueOf(nhanvien.getNgaySinh()),nhanvien.getDiaChi(),nhanvien.getGioiTinh(),String.valueOf(nhanvien.getLuong()),String.valueOf(nhanvien.getMaPB()) });
		}
		tablemodel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
	}
	public void refreshTable() {
		showtable();
		table.setModel(tablemodel);
	}
	public NhanVienPanel() {
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(303, 280, 129, 24);
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JRadioButton radBoy = new JRadioButton("Nam");
		panel_1.add(radBoy);
	
		JRadioButton radGirl = new JRadioButton("Nu");
		panel_1.add(radGirl);
		
		group = new ButtonGroup();
		group.add(radBoy);
		group.add(radGirl);
		
		JLabel lblNewLabel = new JLabel("MaNV");
		lblNewLabel.setBounds(10, 242, 46, 14);
		add(lblNewLabel);
		
		tfMaNV = new JTextField();
		tfMaNV.setBounds(67, 238, 129, 20);
		add(tfMaNV);
		tfMaNV.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ten NV");
		lblNewLabel_1.setBounds(10, 280, 46, 14);
		add(lblNewLabel_1);
		
		tfTenNV = new JTextField();
		tfTenNV.setBounds(67, 277, 129, 20);
		add(tfTenNV);
		tfTenNV.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ho NV");
		lblNewLabel_2.setBounds(10, 318, 46, 14);
		add(lblNewLabel_2);
		
		tfHoNV = new JTextField();
		tfHoNV.setBounds(67, 315, 129, 20);
		add(tfHoNV);
		tfHoNV.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ngay Sinh");
		lblNewLabel_3.setBounds(234, 244, 59, 14);
		add(lblNewLabel_3);
		
		tfNgaySinh = new JTextField();
		tfNgaySinh.setBounds(303, 244, 129, 20);
		add(tfNgaySinh);
		tfNgaySinh.setColumns(10);
		
		JLabel lblGioiTinh = new JLabel("Gioi Tinh");
		lblGioiTinh.setBounds(234, 280, 46, 14);
		add(lblGioiTinh);
		
		JLabel lblNewLabel_4 = new JLabel("Luong");
		lblNewLabel_4.setBounds(472, 280, 59, 14);
		add(lblNewLabel_4);
		
		tfLuong = new JTextField();
		tfLuong.setBounds(528, 277, 129, 20);
		add(tfLuong);
		tfLuong.setColumns(10);
		
		JLabel lblMaPb = new JLabel("Ma PB");
		lblMaPb.setBounds(472, 247, 46, 14);
		add(lblMaPb);
		
		tfMaPB = new JTextField();
		tfMaPB.setBounds(528, 241, 129, 20);
		add(tfMaPB);
		tfMaPB.setColumns(10);
		
		JLabel lblaCh = new JLabel("Dia Chi");
		lblaCh.setBounds(234, 318, 46, 14);
		add(lblaCh);
		
		tfDiaChi = new JTextField();
		tfDiaChi.setBounds(303, 315, 354, 20);
		add(tfDiaChi);
		tfDiaChi.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 724, 220);
		add(panel);
		
		showtable();
		panel.setLayout(null);
		table = new JTable(tablemodel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				TableModel model = table.getModel();
				tfMaNV.setText(model.getValueAt(row, 0).toString());
				tfTenNV.setText(model.getValueAt(row, 1).toString());
				tfHoNV.setText(model.getValueAt(row,2).toString());
				tfNgaySinh.setText(model.getValueAt(row, 3).toString());
				tfDiaChi.setText(model.getValueAt(row, 4).toString());
				String Gioitinh = model.getValueAt(row, 5).toString().toLowerCase();
				if(Gioitinh == "nam")
				{
					radBoy.setSelected(true);
				}
				if(Gioitinh == "nu")
				{
					radGirl.setSelected(true);
				}
				tfLuong.setText(model.getValueAt(row, 6).toString());
				tfMaPB.setText(model.getValueAt(row, 7).toString());
				
				
			}
		});
		table.setFillsViewportHeight(true);
		table.setBounds(10, 5, 704, 204);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 704, 198);
		panel.add(scrollPane);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					NhanVienBUS nhanvienbus = new NhanVienBUS();
					NhanVien obj = new NhanVien();
					obj.setTenNV(tfTenNV.getText());
					obj.setHoNV(tfHoNV.getText());
				   if(radBoy.isSelected())
				   {
					   obj.setGioiTinh(true);
				   }
				   if(radGirl.isSelected())
				   {
					   obj.setGioiTinh(false);
				   }
				   obj.setDiaChi(tfDiaChi.getText());
				   obj.setLuong(Integer.parseInt(tfLuong.getText()));
				   obj.setMaNV(Integer.parseInt(tfMaNV.getText()));
				   obj.setMaPB(Integer.parseInt(tfMaPB.getText()));
				   obj.setNgaySinh(Date.valueOf(tfNgaySinh.getText()));
				   boolean check = nhanvienbus.insert(obj);
				   if(check)
					   JOptionPane.showMessageDialog(null, "Insert success!!!");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Insert failed!!!");
				}
			}
		});
		btnInsert.setBounds(150, 382, 118, 23);
		add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					NhanVienBUS nhanvienbus = new NhanVienBUS();
					NhanVien obj = new NhanVien();
					obj.setTenNV(tfTenNV.getText());
					obj.setHoNV(tfHoNV.getText());
				   if(radBoy.isSelected())
				   {
					   obj.setGioiTinh(true);
				   }
				   if(radGirl.isSelected())
				   {
					   obj.setGioiTinh(false);
				   }
				   obj.setDiaChi(tfDiaChi.getText());
				   obj.setLuong(Integer.parseInt(tfLuong.getText()));
				   obj.setMaNV(Integer.parseInt(tfMaNV.getText()));
				   obj.setMaPB(Integer.parseInt(tfMaPB.getText()));
				   obj.setNgaySinh(Date.valueOf(tfNgaySinh.getText()));
				   boolean check = nhanvienbus.update(obj);
				   if(check)
					   JOptionPane.showMessageDialog(null, "Update success!!!");
				   refreshTable();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Update failed!!!");
				}
				
			}
		});
		btnUpdate.setBounds(295, 382, 118, 23);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					NhanVienBUS nhanvienbus = new NhanVienBUS();
					NhanVien obj = new NhanVien();
					obj.setTenNV(tfTenNV.getText());
					obj.setHoNV(tfHoNV.getText());
				   if(radBoy.isSelected())
				   {
					   obj.setGioiTinh(true);
				   }
				   if(radGirl.isSelected())
				   {
					   obj.setGioiTinh(false);
				   }
				   obj.setDiaChi(tfDiaChi.getText());
				   obj.setLuong(Integer.parseInt(tfLuong.getText()));
				   obj.setMaNV(Integer.parseInt(tfMaNV.getText()));
				   obj.setMaPB(Integer.parseInt(tfMaPB.getText()));
				   obj.setNgaySinh(Date.valueOf(tfNgaySinh.getText()));
				   boolean check = nhanvienbus.delete(obj);
				   if(check)
					   JOptionPane.showMessageDialog(null, "Delete success!!!");
				   refreshTable();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Delete failed!!!");
				}
			}
		});
		btnDelete.setBounds(439, 382, 118, 23);
		add(btnDelete);
		
		
		

	}
}
