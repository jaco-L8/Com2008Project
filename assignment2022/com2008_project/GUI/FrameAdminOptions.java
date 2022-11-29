package com2008.assignment2022;

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
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
				Window frame = null;
				frame.dispose();
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
		
		JButton btn_ManageDatabases = new JButton("Manage Databases");
		btn_ManageDatabases.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ButtonPanel.add(btn_ManageDatabases);
		btn_ManageDatabases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameDatabaseManager dm = new FrameDatabaseManager();
				dm.setVisible(true);
				Window frame = null;
				frame.dispose();
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
		
		JComboBox cb_Style = new JComboBox();
		cb_Style.setFont(new Font("Tahoma", Font.PLAIN, 20));
		leftPanel.add(cb_Style);
		
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
		
		JLabel ST_Forks = new JLabel("Forks (Frame Only):");
		ST_Forks.setFont(new Font("Tahoma", Font.PLAIN, 25));
		leftPanel.add(ST_Forks);
		
		txtField_Forks = new JTextField();
		txtField_Forks.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtField_Forks.setColumns(10);
		leftPanel.add(txtField_Forks);
		
		JLabel ST_RimDisk = new JLabel("Rim/Disk Brakes (Wheel Only):");
		ST_RimDisk.setFont(new Font("Tahoma", Font.PLAIN, 25));
		leftPanel.add(ST_RimDisk);
		
		JComboBox cb_RimDisk = new JComboBox();
		cb_RimDisk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		leftPanel.add(cb_RimDisk);
		
		JRadioButton rdbtn_Stocks = new JRadioButton("Stocks (Frame Only):");
		rdbtn_Stocks.setFont(new Font("Tahoma", Font.PLAIN, 25));
		leftPanel.add(rdbtn_Stocks);
		
		JPanel rightPanel = new JPanel();
		addProductPanel.add(rightPanel);
		rightPanel.setLayout(new GridLayout(0, 1, 0, 8));
		
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
		
		JLabel ST_Gears = new JLabel("Gears (Frame Only):");
		ST_Gears.setVerticalAlignment(SwingConstants.BOTTOM);
		ST_Gears.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rightPanel.add(ST_Gears);
		
		txtField_Gears = new JTextField();
		txtField_Gears.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtField_Gears.setColumns(10);
		rightPanel.add(txtField_Gears);
		
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
