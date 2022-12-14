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



public class FrameHomeState extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameHomeState frame = new FrameHomeState();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	//initialize
	JButton btn_BuildBike;
	JButton ViewOrders;


	/**
	 * Create the frame.
	 */
	public FrameHomeState() {
		setTitle("Build'a'Bike Warehouse Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel HeaderPanel = new JPanel();
		HeaderPanel.setForeground(new Color(0, 0, 0));
		HeaderPanel.setBackground(new Color(74, 74, 181));
		HeaderPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(HeaderPanel, BorderLayout.NORTH);
		HeaderPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel ST_PageTitle = new JLabel("Build'a'Bike LMT");
		ST_PageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		ST_PageTitle.setFont(new Font("Tahoma", Font.PLAIN, 60));
		HeaderPanel.add(ST_PageTitle);
		
		JButton btn_SignIn = new JButton("Sign In");
		btn_SignIn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		HeaderPanel.add(btn_SignIn, BorderLayout.EAST);
		btn_SignIn.addActionListener(new ActionListener() {
			private Window frame;

			public void actionPerformed(ActionEvent e) {
				FrameAdminLogin cl = new FrameAdminLogin();
				cl.setVisible(true);
				setVisible(false);
			}
		});
		
		JPanel BodyPanel = new JPanel();
		BodyPanel.setBorder(new EmptyBorder(10, 20, 0, 20));
		BodyPanel.setBackground(new Color(226, 226, 226));
		contentPane.add(BodyPanel, BorderLayout.CENTER);
		BodyPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
		ButtonPanel.setBackground(new Color(225, 225, 225));
		BodyPanel.add(ButtonPanel, BorderLayout.SOUTH);
		ButtonPanel.setLayout(new GridLayout(0, 2, 50, 0));
		
		JButton btn_BuildBike = new JButton("Build Your Bike");
		btn_BuildBike.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
				FrameBuildBike bb = new FrameBuildBike();
				bb.setVisible(true);
				setVisible(false);
			}
		});
		btn_BuildBike.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ButtonPanel.add(btn_BuildBike);
		
		JButton btn_ViewOrders = new JButton("View Your Orders");
		btn_ViewOrders.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ButtonPanel.add(btn_ViewOrders);
		btn_ViewOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameCustomerLogin yo = new FrameCustomerLogin();
				yo.setVisible(true);
				setVisible(false);
			}
		});
		
		JPanel ContentPanel = new JPanel();
		ContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		BodyPanel.add(ContentPanel, BorderLayout.CENTER);
		
		JLabel ST_Title = new JLabel("Welcome To Build'A'Bike Warehouse!");
		ST_Title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		ST_Title.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel ST_CompanyDescription = new JLabel("A warehouse with every bike part you can imagen. Allowing you to create your own bike from scratch.");
		ST_CompanyDescription.setForeground(new Color(63, 63, 63));
		ST_CompanyDescription.setHorizontalAlignment(SwingConstants.CENTER);
		ST_CompanyDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel ST_Tip = new JLabel("To build your bike, press on 'Build Your Bike', to view your order(s) press 'View Your Orders'.");
		ST_Tip.setForeground(new Color(63, 63, 63));
		ST_Tip.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ST_Tip.setHorizontalAlignment(SwingConstants.CENTER);
		FlowLayout fl_ContentPanel = new FlowLayout(FlowLayout.CENTER, 1000, 5);
		ContentPanel.setLayout(fl_ContentPanel);
		ContentPanel.add(ST_Title);
		ContentPanel.add(ST_CompanyDescription);
		ContentPanel.add(ST_Tip);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
