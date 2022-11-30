package com2008_project.GUI;


import com2008_project.Database.*;
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
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrameDatabaseManager extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameDatabaseManager frame = new FrameDatabaseManager();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//initialize
	JButton btn_Return ;
	private Window frame;

	/**
	 * Create the frame.
	 */
	public FrameDatabaseManager() {
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
		
		JLabel ST_PageName = new JLabel("Database Manager");
		ST_PageName.setHorizontalAlignment(SwingConstants.CENTER);
		ST_PageName.setFont(new Font("Tahoma", Font.PLAIN, 60));
		headerPanel.add(ST_PageName, BorderLayout.CENTER);
		
		JButton btn_Return = new JButton("Return");
		btn_Return.setFont(new Font("Tahoma", Font.PLAIN, 30));
		headerPanel.add(btn_Return, BorderLayout.EAST);
		

		
		
		
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
		bodyPanel.setBackground(new Color(226, 226, 226));
		contentPane.add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel databasePanel = new JPanel();
		databasePanel.setBorder(new EmptyBorder(10, 20, 10, 20));
		bodyPanel.add(databasePanel, BorderLayout.CENTER);
		databasePanel.setLayout(new BorderLayout(0, 0));
		
		JPanel selectPanel = new JPanel();
		selectPanel.setBorder(new EmptyBorder(0, 100, 10, 100));
		databasePanel.add(selectPanel, BorderLayout.NORTH);
		selectPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel ST_SelectDatabase = new JLabel("Select Database To View/Edit:");
		ST_SelectDatabase.setFont(new Font("Tahoma", Font.PLAIN, 25));
		selectPanel.add(ST_SelectDatabase);
		
		JComboBox cb_SelectDatabase = new JComboBox();
		selectPanel.add(cb_SelectDatabase);
		
		table = new JTable();
		databasePanel.add(table, BorderLayout.CENTER);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		FrameAdminOptions ao = new FrameAdminOptions();
		ao.setVisible(true);
		 frame = null;
		frame.dispose();
	}

}
