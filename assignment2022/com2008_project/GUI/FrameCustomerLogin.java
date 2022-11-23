<<<<<<< HEAD:assignment2022/com2008_project/GUI/FrameCustomerLogin.java
package com2008_project.GUI;
=======
package com2008_project.assignment2022;
>>>>>>> 8242a7f1cb51a0b84ce1746e4e7e2aa3c1a35e52:assignment2022/FrameCustomerLogin.java

import com2008_project.Database.*;
import com2008_project.BusinessLogic.*;
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
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;

public class FrameCustomerLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtField_OrderID;
	private JTextField txtField_FirstName;
	private JTextField txtField_LastName;
	private JTextField txtField_PostCode;
	private JTextField txtField_HouseNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCustomerLogin frame = new FrameCustomerLogin();
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
	public FrameCustomerLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		headerPanel.setBackground(new Color(100, 105, 155));
		contentPane.add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel ST_PageName = new JLabel("Customer Login");
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
		bodyPanel.setLayout(new GridLayout(0, 2, 50, 0));
		
		JPanel viewOrdersLoginPanel = new JPanel();
		viewOrdersLoginPanel.setBorder(new EmptyBorder(25, 50, 25, 50));
		bodyPanel.add(viewOrdersLoginPanel);
		viewOrdersLoginPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 10));
		
		JLabel ST_ViewOrders = new JLabel("View Orders");
		ST_ViewOrders.setHorizontalAlignment(SwingConstants.CENTER);
		ST_ViewOrders.setFont(new Font("Tahoma", Font.PLAIN, 40));
		viewOrdersLoginPanel.add(ST_ViewOrders);
		
		JLabel ST_FirstName = new JLabel("First Name:");
		ST_FirstName.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_FirstName.setHorizontalAlignment(SwingConstants.LEFT);
		ST_FirstName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		viewOrdersLoginPanel.add(ST_FirstName);
		
		txtField_FirstName = new JTextField();
		txtField_FirstName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtField_FirstName.setColumns(10);
		txtField_FirstName.setAlignmentY(1.0f);
		txtField_FirstName.setAlignmentX(0.0f);
		viewOrdersLoginPanel.add(txtField_FirstName);
		
		JLabel ST_LastName = new JLabel("Last Name:");
		ST_LastName.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_LastName.setHorizontalAlignment(SwingConstants.LEFT);
		ST_LastName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		viewOrdersLoginPanel.add(ST_LastName);
		
		txtField_LastName = new JTextField();
		txtField_LastName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtField_LastName.setColumns(10);
		txtField_LastName.setAlignmentY(1.0f);
		txtField_LastName.setAlignmentX(0.0f);
		viewOrdersLoginPanel.add(txtField_LastName);
		
		JLabel ST_LastName_1 = new JLabel("Post Code:");
		ST_LastName_1.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_LastName_1.setHorizontalAlignment(SwingConstants.LEFT);
		ST_LastName_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		viewOrdersLoginPanel.add(ST_LastName_1);
		
		txtField_PostCode = new JTextField();
		txtField_PostCode.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtField_PostCode.setColumns(10);
		txtField_PostCode.setAlignmentY(1.0f);
		txtField_PostCode.setAlignmentX(0.0f);
		viewOrdersLoginPanel.add(txtField_PostCode);
		
		JLabel ST_HouseNumber = new JLabel("House Number:");
		ST_HouseNumber.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_HouseNumber.setHorizontalAlignment(SwingConstants.LEFT);
		ST_HouseNumber.setFont(new Font("Tahoma", Font.PLAIN, 30));
		viewOrdersLoginPanel.add(ST_HouseNumber);
		
		txtField_HouseNumber = new JTextField();
		txtField_HouseNumber.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtField_HouseNumber.setColumns(10);
		txtField_HouseNumber.setAlignmentY(1.0f);
		txtField_HouseNumber.setAlignmentX(0.0f);
		viewOrdersLoginPanel.add(txtField_HouseNumber);
		
		JButton btn_ViewOrders = new JButton("View Orders");
		btn_ViewOrders.setFont(new Font("Tahoma", Font.PLAIN, 30));
		viewOrdersLoginPanel.add(btn_ViewOrders);
		
		JPanel viewOrderLoginPanel = new JPanel();
		viewOrderLoginPanel.setBorder(new EmptyBorder(100, 50, 100, 50));
		bodyPanel.add(viewOrderLoginPanel);
		viewOrderLoginPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 25));
		
		JLabel ST_ViewOrder = new JLabel("View Order");
		ST_ViewOrder.setHorizontalAlignment(SwingConstants.CENTER);
		ST_ViewOrder.setFont(new Font("Tahoma", Font.PLAIN, 40));
		viewOrderLoginPanel.add(ST_ViewOrder);
		
		JLabel ST_OrderID = new JLabel("Order ID:");
		ST_OrderID.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_OrderID.setHorizontalAlignment(SwingConstants.LEFT);
		ST_OrderID.setFont(new Font("Tahoma", Font.PLAIN, 30));
		viewOrderLoginPanel.add(ST_OrderID);
		
		txtField_OrderID = new JTextField();
		txtField_OrderID.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		txtField_OrderID.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtField_OrderID.setFont(new Font("Tahoma", Font.PLAIN, 25));
		viewOrderLoginPanel.add(txtField_OrderID);
		txtField_OrderID.setColumns(10);
		
		JButton btn_ViewOrder = new JButton("View Order");
		btn_ViewOrder.setFont(new Font("Tahoma", Font.PLAIN, 30));
		viewOrderLoginPanel.add(btn_ViewOrder);
	}

}
