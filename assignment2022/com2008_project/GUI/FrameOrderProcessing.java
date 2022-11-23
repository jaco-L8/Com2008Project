<<<<<<< HEAD:assignment2022/com2008_project/GUI/FrameOrderProcessing.java
package com2008_project.GUI;
=======
package com2008_project.assignment2022;
>>>>>>> 8242a7f1cb51a0b84ce1746e4e7e2aa3c1a35e52:assignment2022/FrameOrderProcessing.java

import com2008_project.Database.*;
import com2008_project.BusinessLogic.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class FrameOrderProcessing extends JFrame {

	private JPanel contentPane;
	private JTextField txtField_FirstName;
	private JTextField txtField_LastName;
	private JTextField txtField_PostCode;
	private JTextField txtField_HouseNumber;
	private JTextField txtEnterAdminUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameOrderProcessing frame = new FrameOrderProcessing();
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
	public FrameOrderProcessing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(100, 105, 155));
		headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Order Processing");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(lblNewLabel);
		
		JButton btn_Return = new JButton("Return");
		btn_Return.setFont(new Font("Tahoma", Font.PLAIN, 30));
		headerPanel.add(btn_Return, BorderLayout.EAST);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
		bodyPanel.setBackground(new Color(226, 226, 226));
		contentPane.add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(new BorderLayout(50, 0));
		
		JPanel bikePartsPanel = new JPanel();
		bikePartsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		bodyPanel.add(bikePartsPanel);
		bikePartsPanel.setLayout(new GridLayout(0, 1, 0, 15));
		
		JLabel ST_FirstName = new JLabel("First Name:");
		ST_FirstName.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_FirstName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		bikePartsPanel.add(ST_FirstName);
		
		txtField_FirstName = new JTextField();
		txtField_FirstName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bikePartsPanel.add(txtField_FirstName);
		txtField_FirstName.setColumns(10);
		
		JLabel ST_LastName = new JLabel("Last Name:");
		ST_LastName.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_LastName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		bikePartsPanel.add(ST_LastName);
		
		txtField_LastName = new JTextField();
		txtField_LastName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtField_LastName.setColumns(10);
		bikePartsPanel.add(txtField_LastName);
		
		JLabel ST_PostCode = new JLabel("Post Code:");
		ST_PostCode.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_PostCode.setFont(new Font("Tahoma", Font.PLAIN, 30));
		bikePartsPanel.add(ST_PostCode);
		
		txtField_PostCode = new JTextField();
		txtField_PostCode.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtField_PostCode.setColumns(10);
		bikePartsPanel.add(txtField_PostCode);
		
		JLabel ST_HouseNumber = new JLabel("House Number:");
		ST_HouseNumber.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_HouseNumber.setFont(new Font("Tahoma", Font.PLAIN, 30));
		bikePartsPanel.add(ST_HouseNumber);
		
		txtField_HouseNumber = new JTextField();
		txtField_HouseNumber.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtField_HouseNumber.setColumns(10);
		bikePartsPanel.add(txtField_HouseNumber);
		
		JPanel bikeStatPanel = new JPanel();
		bikeStatPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		bodyPanel.add(bikeStatPanel, BorderLayout.EAST);
		bikeStatPanel.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel statTitlePanel = new JPanel();
		statTitlePanel.setBackground(new Color(100, 105, 155));
		bikeStatPanel.add(statTitlePanel);
		statTitlePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel ST_BikeStats = new JLabel("Bike Information:");
		ST_BikeStats.setHorizontalAlignment(SwingConstants.CENTER);
		ST_BikeStats.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ST_BikeStats.setBackground(new Color(74, 74, 181));
		statTitlePanel.add(ST_BikeStats);
		
		JLabel ST_Price = new JLabel("Price Of Bike:");
		ST_Price.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_Price.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bikeStatPanel.add(ST_Price);
		
		JLabel varText_Price = new JLabel("\u00A31000");
		varText_Price.setVerticalAlignment(SwingConstants.TOP);
		varText_Price.setForeground(new Color(74, 74, 181));
		varText_Price.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bikeStatPanel.add(varText_Price);
		
		JLabel ST_BikeType = new JLabel("Bike Type:");
		ST_BikeType.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_BikeType.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bikeStatPanel.add(ST_BikeType);
		
		JLabel varText_BikeType = new JLabel("Mountain Bike");
		varText_BikeType.setVerticalAlignment(SwingConstants.TOP);
		varText_BikeType.setForeground(new Color(74, 74, 181));
		varText_BikeType.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bikeStatPanel.add(varText_BikeType);
		
		JLabel ST_BikeName = new JLabel("Bike Name:");
		ST_BikeName.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_BikeName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bikeStatPanel.add(ST_BikeName);
		
		JLabel varText_BikeName = new JLabel("The Dirty Wheeler");
		varText_BikeName.setVerticalAlignment(SwingConstants.TOP);
		varText_BikeName.setForeground(new Color(74, 74, 181));
		varText_BikeName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bikeStatPanel.add(varText_BikeName);
		
		JRadioButton rdbtn_PayNow = new JRadioButton("Press To Pay Now");
		rdbtn_PayNow.setBackground(new Color(216, 218, 237));
		rdbtn_PayNow.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtn_PayNow.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bikeStatPanel.add(rdbtn_PayNow);
		
		txtEnterAdminUser = new JTextField();
		txtEnterAdminUser.setForeground(new Color(74, 74, 188));
		txtEnterAdminUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEnterAdminUser.setText("Admin User(Pay Now Only)");
		bikeStatPanel.add(txtEnterAdminUser);
		txtEnterAdminUser.setColumns(10);
		
		JButton btn_Order = new JButton("Order");
		btn_Order.setFont(new Font("Tahoma", Font.PLAIN, 30));
		bikeStatPanel.add(btn_Order);
	}

}
