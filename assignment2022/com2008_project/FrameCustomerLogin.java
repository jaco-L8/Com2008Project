
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
import java.awt.Window;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FrameCustomerLogin extends JFrame implements ActionListener {

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
//initialize
JButton btn_Return ;
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
		btn_Return.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FrameHomeState mf = new FrameHomeState();
				mf.setVisible(true);
				setVisible(false);
			}
		});
		
		
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
		btn_ViewOrders.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String firstName = txtField_FirstName.getText();
				String lastName = txtField_LastName.getText();
				String postCode = txtField_PostCode.getText();
				String houseNumber = txtField_HouseNumber.getText();
				
				final String DB_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team048";
				final String USER = "team048";
				final String PASS = "8780772c";
				try {
					Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
					Statement stmt = conn.createStatement();
					System.out.println("Inserting records into the table...");
					String sql = "SELECT * FROM team048.Customers WHERE CustomerName = '"+firstName+"' AND CustomerSurname = '"+lastName+"' AND "
							+ "CustomerPostCode = '"+postCode+"' AND CustomerHouseNumber = '"+houseNumber+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(!(rs.next())) {
						System.out.println("No User Found.");
					}
					else {
						int CustomerID = rs.getInt("CustomerID");
						System.out.println(CustomerID);
						FrameYourOrders mf = new FrameYourOrders(CustomerID);
						mf.setVisible(true);
						setVisible(false);
					}
				}
				catch (SQLException ea) {
					ea.printStackTrace();
				}
				
			}

			/*private void JDBCExample(String firstName, String lastName, String postCode, String houseNumber) {
				final String DB_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team048";
				final String USER = "team048";
				final String PASS = "8780772c";
				try {
					Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
					Statement stmt = conn.createStatement();
				System.out.println("Inserting records into the table...");
				Integer customerID = 1;
				String sql = "INSERT INTO "+USER+".Customers (CustomerName,CustomerSurname,CustomerPostCode, CustomerHouseNumber) VALUES ('"+firstName+"', '"+lastName+"','"+postCode+"', '"+houseNumber+"')";
				stmt.executeUpdate(sql);
				System.out.println("Inserted records into the table...");   	  
				}
				catch (SQLException e) {
					e.printStackTrace();
				} 
			}*/
				
		});
		
		
		
		
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
		btn_ViewOrder.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				final String DB_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team048";
				final String USER = "team048";
				final String PASS = "8780772c";
				try {
					System.out.println("Connecting...");
					String BikeID = txtField_OrderID.getText();
					Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
					Statement Stmt = conn.createStatement();
					
					String sqlQuery = "SELECT * FROM team048.CustomerOrders WHERE BikeID = '"+BikeID+"'";
					
					ResultSet rs = Stmt.executeQuery(sqlQuery);
					
					if((rs.next())) {
						System.out.println("Bike Found");
						int OrderID = rs.getInt("OrderID");
						System.out.println(OrderID);
						int Confirmed = rs.getInt("Confirmed");
						int Fulfilled = rs.getInt("Fullfilled");
						if(Confirmed == 0 && Fulfilled == 0) {
							FrameBuildBike mf = new FrameBuildBike();
							mf.LoadBikeDetails(OrderID);
							mf.setVisible(true);
							setVisible(false);
						}
						else {
							System.out.println("Order Paid For/Fulfilled");
						}
					}
					else {
						System.out.println("No Order Found");
					}
				}
				catch (SQLException ea) {
					ea.printStackTrace();
				}
			}
		});
		
		
		
	}
	
	
	
	/*public class JDBCExample {
		   static final String DB_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team048";
		   static final String USER = "team048";
		   static final String PASS = "8780772c";

		   public static void JDBCExample(String FirstName,String LastName, String PostCode, String HouseNumber) {
		         System.out.println("Inserting records into the table...");          
		         String sql = "INSERT INTO "+USER+".Customers (CustomerName,CustomerSurname,CustomerPostCode, CustomerHouseNumber) VALUES ('john', 'doe','s1s1s1', '123')";
		         stmt.executeUpdate(sql);
		         System.out.println("Inserted records into the table...");   	  
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
		   }
		} */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}


}
