package assignment2022;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class FrameAdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtField_Username;
	private JTextField txtField_Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAdminLogin frame = new FrameAdminLogin();
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
	public FrameAdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1279, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		headerPanel.setBackground(new Color(100, 105, 155));
		contentPane.add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel ST_PageName = new JLabel("Admin Login");
		ST_PageName.setHorizontalAlignment(SwingConstants.CENTER);
		ST_PageName.setFont(new Font("Tahoma", Font.PLAIN, 60));
		headerPanel.add(ST_PageName, BorderLayout.CENTER);
		
		JButton btn_Return = new JButton("Return");
		btn_Return.setFont(new Font("Tahoma", Font.PLAIN, 30));
		headerPanel.add(btn_Return, BorderLayout.EAST);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBackground(new Color(226, 226, 226));
		bodyPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
		contentPane.add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBorder(new EmptyBorder(100, 300, 100, 300));
		loginPanel.setBackground(new Color(240, 240, 240));
		bodyPanel.add(loginPanel);
		loginPanel.setLayout(new GridLayout(0, 1, 0, 40));
		
		JLabel ST_Username = new JLabel("Username:");
		ST_Username.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_Username.setFont(new Font("Tahoma", Font.PLAIN, 35));
		ST_Username.setHorizontalAlignment(SwingConstants.CENTER);
		loginPanel.add(ST_Username);
		
		txtField_Username = new JTextField();
		txtField_Username.setFont(new Font("Tahoma", Font.PLAIN, 30));
		loginPanel.add(txtField_Username);
		txtField_Username.setColumns(10);
		
		JLabel ST_Password = new JLabel("Password:");
		ST_Password.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_Password.setHorizontalAlignment(SwingConstants.CENTER);
		ST_Password.setFont(new Font("Tahoma", Font.PLAIN, 35));
		loginPanel.add(ST_Password);
		
		txtField_Password = new JTextField();
		txtField_Password.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtField_Password.setColumns(10);
		loginPanel.add(txtField_Password);
		
		JButton btn_Login = new JButton("Log In");
		btn_Login.setFont(new Font("Tahoma", Font.PLAIN, 30));
		loginPanel.add(btn_Login);
	}

}
