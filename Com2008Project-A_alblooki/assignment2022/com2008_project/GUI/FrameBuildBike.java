package guiLayer;

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
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class FrameBuildBike extends JFrame implements ItemListener {

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
		FrameBox.addItemListener(this);
		bikePartsPanel.add(FrameBox);
		
		//Handle Bar
		
		lblNewLabel_2 = new JLabel("Handle Bars:");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		bikePartsPanel.add(lblNewLabel_2);
		
		String[] choices = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};
		
		HandleBox = new JComboBox(Handles);
		HandleBox.addItemListener(this);
		bikePartsPanel.add(HandleBox);
		
		//wheels
		
		JLabel lblNewLabel_3 = new JLabel("Wheels:");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		bikePartsPanel.add(lblNewLabel_3);
		
		WheelsBox = new JComboBox(Wheels);
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
	
	//Item Event Handler With temporary output
	
	public void itemStateChanged(ItemEvent e) {
		
		String SelectFrame = (String) FrameBox.getSelectedItem();
		//temp
		System.out.println("Frame: " + SelectFrame);
		
		String SelectHandle = (String) HandleBox.getSelectedItem();
		//temp
		System.out.println("Handle: " + SelectHandle);
		
		String SelectWheels = (String) WheelsBox.getSelectedItem();
		//temp
		System.out.println("Wheels: " + SelectWheels);
		
	}

}

