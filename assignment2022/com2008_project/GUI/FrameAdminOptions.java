
package com2008_project.GUI;


import com2008_project.Database.*;
import com2008_project.BusinessLogic.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
import java.awt.Window;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class FrameAdminOptions extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtField_SerialNumber;
	private JTextField txtField_Style;
	private JTextField txtField_Forks;
	private JTextField txtField_Brand;
	private JTextField txtField_Cost;
	private JTextField txtField_DiameterSize;
	private JTextField txtField_Gears;
	private JTextField txtField_Quantity;
	private JTextField txtField_Name;
	JComboBox cb_RimDisk;
	JComboBox cb_ProductType;
	JRadioButton rdbtn_Forks;
	JRadioButton rdbtn_Stocks;
	JRadioButton rdbtn_Gears;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAdminOptions frame = new FrameAdminOptions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//initialize

	JButton btn_SignOut;
	JButton btn_ManageDatabases;
	JButton btn_Return;
	/**
	 * Create the frame.
	 */
	public FrameAdminOptions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel HeaderPanel = new JPanel();
		HeaderPanel.setForeground(Color.BLACK);
		HeaderPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		HeaderPanel.setBackground(new Color(74, 74, 181));
		contentPane.add(HeaderPanel, BorderLayout.NORTH);
		HeaderPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel ST_PageTitle = new JLabel("Admin Options");
		ST_PageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		ST_PageTitle.setFont(new Font("Tahoma", Font.PLAIN, 60));
		HeaderPanel.add(ST_PageTitle, BorderLayout.CENTER);
		
		JButton btn_SignOut = new JButton("Sign Out");
		btn_SignOut.setFont(new Font("Tahoma", Font.PLAIN, 30));
		HeaderPanel.add(btn_SignOut, BorderLayout.EAST);
		btn_SignOut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				FrameAdminLogin mf = new FrameAdminLogin();
				mf.setVisible(true);
				setVisible(false);
			}
		});
		
		JPanel BodyPanel = new JPanel();
		BodyPanel.setBorder(new EmptyBorder(10, 20, 0, 20));
		BodyPanel.setBackground(new Color(226, 226, 226));
		contentPane.add(BodyPanel);
		BodyPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
		ButtonPanel.setBackground(new Color(225, 225, 225));
		BodyPanel.add(ButtonPanel, BorderLayout.SOUTH);
		ButtonPanel.setLayout(new GridLayout(0, 2, 50, 0));
		
		JButton btn_AddProduct = new JButton("Add Product To Database");
		btn_AddProduct.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ButtonPanel.add(btn_AddProduct);
		btn_AddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Name = txtField_Name.getText();
				String ProductType = (String) cb_ProductType.getSelectedItem();
				String BrakeType = (String) cb_RimDisk.getSelectedItem();
				String SerialNumber = txtField_SerialNumber.getText();
				String Style = txtField_Style.getText();
				Integer Stocks = 0;
				Integer Gears = 0;
				Integer Forks = 0;
				boolean BoolStocks = rdbtn_Stocks.isSelected();
				if(BoolStocks) {
					Stocks = 1;
				}
				else {
					Stocks = 0;
				}
				boolean BoolForks = rdbtn_Forks.isSelected();
				if(BoolForks) {
					Forks = 1;
				}
				else {
					Forks = 0;
				}
				String Brand = (String) txtField_Brand.getText();
				Double Cost = Double.parseDouble(txtField_Cost.getText());
				Double Size = Double.parseDouble(txtField_DiameterSize.getText());
				boolean BoolGears = rdbtn_Gears.isSelected();
				if(BoolGears) {
					Gears = 1;
				}
				else {
					Gears = 0;
				}
				Integer Quantity = Integer.parseInt(txtField_Quantity.getText());
				
				final String DB_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team048";
				final String USER = "team048";
				final String PASS = "8780772c";
				try {
					Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
					Statement stmt = conn.createStatement();
					
					if(ProductType == "Wheel") {
						String sqlQuery = "SELECT * FROM team048.Wheels WHERE WheelsID = '"+SerialNumber+"' AND WheelsBrand = '"+Brand+"'";
						ResultSet rs = stmt.executeQuery(sqlQuery);
						
						if(!(rs.next())) {
							String sqlInsertQuerty = "INSERT INTO team048.Wheels (WheelsName,WheelsID,WheelsStyle,WheelsDia,WheelsBrand,WheelsCost,WheelsQuantity,WheelsBrakes) "
									+ "VALUES ('"+Name+"','"+SerialNumber+"','"+Style+"','"+Size+"','"+Brand+"','"+Cost+"','"+Quantity+"','"+BrakeType+"')";
							stmt.executeUpdate(sqlInsertQuerty);
						}
						else {
							Integer CurrentQuantity = rs.getInt("WheelsQuantity");
							Quantity = Quantity + CurrentQuantity;
							String sqlUpdateQuery = "UPDATE team048.Wheels SET WheelsQuantity = '"+Quantity+"' WHERE WheelsID = '"+SerialNumber+"' AND WheelsBrand = '"+Brand+"'";
							stmt.executeUpdate(sqlUpdateQuery);
						}
						
					}
					
					else if(ProductType == "Frame") {
						String sqlQuery = "SELECT * FROM team048.Frames WHERE FrameID = '"+SerialNumber+"' AND FrameBrand = '"+Brand+"'";
						ResultSet rs = stmt.executeQuery(sqlQuery);
						
						if(!(rs.next())) {
							String sqlInsertQuerty = "INSERT INTO team048.Frames (FrameName,FrameID,FrameBrand,FrameShock,FrameSize,FrameCost,FrameQuantity,FrameFork,FramesGears) "
									+ "VALUES ('"+Name+"','"+SerialNumber+"','"+Brand+"','"+Stocks+"','"+Size+"','"+Cost+"','"+Quantity+"','"+Forks+"','"+Gears+"')";
							stmt.executeUpdate(sqlInsertQuerty);
						}
						else {
							Integer CurrentQuantity = rs.getInt("FrameQuantity");
							Quantity = Quantity + CurrentQuantity;
							String sqlUpdateQuery = "UPDATE team048.Frames SET FrameQuantity = '"+Quantity+"' WHERE FrameID = '"+SerialNumber+"' AND FrameBrand = '"+Brand+"'";
							stmt.executeUpdate(sqlUpdateQuery);
						}
					}
					
					else {
						String sqlQuery = "SELECT * FROM team048.HandleBar WHERE HandleID = '"+SerialNumber+"' AND HandleBrand = '"+Brand+"'";
						ResultSet rs = stmt.executeQuery(sqlQuery);
						
						if(!(rs.next())) {
							String sqlInsertQuerty = "INSERT INTO team048.HandleBar (HandleName,HandleID,HandleBrand,HandleStyle,HandleCost,HandleQuantity) "
									+ "VALUES ('"+Name+"','"+SerialNumber+"','"+Brand+"','"+Style+"','"+Cost+"','"+Quantity+"')";
							stmt.executeUpdate(sqlInsertQuerty);
						}
						else {
							Integer CurrentQuantity = rs.getInt("HandleQuantity");
							Quantity = Quantity + CurrentQuantity;
							String sqlUpdateQuery = "UPDATE team048.HandleBar SET HandleQuantity = '"+Quantity+"' WHERE HandleID = '"+SerialNumber+"' AND HandleBrand = '"+Brand+"'";
							stmt.executeUpdate(sqlUpdateQuery);
						}
					}
				}
				catch (SQLException ea) {
					ea.printStackTrace();
				}
				
			}
		});

		
		
		
		JButton btn_FulfillOrder = new JButton("Fulfill Order");
		btn_FulfillOrder.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ButtonPanel.add(btn_FulfillOrder);
		btn_FulfillOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameDatabaseManager mf = new FrameDatabaseManager();
				mf.setVisible(true);
				setVisible(false);				
			}
		});
		
		
		
		JPanel addProductPanel = new JPanel();
		addProductPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		BodyPanel.add(addProductPanel, BorderLayout.CENTER);
		addProductPanel.setLayout(new GridLayout(0, 2, 10, 0));
		
		JPanel leftPanel = new JPanel();
		addProductPanel.add(leftPanel);
		leftPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel ST_ProductType = new JLabel("ProductType:");
		ST_ProductType.setFont(new Font("Tahoma", Font.PLAIN, 25));
		leftPanel.add(ST_ProductType);
		
		String[]ProductArray = {"Wheel","Frame","HandleBar"};
		cb_ProductType = new JComboBox(ProductArray);
		cb_ProductType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		leftPanel.add(cb_ProductType);
		
		JLabel ST_SerialNumber = new JLabel("Serial Number:");
		ST_SerialNumber.setFont(new Font("Tahoma", Font.PLAIN, 25));
		leftPanel.add(ST_SerialNumber);
		
		txtField_SerialNumber = new JTextField();
		txtField_SerialNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		leftPanel.add(txtField_SerialNumber);
		txtField_SerialNumber.setColumns(10);
		
		JLabel ST_Style = new JLabel("Style:");
		ST_Style.setFont(new Font("Tahoma", Font.PLAIN, 25));
		leftPanel.add(ST_Style);
		
		txtField_Style = new JTextField();
		txtField_Style.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtField_Style.setColumns(10);
		leftPanel.add(txtField_Style);
		
		JLabel ST_RimDisk = new JLabel("Rim/Disk Brakes (Wheel Only):");
		ST_RimDisk.setFont(new Font("Tahoma", Font.PLAIN, 25));
		leftPanel.add(ST_RimDisk);
		
		String[] BrakesArray = {"Rim","Disk","None"};
		cb_RimDisk = new JComboBox(BrakesArray);
		cb_RimDisk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		leftPanel.add(cb_RimDisk);
		
		rdbtn_Forks = new JRadioButton("Forks (Frame Only):");
		rdbtn_Forks.setFont(new Font("Tahoma", Font.PLAIN, 25));
		leftPanel.add(rdbtn_Forks);
		
		rdbtn_Stocks = new JRadioButton("Stocks (Frame Only):");
		rdbtn_Stocks.setFont(new Font("Tahoma", Font.PLAIN, 25));
		leftPanel.add(rdbtn_Stocks);
		
		JPanel rightPanel = new JPanel();
		addProductPanel.add(rightPanel);
		rightPanel.setLayout(new GridLayout(0, 1, 0, 8));
		
		JLabel ST_Name = new JLabel("Name:");
		ST_Name.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_Name.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rightPanel.add(ST_Name);
		
		txtField_Name = new JTextField();
		txtField_Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtField_Name.setColumns(10);
		rightPanel.add(txtField_Name);
		
		JLabel ST_Brand = new JLabel("Brand:");
		ST_Brand.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_Brand.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rightPanel.add(ST_Brand);
		
		txtField_Brand = new JTextField();
		txtField_Brand.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtField_Brand.setColumns(10);
		rightPanel.add(txtField_Brand);
		
		JLabel ST_Cost = new JLabel("Cost:");
		ST_Cost.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_Cost.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rightPanel.add(ST_Cost);
		
		txtField_Cost = new JTextField();
		txtField_Cost.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtField_Cost.setColumns(10);
		rightPanel.add(txtField_Cost);
		
		JLabel ST_DiameterSize = new JLabel("Diameter/Size:");
		ST_DiameterSize.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_DiameterSize.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rightPanel.add(ST_DiameterSize);
		
		txtField_DiameterSize = new JTextField();
		txtField_DiameterSize.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtField_DiameterSize.setColumns(10);
		rightPanel.add(txtField_DiameterSize);
		
		rdbtn_Gears = new JRadioButton("Gears (Frame Only):");
		rdbtn_Gears.setFont(new Font("Tahoma", Font.PLAIN, 25));
		leftPanel.add(rdbtn_Gears);
		
		JLabel ST_Quantity = new JLabel("Quantity:");
		ST_Quantity.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_Quantity.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rightPanel.add(ST_Quantity);
		
		txtField_Quantity = new JTextField();
		txtField_Quantity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtField_Quantity.setColumns(10);
		rightPanel.add(txtField_Quantity);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
