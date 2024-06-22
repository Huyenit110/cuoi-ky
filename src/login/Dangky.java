package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import login.UserDAO;
import login.User;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class Dangky extends JFrame {

	private JPanel contentPane;
	private JTextField jtfUser;
	private JTextField jtfEmail;
	private JPasswordField jtfPW;
	private JTextField jtfTel;
	private UserDAO uDao = new UserDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dangky frame = new Dangky();
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
	public Dangky() {
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 395);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(313, 11, 106, 72);
		contentPane.add(lblNewLabel);

		jtfUser = new JTextField();
		jtfUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		jtfUser.setBounds(141, 116, 199, 32);
		contentPane.add(jtfUser);
		jtfUser.setColumns(10);

		jtfEmail = new JTextField();
		jtfEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		jtfEmail.setBounds(488, 192, 242, 32);
		contentPane.add(jtfEmail);
		jtfEmail.setColumns(10);

		jtfPW = new JPasswordField();
		jtfPW.setFont(new Font("Tahoma", Font.BOLD, 16));
		jtfPW.setBounds(141, 192, 199, 32);
		contentPane.add(jtfPW);

		jtfTel = new JTextField();
		jtfTel.setFont(new Font("Tahoma", Font.BOLD, 16));
		jtfTel.setBounds(488, 116, 242, 32);
		contentPane.add(jtfTel);
		jtfTel.setColumns(10);

		JButton jbtSignup = new JButton("Đăng ký");
		jbtSignup.setBackground(Color.GRAY);
		jbtSignup.setForeground(Color.BLACK);
		jbtSignup.setIcon(new ImageIcon("C:\\Users\\Administrator\\Downloads\\DoAnChat\\DoAnChat\\image\\registered.png"));
		jbtSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jtfUser.getText() != null) {
					String userName = jtfUser.getText();
					String pass = new String(jtfPW.getPassword());
					String tel = jtfTel.getText();
					String email = jtfEmail.getText();

					String validate = "null";

					if (userName.equals("")) {
						validate = "Username không được trống!";
					} else if (pass.equals("")) {
						validate = "Password không được trống!";
					} else if (tel.equals("")) {
						validate = "Telephone không được trống!";
					} else if (email.equals("")) {
						validate = "Email không được trống!";
					}
					if (!validate.equals("null")) {
						JOptionPane.showMessageDialog(null, validate);
					} else {
						User user = new User(userName, pass, tel, email);
						if (uDao.getUser(userName) == null) {
							try {
								if (uDao.addUser(user)) {
									JOptionPane.showMessageDialog(null, "Đăng ký thành công!");
									login log = new login();
									log.setVisible(true);
									exit();
								} else {
									JOptionPane.showMessageDialog(null, "Error!");
								}
							} catch (HeadlessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} else {
							JOptionPane.showMessageDialog(null, "Username đã đăng ký!");
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập username");
				}
			}
		});
		jbtSignup.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jbtSignup.setBounds(313, 297, 146, 49);
		contentPane.add(jbtSignup);

		JLabel jlbUser = new JLabel("User Name :");
		jlbUser.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jlbUser.setBounds(25, 113, 106, 34);
		contentPane.add(jlbUser);

		JLabel jlbPW = new JLabel("Password :");
		jlbPW.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jlbPW.setBounds(25, 192, 106, 32);
		contentPane.add(jlbPW);

		JLabel jlbEmail = new JLabel("Email :");
		jlbEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jlbEmail.setBounds(387, 194, 74, 30);
		contentPane.add(jlbEmail);

		JLabel jlbTel = new JLabel("Phone  :");
		jlbTel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jlbTel.setBounds(387, 114, 85, 33);
		contentPane.add(jlbTel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\apchat-main\\image\\registered.png"));
		lblNewLabel_1.setBounds(231, 11, 74, 72);
		contentPane.add(lblNewLabel_1);
		
		JCheckBox chckbxhienthimk = new JCheckBox("Hiển thị mật khẩu");
		chckbxhienthimk.setFont(new Font("Tahoma", Font.PLAIN, 17));
		chckbxhienthimk.setBounds(81, 252, 169, 23);
		chckbxhienthimk.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (chckbxhienthimk.isSelected()) {
					jtfPW.setEchoChar((char) 0);
				} else {
					jtfPW.setEchoChar('*');
				}
			}
			
		});
		contentPane.add(chckbxhienthimk);
	}

	private void exit() {
		this.setVisible(false);
	}
}