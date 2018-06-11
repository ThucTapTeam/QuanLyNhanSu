package Viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.DuAn;

import java.awt.BorderLayout;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JPanel temp;
	private JPanel panel_2;
	

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 832, 24);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Quan Ly Nhan Su");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 28, 95, 398);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(100, 28, 737, 398);
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("NhanVien");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				temp  = new NhanVienPanel();
				panel_2.removeAll();
				panel_2.add(temp);
				panel_2.validate();			
			}
		});
		btnNewButton.setBounds(3, 5, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("PhanCong");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				temp = new PhanCongPanel();
				panel_2.removeAll();
				panel_2.add(temp);
				panel_2.validate();
			}
		});
		btnNewButton_2.setBounds(3, 33, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Du An");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				temp = new DuANPanel();
				panel_2.removeAll();
				panel_2.add(temp);
				panel_2.validate();
			}
		});
		btnNewButton_1.setBounds(3, 61, 89, 23);
		panel_1.add(btnNewButton_1);
		JButton btnNewButton_4 = new JButton("Than Nhan");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				temp = new ThanNhanPanel();
				panel_2.removeAll();
				panel_2.add(temp);
				panel_2.validate();
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_4.setBounds(3, 89, 89, 23);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Phong Ban");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				temp = new PhongBanPanel();
				panel_2.removeAll();
				panel_2.add(temp);
				panel_2.validate();
			}
		});
		btnNewButton_3.setBounds(3, 117, 89, 23);
		panel_1.add(btnNewButton_3);
	}
	public void changepanel2()
	{
		temp = new ThanNhanPanel();
		panel_2.removeAll();
		panel_2.add(temp);
		panel_2.validate();
	}
	
}
