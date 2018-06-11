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

import BUS.DuAnBUS;
import Model.DuAn;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DuANPanel extends JPanel {
	private JPanel  contentPane;
	private TableModel tablemodel;
	private JTable table;
	private JTextField tfMaDA;
	private JTextField tfTenDA;
	private JTextField tfDiaDiem;
	private JTextField tfMaPB;
	/**
	 * Create the panel.
	 */
	public void showtable()
	{
		List<String> columns = new ArrayList<String>();
		List<String[]> values = new ArrayList<String[]>();

		columns.add("Tên DA ");
		columns.add("Mã DA");
		columns.add("Mã PB");
		columns.add("Địa Điểm");
		
		DuAnBUS duanbus = new DuAnBUS();
		List<DuAn> listDA = duanbus.getList("select * from DuAn");
		for (DuAn duan : listDA) {
			System.out.println(duan.getMaDA());
			if(listDA != null)
				values.add(new String[] {String.valueOf(duan.getMaDA()),duan.getTenDA(),String.valueOf(duan.getMaPB()),String.valueOf(duan.getDiaDiem())});
		}
		tablemodel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
	}
	public DuANPanel() 
	{
	
		// TODO Auto-generated constructor stub {
		setLayout(null);

		
		JLabel lbMaDA = new JLabel("MaDA");
		lbMaDA.setBounds(10, 242, 46, 14);
		add(lbMaDA);
		
		tfMaDA = new JTextField();
		tfMaDA.setBounds(67, 238, 129, 20);
		add(tfMaDA);
		tfMaDA.setColumns(10);
		
		JLabel lbTenDA = new JLabel("Ten DA");
		lbTenDA.setBounds(10, 280, 46, 14);
		add(lbTenDA);
		
		tfTenDA = new JTextField();
		tfTenDA.setBounds(67, 277, 129, 20);
		add(tfTenDA);
		tfTenDA.setColumns(10);
		
		JLabel lbDiaDiem = new JLabel("\u0110\u1ECBa \u0110i\u1EC3m");
		lbDiaDiem.setBounds(234, 280, 67, 14);
		add(lbDiaDiem);
		
		tfDiaDiem = new JTextField();
		tfDiaDiem.setBounds(333, 277, 129, 20);
		add(tfDiaDiem);
		tfDiaDiem.setColumns(10);
		
		JLabel lbMaPB = new JLabel("Ma PB");
		lbMaPB.setBounds(234, 244, 89, 14);
		add(lbMaPB);
		
		tfMaPB = new JTextField();
		tfMaPB.setBounds(333, 244, 129, 20);
		add(tfMaPB);
		tfMaPB.setColumns(10);
		
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
			public void actionPerformed(ActionEvent arg0) {
				try {
					DuAn obj = new DuAn();
					DuAnBUS duanbus = new DuAnBUS();
					obj.setMaDA(Integer.parseInt(tfMaDA.getText()));
					obj.setTenDA(tfTenDA.getText());
					obj.setDiaDiem(tfDiaDiem.getText());
					obj.setMaPB(Integer.parseInt(tfMaPB.getText()));
					boolean check = duanbus.insert(obj);
					if(check)
						JOptionPane.showMessageDialog(null, "Insert Success");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Insert Failed");
				}
				
			}
		});
		btnInsert.setBounds(146, 345, 97, 25);
		add(btnInsert);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DuAn obj = new DuAn();
					DuAnBUS duanbus = new DuAnBUS();
					obj.setMaDA(Integer.parseInt(tfMaDA.getText()));
					obj.setTenDA(tfTenDA.getText());
					obj.setDiaDiem(tfDiaDiem.getText());
					obj.setMaPB(Integer.parseInt(tfMaPB.getText()));
					boolean check = duanbus.update(obj);
					if(check)
						JOptionPane.showMessageDialog(null, "Update Success");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Update Failed");
				}
			}
		});
		btnUpdate.setBounds(284, 345, 97, 25);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DuAn obj = new DuAn();
					DuAnBUS duanbus = new DuAnBUS();
					obj.setMaDA(Integer.parseInt(tfMaDA.getText()));
					obj.setTenDA(tfTenDA.getText());
					obj.setDiaDiem(tfDiaDiem.getText());
					obj.setMaPB(Integer.parseInt(tfMaPB.getText()));
					boolean check = duanbus.delete(obj);
					if(check)
						JOptionPane.showMessageDialog(null, "Insert Success");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Insert Failed");
				}
			}
		});
		btnDelete.setBounds(418, 345, 97, 25);
		add(btnDelete);
	}
}
