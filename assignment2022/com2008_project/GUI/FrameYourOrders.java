
package com2008_project.GUI;

import com2008_project.Database.*;
import com2008_project.BusinessLogic.*;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.FlowLayout;

public class FrameYourOrders extends JFrame implements ActionListener, ItemListener {

	private JPanel contentPane;
	private JComboBox OrdersBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameYourOrders frame = new FrameYourOrders(1);
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
	public FrameYourOrders(int CustomerID) {
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
		
		JLabel ST_PageName = new JLabel("Your Orders");
		ST_PageName.setHorizontalAlignment(SwingConstants.CENTER);
		ST_PageName.setFont(new Font("Tahoma", Font.PLAIN, 60));
		headerPanel.add(ST_PageName, BorderLayout.CENTER);
		
		JButton btn_Return = new JButton("Return");
		btn_Return.setFont(new Font("Tahoma", Font.PLAIN, 30));
		headerPanel.add(btn_Return, BorderLayout.EAST);
		
		btn_Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameCustomerLogin mf = new FrameCustomerLogin();
				mf.setVisible(true);
				setVisible(false);
			}
		});

		
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
		bodyPanel.setBackground(new Color(226, 226, 226));
		contentPane.add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBorder(new EmptyBorder(150, 300, 150, 300));
		loginPanel.setBackground(SystemColor.menu);
		bodyPanel.add(loginPanel, BorderLayout.CENTER);
		loginPanel.setLayout(new GridLayout(0, 1, 0, 40));
		
		JLabel ST_YourOrders = new JLabel("Select An Order To Edit:");
		ST_YourOrders.setFont(new Font("Tahoma", Font.PLAIN, 30));
		loginPanel.add(ST_YourOrders);
		
		List<String> CustomerOrders=new ArrayList<>();
		try {
			final String DB_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team048";
			final String USER = "team048";
			final String PASS = "8780772c";
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			Statement stmt = conn.createStatement();
			
			String sqlQuery = "SELECT * FROM team048.CustomerOrders WHERE CustomerID = '"+CustomerID+"'";
			System.out.println(CustomerID);
			
			ResultSet rs = stmt.executeQuery(sqlQuery);
			while (rs.next()) {      
				CustomerOrders.add(rs.getString("BikeID"));   
			}
			System.out.println(CustomerOrders);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		String[] OrdersArray = CustomerOrders.toArray(new String[0]);
		
		OrdersBox = new JComboBox(OrdersArray);
		OrdersBox.addItemListener(this);
		loginPanel.add(OrdersBox);
		
		JButton btn_LoadOrder = new JButton("Load Selected Order");
		btn_LoadOrder.setFont(new Font("Tahoma", Font.PLAIN, 30));
		loginPanel.add(btn_LoadOrder);
		btn_LoadOrder.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
			final String DB_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team048";
			final String USER = "team048";
			final String PASS = "8780772c";
			try {
				Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
				Statement stmt = conn.createStatement();
				
				String BikeID = (String) OrdersBox.getSelectedItem();
				String sqlQuery = "SELECT * FROM team048.CustomerOrders WHERE BikeID = '"+BikeID+"'";
				
				ResultSet rs = stmt.executeQuery(sqlQuery);
				if (!(rs.next())) {
					System.out.println("Somehow nothing selected???.");
				}
				else {
					Integer Confirmed = rs.getInt("Confirmed");
					if(Confirmed == 1) {
						String popupText = "This Order Has Been Paid For So is No Longer Editable.";
						JOptionPane.showMessageDialog(null, popupText);
					}
					else {
						int SelectedOrderID = rs.getInt("OrderID");
						FrameBuildBike mf = new FrameBuildBike();
						mf.LoadBikeDetails(SelectedOrderID);
						mf.setVisible(true);
						setVisible(false);
					}
				}
			}
			catch (SQLException ea) {
				ea.printStackTrace();
			}
				
		}
		
	});
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}