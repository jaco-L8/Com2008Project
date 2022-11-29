package com2008.assignment2022;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameBuildBike extends JFrame implements ActionListener{

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
	
	//initialize
	JButton btn_Return ;
	

	/**
	 * Create the frame.
	 */
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
				Window frame = null;
				frame.dispose();
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
		
		JLabel lblNewLabel_1 = new JLabel("Frame:");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		bikePartsPanel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		bikePartsPanel.add(comboBox);
		
		lblNewLabel_2 = new JLabel("Handle Bars:");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		bikePartsPanel.add(lblNewLabel_2);
		
		JComboBox comboBox_1 = new JComboBox();
		bikePartsPanel.add(comboBox_1);
		
		JLabel lblNewLabel_3 = new JLabel("Wheels:");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		bikePartsPanel.add(lblNewLabel_3);
		
		JComboBox comboBox_2 = new JComboBox();
		bikePartsPanel.add(comboBox_2);
		
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
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
