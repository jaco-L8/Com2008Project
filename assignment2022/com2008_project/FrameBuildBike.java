
package com2008_project.GUI;

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
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JComboBox;

public class FrameBuildBike extends JFrame implements ItemListener, ActionListener {

	private JPanel contentPane;
	private JTextField txtfield_BikeName;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameBuildBike frame = new FrameBuildBike();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	String BikeName = "";
	String SelectFrame = "Scout";
	String SelectHandle = "Drop Bars";
	String SelectWheels = "Ry 20";
	String StrTotalCost = "N/A";
	String FramesType = "N/A";
	boolean isEdit = false;
	//initialize
	JButton btn_Return ;	
	
	
	
	//Frame name
			SQL FrameName = new SQL();
			String[] Frames = FrameName.Frame().toArray(new String[0]);
			JComboBox FrameBox;
			
			//Handle name
			SQL HandleBarName = new SQL();
			String[] Handles = HandleBarName.Handle().toArray(new String[0]);
			JComboBox HandleBox;
			
			//Wheels name
			SQL WheelsName = new SQL();
			String[] Wheels = WheelsName.Wheel().toArray(new String[0]);
			JComboBox WheelsBox;
			protected Window frame;
			
	//Variable texts
			JLabel varText_Price;
			JLabel varText_BikeType;
			
