package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import login.UserDAO;
import server.serverGUI;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class login extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField jtfUser;
	private JPasswordField jtfPW;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 410);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbllogin = new JLabel("Login");
		lbllogin.setForeground(Color.RED);
		lbllogin.setBounds(279, 28, 113, 44);
		lbllogin.setFont(new Font("Times New Roman", Font.BOLD, 40));
		contentPane.add(lbllogin);

		jtfUser = new JTextField();
		jtfUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		jtfUser.setBounds(279, 136, 321, 31);
		contentPane.add(jtfUser);
		jtfUser.setColumns(10);

		jtfPW = new JPasswordField();
		jtfPW.setFont(new Font("Tahoma", Font.BOLD, 16));
		jtfPW.setBounds(279, 218, 321, 31);
		contentPane.add(jtfPW);

		JLabel jlbUser = new JLabel("User Name :");
		jlbUser.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jlbUser.setBounds(106, 137, 113, 24);
		contentPane.add(jlbUser);

		JLabel jlbPW = new JLabel("Password :");
		jlbPW.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jlbPW.setBounds(106, 219, 113, 24);
		contentPane.add(jlbPW);

		JButton btndangnhap = new JButton("Đăng nhập");
		btndangnhap.setIcon(new ImageIcon("D:\\apchat-main\\image\\login.png"));
		btndangnhap.addActionListener(this);

		btndangnhap.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btndangnhap.setBounds(158, 318, 150, 43);
		contentPane.add(btndangnhap);

		JButton btndangky = new JButton("Đăng ký");
		btndangky.setIcon(new ImageIcon("D:\\apchat-main\\image\\verify.png"));
		btndangky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dangky sg = new Dangky();
				sg.setVisible(true);
				exit();
			}
		});
		btndangky.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btndangky.setBounds(461, 318, 149, 43);
		contentPane.add(btndangky);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\apchat-main\\image\\login (1).png"));
		lblNewLabel_1.setBounds(188, 28, 71, 57);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\apchat-main\\image\\lock (1).png"));
		lblNewLabel_2.setBounds(31, 192, 65, 57);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\apchat-main\\image\\user (3).png"));
		lblNewLabel_3.setBounds(31, 110, 65, 71);
		contentPane.add(lblNewLabel_3);
		
		JCheckBox chckbxhienmk = new JCheckBox("Hiện mật khẩu");
		chckbxhienmk.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxhienmk.setBounds(200, 274, 162, 37);
		chckbxhienmk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (chckbxhienmk.isSelected()) {
					jtfPW.setEchoChar((char) 0);
				} else {
					jtfPW.setEchoChar('*');
				}
			}
			
		});
		contentPane.add(chckbxhienmk);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		UserDAO uDao = new UserDAO();
		if(e.getActionCommand().equals("Đăng nhập")) {
			String username = jtfUser.getText();
			String password = new String(jtfPW.getPassword());
			if (uDao.login(username,password)!= null) {
				JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
				serverGUI cl = new serverGUI();
				cl.setVisible(true);
				contentPane.setVisible(false);
				exit();
			}else {
				JOptionPane.showConfirmDialog(null, "Tài khoản đăng nhập sai. Vui lòng thử lại");
				
			}
		}
		if(e.getActionCommand().equals("Đăng ký")) { 
			String username = jtfUser.getText();
			String password = new String(jtfPW.getPassword());
			if (username.trim().equals("")&& password.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng đăng ký");
		        
			}
		}
	}
	private void exit() {
		this.setVisible(false);
	}
}