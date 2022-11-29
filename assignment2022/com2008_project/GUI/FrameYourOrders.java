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
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.FlowLayout;

public class FrameYourOrders extends JFrame {

	private JPanel contentPane;
	private JTable table_Orders;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameYourOrders frame = new FrameYourOrders();
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
	public FrameYourOrders() {
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
		FrameHomeState mf = new FrameHomeState();
		mf.setVisible(true);
		Window frame = null;
		frame.dispose();
	
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
		bodyPanel.setBackground(new Color(226, 226, 226));
		contentPane.add(bodyPanel, BorderLayout.CENTER);
		bodyPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
		loginPanel.setBackground(SystemColor.menu);
		bodyPanel.add(loginPanel, BorderLayout.CENTER);
		loginPanel.setLayout(new BorderLayout(0, 0));
		
		table_Orders = new JTable();
		loginPanel.add(table_Orders, BorderLayout.CENTER);
		
		JLabel ST_YourOrders = new JLabel("Your Orders Table:");
		ST_YourOrders.setFont(new Font("Tahoma", Font.PLAIN, 30));
		loginPanel.add(ST_YourOrders, BorderLayout.NORTH);
	}

}