	public FrameBuildBike() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 226, 226));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		headerPanel.setBackground(new Color(100, 105, 155));
		contentPane.add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel ST_Title = new JLabel("Build Your Bike");
		ST_Title.setFont(new Font("Tahoma", Font.PLAIN, 60));
		ST_Title.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(ST_Title);
		
		JButton btn_Return = new JButton("Return");
		btn_Return.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		btn_Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameHomeState mf = new FrameHomeState();
				mf.setVisible(true);
				setVisible(false);
			}
		});
		
		
		headerPanel.add(btn_Return, BorderLayout.EAST);
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
		bodyPanel.setBackground(new Color(226, 226, 226));
		contentPane.add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(new BorderLayout(50, 0));
		
		JPanel bikePartsPanel = new JPanel();
		bikePartsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		bodyPanel.add(bikePartsPanel, BorderLayout.CENTER);
		bikePartsPanel.setLayout(new GridLayout(0, 1, 0, 20));
		
		//frames
		
		JLabel lblNewLabel_1 = new JLabel("Frame:");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		bikePartsPanel.add(lblNewLabel_1);
		
		FrameBox = new JComboBox(Frames);
		FrameBox.setSelectedItem(" ");
		FrameBox.addItemListener(this);
		bikePartsPanel.add(FrameBox);
		
		//Handle Bar
		
		lblNewLabel_2 = new JLabel("Handle Bars:");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		bikePartsPanel.add(lblNewLabel_2);
		
		
		HandleBox = new JComboBox(Handles);
		HandleBox.setSelectedItem(" ");
		HandleBox.addItemListener(this);
		bikePartsPanel.add(HandleBox);
		
		//wheels
		
		JLabel lblNewLabel_3 = new JLabel("Wheels:");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		bikePartsPanel.add(lblNewLabel_3);
		
		WheelsBox = new JComboBox(Wheels);
		WheelsBox.setSelectedItem(" ");
		WheelsBox.addItemListener(this);
		bikePartsPanel.add(WheelsBox);
		
		//left panel
		
		JPanel bikeStatPanel = new JPanel();
		bikeStatPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		bodyPanel.add(bikeStatPanel, BorderLayout.EAST);
		bikeStatPanel.setLayout(new GridLayout(0, 1, 0, 15));
		
		JPanel statTitlePanel = new JPanel();
		statTitlePanel.setBackground(new Color(100, 105, 155));
		bikeStatPanel.add(statTitlePanel);
		statTitlePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel ST_BikeStats = new JLabel("Bike Information:");
		statTitlePanel.add(ST_BikeStats);
		ST_BikeStats.setBackground(new Color(74, 74, 181));
		ST_BikeStats.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ST_BikeStats.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel ST_Price = new JLabel("Price Of Bike:");
		ST_Price.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_Price.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bikeStatPanel.add(ST_Price);
		
		varText_Price = new JLabel("N/A");
		varText_Price.setVerticalAlignment(SwingConstants.TOP);
		varText_Price.setForeground(new Color(74, 74, 181));
		varText_Price.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bikeStatPanel.add(varText_Price);
		
		JLabel ST_BikeType = new JLabel("Bike Type:");
		ST_BikeType.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_BikeType.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bikeStatPanel.add(ST_BikeType);
		
		varText_BikeType = new JLabel("Mountain Bike");
		varText_BikeType.setVerticalAlignment(SwingConstants.TOP);
		varText_BikeType.setForeground(new Color(74, 74, 181));
		varText_BikeType.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bikeStatPanel.add(varText_BikeType);
		
		JLabel ST_EnterBikeName = new JLabel("Enter Bike Name:");
		ST_EnterBikeName.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_EnterBikeName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bikeStatPanel.add(ST_EnterBikeName);
		
		txtfield_BikeName = new JTextField();
		txtfield_BikeName.setForeground(new Color(74, 74, 181));
		txtfield_BikeName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		bikeStatPanel.add(txtfield_BikeName);
		txtfield_BikeName.setColumns(10);
		
		JButton btn_Finalise = new JButton("Finalise Order");
		btn_Finalise.setFont(new Font("Tahoma", Font.PLAIN, 30));
		bikeStatPanel.add(btn_Finalise);
		
		btn_Finalise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BikeName = txtfield_BikeName.getText();
				FrameOrderProcessing mf = new FrameOrderProcessing();
			    mf.SetBikeDetails(SelectFrame,SelectHandle,SelectWheels,FramesType,StrTotalCost,BikeName,isEdit,editOrderID);
				mf.setVisible(true);
				setVisible(false);		
				
			}
		});

		
	}
	
	
	public void itemStateChanged(ItemEvent e) {
		final String DB_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team048";
		final String USER = "team048";
		final String PASS = "8780772c";
		
		SelectFrame = (String) FrameBox.getSelectedItem();
		
		SelectHandle = (String) HandleBox.getSelectedItem();
		
		SelectWheels = (String) WheelsBox.getSelectedItem();
		
		
		try {
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			Statement stmt = conn.createStatement();
			String sqlQueryWheels = "SELECT WheelsCost from team048.Wheels where WheelsName = '"+SelectWheels+"'";
			String sqlQueryHandles = "SELECT HandleCost from team048.HandleBar where HandleName = '"+SelectHandle+"'";
			String sqlQueryFrames = "SELECT FrameCost from team048.Frames where FrameName = '"+SelectFrame+"'";
			String sqlQueryBikeType = "SELECT WheelsStyle from team048.Wheels where WheelsName = '"+SelectWheels+"'";
			
		
			ResultSet wheelsRs = stmt.executeQuery(sqlQueryWheels);
			wheelsRs.next();
			double wheelsCost = wheelsRs.getDouble("wheelsCost");
			
			ResultSet handlesRs = stmt.executeQuery(sqlQueryHandles);
			handlesRs.next();
			double handlesCost = handlesRs.getDouble("handleCost");
			
			ResultSet framesRs = stmt.executeQuery(sqlQueryFrames);
			framesRs.next();
			double framesCost = framesRs.getDouble("frameCost");
			
			ResultSet wheelsTypeRs = stmt.executeQuery(sqlQueryBikeType);
			wheelsTypeRs.next();
			FramesType = wheelsTypeRs.getString("wheelsStyle");
			
			Double TotalCost = wheelsCost + handlesCost + framesCost + 10.00;
			StrTotalCost = String.format("%.2f",TotalCost);
			varText_Price.setText(StrTotalCost);
			varText_BikeType.setText(FramesType);
			super.update(getGraphics());
			
		}
		catch (SQLException ea) {
			ea.printStackTrace(); 
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	int editOrderID = 0;
	
	public void LoadBikeDetails(int OrderID) {
		System.out.println("Loading Bike Data for order: " + OrderID);
		final String DB_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team048";
		final String USER = "team048";
		final String PASS = "8780772c";
		isEdit = true;
		editOrderID = OrderID;
		
		try {
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			Statement Loadstmt = conn.createStatement();
			
			String sqlQuery = "SELECT * FROM team048.CustomerOrders WHERE OrderID = '"+OrderID+"'";
			
			ResultSet rs = Loadstmt.executeQuery(sqlQuery);
			System.out.println("Connecting...");
			rs.next();
			
			BikeName = rs.getString("BikeName");
			String FrameID = rs.getString("FrameID");	
			String HandleID = rs.getString("HandleID");
			String WheelID = rs.getString("WheelID");
			StrTotalCost = rs.getString("BikeCost");
			
			String sqlQueryWheels = "SELECT * FROM team048.Wheels WHERE WheelsID = '"+WheelID+"'";
			String sqlQueryHandle = "SELECT * FROM team048.HandleBar WHERE HandleID = '"+HandleID+"'";
			String sqlQueryFrame = "SELECT * FROM team048.Frames WHERE FrameID = '"+FrameID+"'";
			
			rs.next();
			ResultSet wheelsRs = Loadstmt.executeQuery(sqlQueryWheels);
			wheelsRs.next();
			String WheelsName = wheelsRs.getString("WheelsName");
			String WheelsType = wheelsRs.getString("WheelsStyle");
			
			ResultSet HandleRs = Loadstmt.executeQuery(sqlQueryHandle);
			HandleRs.next();
			String HandleName = HandleRs.getString("HandleName");
			
			ResultSet FrameRs = Loadstmt.executeQuery(sqlQueryFrame);
			FrameRs.next();
			String FrameName = FrameRs.getString("FrameName");
			
			SelectFrame = FrameName;
			SelectWheels = WheelsName;
			SelectHandle = HandleName;
			FramesType = WheelsType;
			
			varText_Price.setText(StrTotalCost);
			varText_BikeType.setText(FramesType);
			txtfield_BikeName.setText(BikeName);
			
			FrameBox.setSelectedItem(FrameName);
			HandleBox.setSelectedItem(HandleName);
			WheelsBox.setSelectedItem(WheelsName);
			
			System.out.println("Refreshing GUI...");
			super.update(getGraphics());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*try {
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			Statement stmt = conn.createStatement();
			
			String sqlQueryWheels = "SELECT * FROM team048.Wheels WHERE WheelsName = '"+BikeWheels+"'";
			
			ResultSet wheelsRs = stmt.executeQuery(sqlQueryWheels);
			wheelsRs.next();
			
		catch (SQLException e) {
			e.printStackTrace();
		} */
		
	}

}

