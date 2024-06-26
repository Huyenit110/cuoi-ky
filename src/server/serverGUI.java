package server;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import data.Peer;
import login.loginGUI;

import javax.swing.ImageIcon;

public class serverGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtIP;
	private JTextField txtPort;
	private JLabel lblStatus;
	private static JTextArea txtMessage;
	public static JLabel lblUserOnline;
	public static int port = 8080;
	static ServerCore server;
	JButton btnStopServer, btnStartServer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					serverGUI frame = new serverGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void updateMessage(String msg) {
		txtMessage.append(msg + "\n");
	}

	public static void updateNumberClient() {
		int number = Integer.parseInt(lblUserOnline.getText());
		lblUserOnline.setText(Integer.toString(number + 1));
		displayUser();

	}

	public static void decreaseNumberClient() {
		int number = Integer.parseInt(lblUserOnline.getText());
		lblUserOnline.setText(Integer.toString(number - 1));
		displayUser();

	}

	static void displayUser() {
		txtMessage.setText("");
		ArrayList<Peer> list = server.getListUser();
		for (int i = 0; i < list.size(); i++) {
			txtMessage.append((i + 1) + "\t" + list.get(i).getName() + "\n");
		}
	}

	/**
	 * Create the frame.
	 */
	public serverGUI() {
		setResizable(false);
		setTitle("Server Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 757);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblcauhinhserver = new JLabel("Cấu hình Server");
		lblcauhinhserver.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblcauhinhserver.setBounds(300, 0, 245, 76);
		contentPane.add(lblcauhinhserver);

		JPanel panel = new JPanel();
		panel.setBounds(31, 100, 279, 34);
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JLabel lbldiachiIP = new JLabel("Địa chỉ IP :");
		lbldiachiIP.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(lbldiachiIP);

		panel.add(new JPanel());
		txtIP = new JTextField();
		txtIP.setEditable(false);
		txtIP.setForeground(Color.GREEN);
		txtIP.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel.add(txtIP);
		txtIP.setColumns(10);
		try {
			txtIP.setText(Inet4Address.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(31, 152, 279, 34);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblcongketnoi = new JLabel("Cổng kết nối :");
		lblcongketnoi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblcongketnoi.setBounds(0, 0, 113, 34);
		panel_1.add(lblcongketnoi);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(18, 0, 10, 34);
		panel_1.add(panel_2);

		txtPort = new JTextField();
		txtPort.setForeground(Color.RED);
		txtPort.setText("8080");
		txtPort.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtPort.setBounds(123, 0, 156, 34);
		panel_1.add(txtPort);
		txtPort.setColumns(10);

		JPanel thongtinserver = new JPanel();
		thongtinserver.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin server", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		thongtinserver.setBackground(Color.CYAN);
		thongtinserver.setBounds(394, 87, 395, 220);
		contentPane.add(thongtinserver);
		thongtinserver.setLayout(null);

		JLabel lbltrangthai = new JLabel("Trạng thái :");
		lbltrangthai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbltrangthai.setBounds(22, 56, 106, 30);
		thongtinserver.add(lbltrangthai);

		lblStatus = new JLabel("OFF");
		lblStatus.setForeground(Color.RED);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStatus.setBounds(231, 50, 124, 43);
		thongtinserver.add(lblStatus);

		JLabel lblslnguoidung = new JLabel("Số lượng người dùng :");
		lblslnguoidung.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblslnguoidung.setBounds(22, 132, 184, 32);
		thongtinserver.add(lblslnguoidung);

		lblUserOnline = new JLabel("0");
		lblUserOnline.setForeground(Color.DARK_GRAY);
		lblUserOnline.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserOnline.setBounds(240, 132, 84, 32);
		thongtinserver.add(lblUserOnline);

		JPanel tuychonpanel = new JPanel();
		tuychonpanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tu\u1EF3 Ch\u1ECDn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tuychonpanel.setBounds(31, 333, 758, 73);
		contentPane.add(tuychonpanel);

		btnStartServer = new JButton("Start");
		btnStartServer.setIcon(new ImageIcon("D:\\apchat-main\\image\\play.png"));
		btnStartServer.setFocusable(false);
		btnStartServer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					port = Integer.valueOf(txtPort.getText());
					server = new ServerCore(port);
					serverGUI.updateMessage("START SERVER ON PORT " + port);
					lblStatus.setText("<html><font color='green'>RUNNING...</font></html>");
					btnStopServer.setEnabled(true);
					btnStartServer.setEnabled(false);
				} catch (Exception e1) {
					serverGUI.updateMessage("START ERROR");
					e1.printStackTrace();
				}
			}
		});
		btnStartServer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tuychonpanel.add(btnStartServer);

		JPanel panel_5 = new JPanel();
		tuychonpanel.add(panel_5);
		tuychonpanel.add(new JPanel());

		btnStopServer = new JButton("Stop");
		btnStopServer.setIcon(new ImageIcon("D:\\apchat-main\\image\\stop-button.png"));
		btnStopServer.setEnabled(false);
		btnStopServer.setFocusable(false);
		btnStopServer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblUserOnline.setText("0");
				try {
					server.stopserver();
					serverGUI.updateMessage("STOP SERVER");
					lblStatus.setText("<html><font color='red'>OFF</font></html>");
					btnStopServer.setEnabled(false);
					btnStartServer.setEnabled(true);
				} catch (Exception ex) {
					ex.printStackTrace();
					serverGUI.updateMessage("STOP SERVER");
					lblStatus.setText("<html><font color='red'>OFF</font></html>");
					btnStopServer.setEnabled(false);
					btnStartServer.setEnabled(true);
				}
			}
		});
		btnStopServer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tuychonpanel.add(btnStopServer);

		JPanel dsnguoidungpanel = new JPanel();
		dsnguoidungpanel.setBorder(
				new TitledBorder(null, "Danh sách người dùng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtMessage = new JTextArea();
		txtMessage.setBackground(Color.BLACK);
		txtMessage.setForeground(Color.WHITE);
		txtMessage.setFont(new Font("Courier New", Font.PLAIN, 18));
		dsnguoidungpanel.setBounds(31, 417, 758, 293);
		dsnguoidungpanel.setLayout(new GridLayout(0, 1, 0, 0));
		JScrollPane scrollPane = new JScrollPane(txtMessage);
		dsnguoidungpanel.add(scrollPane);
		contentPane.add(dsnguoidungpanel);
		
		JLabel lblserverimg = new JLabel("");
		lblserverimg.setIcon(new ImageIcon("D:\\apchat-main\\image\\server.png"));
		lblserverimg.setBounds(255, 11, 46, 65);
		contentPane.add(lblserverimg);
		
	}
}
