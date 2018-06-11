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

import BUS.PhanCongBUS;
import Model.NhanVien;
import Model.PhanCongDA;
import Model.ThanNhan;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PhanCongPanel extends JPanel {

	private JPanel  contentPane;
	private TableModel tablemodel;
	private JTable table;
	private JTextField tfMaNV;
	private JTextField tfMaDA;
	private JTextField tfSoGio;
	/**
	 * Create the panel.
	 */
	public void showtable(List<PhanCongDA> listda)
	{
		List<String> columns = new ArrayList<String>();
		List<String[]> values = new ArrayList<String[]>();
		columns.add("Mã NV");
		columns.add("Mã DA ");
		columns.add("Số Giờ");
		for (PhanCongDA phancongda : listda) {
			values.add(new String[] {String.valueOf(phancongda.getMaNV()),String.valueOf(phancongda.getMaDA()),String.valueOf(phancongda.getSoGio())});
		}
		tablemodel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
	}
	public void refreshTable(List<PhanCongDA> listda) {
		showtable(listda);
		table.setModel(tablemodel);
	}
	public PhanCongPanel() {
		PhanCongBUS phancongbus = new PhanCongBUS();
		List<PhanCongDA> listda = phancongbus.getList("select * from PhanCongDA");
		
		setLayout(null);
		JLabel lbMaNV = new JLabel("MaNV");
		lbMaNV.setBounds(10, 242, 46, 14);
		add(lbMaNV);
		tfMaNV = new JTextField();
		tfMaNV.setEnabled(false);
		tfMaNV.setBounds(67, 238, 129, 20);
		add(tfMaNV);
		tfMaNV.setColumns(10);
		
		tfMaDA = new JTextField();
		tfMaDA.setEnabled(false);
		tfMaDA.setBounds(570, 239, 129, 20);
		add(tfMaDA);
		tfMaDA.setColumns(10);
		
		JLabel lbSoGio = new JLabel("So Gio");
		lbSoGio.setBounds(227, 242, 59, 14);
		add(lbSoGio);
		
		tfSoGio = new JTextField();
		tfSoGio.setBounds(303, 239, 129, 20);
		add(tfSoGio);
		tfSoGio.setColumns(10);
		
		JLabel lbMaDA = new JLabel("Ma Da");
		lbMaDA.setBounds(488, 242, 59, 14);
		add(lbMaDA);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 724, 220);
		add(panel);
		
		showtable(listda);
		panel.setLayout(null);
		table = new JTable(tablemodel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				TableModel model = table.getModel();
				tfMaNV.setText(model.getValueAt(row, 0).toString());
				tfMaDA.setText(model.getValueAt(row, 1).toString());
				tfSoGio.setText(model.getValueAt(row, 2).toString());
				
				
			}
		});
		table.setFillsViewportHeight(true);
		table.setBounds(10, 5, 704, 204);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 724, 220);
		panel.add(scrollPane);
		
		JButton btnNewButton = new JButton("update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PhanCongBUS phancongbus = new PhanCongBUS();
					PhanCongDA obj = new PhanCongDA();
					obj.setMaDA(Integer.parseInt(tfMaDA.getText()));
					obj.setMaNV(Integer.parseInt(tfMaNV.getText()));
					obj.setSoGio(Integer.parseInt(tfSoGio.getText()));
					boolean  check = phancongbus.update(obj);
					if(check)
						JOptionPane.showMessageDialog(null, "Update success");
					refreshTable(listda);
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Update Failed");

				}
				
			}
		});
		btnNewButton.setBounds(222, 330, 97, 25);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PhanCongBUS phancongbus = new PhanCongBUS();
					PhanCongDA obj = new PhanCongDA();
					obj.setMaDA(Integer.parseInt(tfMaDA.getText()));
					obj.setMaNV(Integer.parseInt(tfMaNV.getText()));
					obj.setSoGio(Integer.parseInt(tfSoGio.getText()));
					boolean  check = phancongbus.delete(obj);
					if(check)
						JOptionPane.showMessageDialog(null, "Update success");
					refreshTable(listda);
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Update Failed");

				}
			}
		});
		btnNewButton_1.setBounds(365, 330, 97, 25);
		add(btnNewButton_1);
	}
}
