package Viewer;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import BUS.NhanVienBUS;
import Model.NhanVien;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfID;
	private JPasswordField pfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfID = new JTextField();
		tfID.setBounds(189, 73, 132, 20);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(189, 120, 132, 20);
		contentPane.add(pfPassword);
		
		JLabel lblID = new JLabel("ID            :");
		lblID.setBounds(102, 76, 60, 14);
		contentPane.add(lblID);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setBounds(102, 123, 60, 14);
		contentPane.add(lblPassword);
		
		JButton btnDangNhap = new JButton("DangNhap");
		btnDangNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String username = tfID.getText();
				String password = pfPassword.getText();
				//System.out.println(password);
				NhanVienBUS nhanvienbus = new NhanVienBUS();
				List<NhanVien> listnhanvien = nhanvienbus.getList("select * from NhanVien");
				boolean check = false;
				for(NhanVien nhanvien: listnhanvien)
				{
					try {
						String id = nhanvien.getID();
						String pass = nhanvien.getPassword();
						check = id.equals(username) && pass.equals(password);
						System.out.println(check);
						if(check)
						{
							check= true;
							MainFrame frame = new MainFrame();
							frame.setLocationRelativeTo(null);
							frame.setExtendedState(MAXIMIZED_BOTH);
							frame.setVisible(true);
							dispose();
							break;

						}
					} catch (Exception e) {
					}
					
				}
				if (!check) {
					JOptionPane.showMessageDialog(null, "Tai Khoan Dang nhap khong dung");
				}
			}
		});
		btnDangNhap.setBounds(173, 191, 89, 23);
		contentPane.add(btnDangNhap);
	}
}
