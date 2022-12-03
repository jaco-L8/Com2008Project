
package com2008_project.GUI;

import java.util.Random;
import java.util.random.*;
import com2008_project.Database.*;
import com2008_project.BusinessLogic.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.JRadioButton;

public class FrameOrderProcessing extends JFrame implements ActionListener {

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
	
	JLabel varText_Price;
	JLabel varText_BikeType;
	JLabel varText_BikeName;
	JRadioButton rdbtn_PayNow;
	
	String BikeFrame = "";
	String BikeHandle = "";
	String BikeWheels = "";
	String FrameType = "";
	String TotalCost = "";
	String BikeName = "";
	String wheelID = "";
	String frameID = "";
	String handleID = "";
	boolean isEdit = false;
	int OrderID = 0;
	
	
	public void SetBikeDetails(String BFrame,String BHandle,String BWheels,String FType,String TCost,String BName,boolean editBool, int editOrderID) {
		BikeFrame = BFrame;
		BikeHandle = BHandle;
		BikeWheels = BWheels;
		FrameType = FType;
		TotalCost = TCost;
		BikeName = BName;
		OrderID = editOrderID;
		System.out.println("Setting variables for bike information.");
		varText_BikeType.setText(FrameType);
		varText_Price.setText(TotalCost);
		varText_BikeName.setText(BikeName);
		isEdit = editBool;
		
		if(editBool){
			this.EditBikeProcessing();
		}
		
		final String DB_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team048";
		final String USER = "team048";
		final String PASS = "8780772c";
		try {
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			Statement stmt = conn.createStatement();
			
			String sqlQueryWheels = "SELECT * FROM team048.Wheels WHERE WheelsName = '"+BikeWheels+"'";
			String sqlQueryHandles = "SELECT * FROM team048.HandleBar WHERE HandleName = '"+BikeHandle+"'";
			String sqlQueryFrames = "SELECT * FROM team048.Frames WHERE FrameName = '"+BikeFrame+"'";
			
			ResultSet wheelsRs = stmt.executeQuery(sqlQueryWheels);
			wheelsRs.next();
			wheelID = wheelsRs.getString("WheelsID");
			
			ResultSet handlesRs = stmt.executeQuery(sqlQueryHandles);
			handlesRs.next();
			handleID = handlesRs.getString("HandleID");
			
			ResultSet framesRs = stmt.executeQuery(sqlQueryFrames);
			framesRs.next();
			frameID = framesRs.getString("FrameID");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		btn_Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameHomeState mf = new FrameHomeState();
				mf.setVisible(true);
				setVisible(false);
			}
		});
		
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
		
		varText_Price = new JLabel("\u00A3" + TotalCost);
		varText_Price.setVerticalAlignment(SwingConstants.TOP);
		varText_Price.setForeground(new Color(74, 74, 181));
		varText_Price.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bikeStatPanel.add(varText_Price);
		
		JLabel ST_BikeType = new JLabel("Bike Type:");
		ST_BikeType.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_BikeType.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bikeStatPanel.add(ST_BikeType);
		
		varText_BikeType = new JLabel(FrameType);
		varText_BikeType.setVerticalAlignment(SwingConstants.TOP);
		varText_BikeType.setForeground(new Color(74, 74, 181));
		varText_BikeType.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bikeStatPanel.add(varText_BikeType);
		
		JLabel ST_BikeName = new JLabel("Bike Name:");
		ST_BikeName.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_BikeName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bikeStatPanel.add(ST_BikeName);
		
		varText_BikeName = new JLabel("The Dirty Wheeler");
		varText_BikeName.setVerticalAlignment(SwingConstants.TOP);
		varText_BikeName.setForeground(new Color(74, 74, 181));
		varText_BikeName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bikeStatPanel.add(varText_BikeName);
		
		rdbtn_PayNow = new JRadioButton("Press To Pay Now");
		rdbtn_PayNow.setBackground(new Color(216, 218, 237));
		rdbtn_PayNow.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtn_PayNow.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bikeStatPanel.add(rdbtn_PayNow);
		
		txtEnterAdminUser = new JTextField();
		txtEnterAdminUser.setForeground(new Color(74, 74, 188));
		txtEnterAdminUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEnterAdminUser.setText("Admin User Name");
		bikeStatPanel.add(txtEnterAdminUser);
		txtEnterAdminUser.setColumns(10);
		
		JButton btn_Order = new JButton("Order");
		btn_Order.setFont(new Font("Tahoma", Font.PLAIN, 30));
		bikeStatPanel.add(btn_Order);
	
	
	btn_Order.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		String firstName = txtField_FirstName.getText();
		String lastName = txtField_LastName.getText();
		String postCode = txtField_PostCode.getText();
		String houseNumber = txtField_HouseNumber.getText();
		
		
		FinishOrder(firstName,lastName,postCode,houseNumber);
		
		 
		
	}

	private void FinishOrder(String firstName, String lastName, String postCode, String houseNumber) {
		final String DB_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team048";
		final String USER = "team048";
		final String PASS = "8780772c";
		
		try {
			int Confirmed = 0;
			int Fulfilled = 0;
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			Statement stmt = conn.createStatement();
			
			if(isEdit) {
				System.out.println("Updating Order");
				Random rand = new Random();
				Integer bikeIDRandom = rand.nextInt(1000000);
				String bikeID = bikeIDRandom + BikeName;
				String AdminName = "AdminUserName";
				if(rdbtn_PayNow.isSelected()) {
					Confirmed = 1;
				}
				String sqlCustomerOrder = "UPDATE "+USER+".CustomerOrders SET BikeID = '"+bikeID+"', Confirmed = '"+Confirmed+"', Fullfilled = '"+Fulfilled+"',"
						+ " AdminName = '"+AdminName+"', BikeName = '"+BikeName+"', BikeCost = '"+TotalCost+"', WheelID = '"+wheelID+"', HandleID = '"+ handleID+"',"
						+ " FrameID = '"+frameID+"' WHERE OrderID = '"+OrderID+"'";
				stmt.executeUpdate(sqlCustomerOrder);
				String popupText = "Your OrderID is: " + bikeID + " (Please Remember this)";
				JOptionPane.showMessageDialog(null, popupText);
				FrameHomeState mf = new FrameHomeState();
				mf.setVisible(true);
				setVisible(false);
			}
			else {
			
			String sqlquery = "select * from team048.Customers where Customers.CustomerName = '"+firstName+"' AND Customers.CustomerSurname = '"+lastName+"'"
					+ " AND Customers.CustomerPostCode = '"+postCode+"' AND Customers.CustomerHouseNumber = '"+houseNumber+"'";
			ResultSet databaseCheck = stmt.executeQuery(sqlquery);
			System.out.println(databaseCheck);
			if (!(databaseCheck.next())) {
				System.out.println("Inserting records into the table...");
				String sqlCreateUser = "INSERT INTO "+USER+".Customers (CustomerName,CustomerSurname,CustomerPostcode,CustomerHouseNumber) VALUES ('"+firstName+"', '"+lastName+"','"+postCode+"', '"+houseNumber+"')";
				stmt.executeUpdate(sqlCreateUser);
				System.out.println("Inserted records into the table...");
				
				// Finding created customer
				String sqlCustomerID = "select * from team048.Customers where Customers.CustomerName = '"+firstName+"' AND Customers.CustomerSurname = '"+lastName+"'"
						+ " AND Customers.CustomerPostCode = '"+postCode+"' AND Customers.CustomerHouseNumber = '"+houseNumber+"'";
				ResultSet newCustomer = stmt.executeQuery(sqlCustomerID);
				newCustomer.next();
				
				int CustomerID = newCustomer.getInt("CustomerID");
				Random rand = new Random();
				Integer bikeIDRandom = rand.nextInt(1000000);
				String bikeID = bikeIDRandom + BikeName;
				String AdminName = "AdminUserName";
				if (rdbtn_PayNow.isSelected()) {
					AdminName = txtEnterAdminUser.getText();
					Confirmed = 1;
				}
				String sqlCustomerOrder = "INSERT INTO "+USER+".CustomerOrders (BikeID,CustomerID,Confirmed,Fullfilled,AdminName,BikeName,BikeCost,WheelID,HandleID,FrameID)"
						+ " VALUES ('"+bikeID+"', '"+CustomerID+"','"+Confirmed+"', '"+Fulfilled+"', '"+AdminName+"','"+BikeName+"', '"+TotalCost+"','"+wheelID+"'"
							+ ",'"+handleID+"','"+frameID+"')";
				stmt.executeUpdate(sqlCustomerOrder);
				String popupText = "Your OrderID is: " + bikeID + " (Please Remember this)";
				JOptionPane.showMessageDialog(null, popupText);
				
			} 
			else {
				System.out.println("User Exists, adding order to current user.");
				// CREATE ORDER AND BIKE USING DATA
				Integer CustomerID = databaseCheck.getInt("CustomerID");
				Random rand = new Random();
				Integer bikeIDRandom = rand.nextInt(1000000);
				String bikeID = bikeIDRandom + BikeName;
				String AdminName = "AdminUserName";
				if (rdbtn_PayNow.isSelected()) {
					AdminName = txtEnterAdminUser.getText();
					Confirmed = 1;
				}
				String sqlCustomerOrder = "INSERT INTO "+USER+".CustomerOrders (BikeID,CustomerID,Confirmed,Fullfilled,AdminName,BikeName,BikeCost,WheelID,HandleID,FrameID)"
						+ " VALUES ('"+bikeID+"', '"+CustomerID+"','"+Confirmed+"', '"+Fulfilled+"', '"+AdminName+"','"+BikeName+"', '"+TotalCost+"','"+wheelID+"'"
						+ ",'"+handleID+"','"+frameID+"')";
				stmt.executeUpdate(sqlCustomerOrder);
				String popupText = "Your OrderID is: " + bikeID + " (Please Remember this)";
				JOptionPane.showMessageDialog(null, popupText);
			}
			
			FrameHomeState mf = new FrameHomeState();
			mf.setVisible(true);
			setVisible(false);	
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

});
}
	
	public void EditBikeProcessing() {
		isEdit = true;
		txtField_FirstName.setText("Order Editing. Details Not Required.");
		txtField_LastName.setText("Order Editing. Details Not Required.");
		txtField_PostCode.setText("Order Editing. Details Not Required.");
		txtField_HouseNumber.setText("Order Editing. Details Not Required.");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}}
