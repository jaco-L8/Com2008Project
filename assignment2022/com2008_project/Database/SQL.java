package com2008_project.Database;

import java.sql.*;
import java.util.*;

public class SQL {
	
	//-----------------------Frame-----------------------
	public ArrayList<String> Frame() {
		
		List<String> FrameName=new ArrayList<>();
			
		try (Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team048","team048","8780772c")) {

			Statement stmt = null;
			try {
			stmt = con.createStatement();
			
			ResultSet res = stmt.executeQuery(
					"SELECT * from team048.Frames");
					 while (res.next()) {      
					   FrameName.add(res.getString("FrameName"));   
					}			
					 System.out.println(FrameName);
	}

			finally {
			if (stmt != null)
			stmt.close();
			}
			
		}
			catch (Exception ex) {
			ex.printStackTrace();
			}
		return (ArrayList<String>) (FrameName);


		}

	//-----------------------Handle-----------------------
	public ArrayList<String> Handle() {
		
	List<String> HandleBarName=new ArrayList<>();
		
	try (Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team048","team048","8780772c")) {

		Statement stmt = null;
		try {
		stmt = con.createStatement();
		
		ResultSet res = stmt.executeQuery(
				"SELECT * from team048.HandleBar");
				 while (res.next()) {      
				   HandleBarName.add(res.getString("HandleName"));   
				}			
				 System.out.println(HandleBarName);
}

		finally {
		if (stmt != null)
		stmt.close();
		}
		
	}
		catch (Exception ex) {
		ex.printStackTrace();
		}
	return (ArrayList<String>) (HandleBarName);


	}
	
	//-----------------------wheels-----------------------
	public ArrayList<String> Wheel() {
		
		List<String> WheelsName=new ArrayList<>();
			
		try (Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team048","team048","8780772c")) {

			Statement stmt = null;
			try {
			stmt = con.createStatement();
			
			ResultSet res = stmt.executeQuery(
					"SELECT * from team048.Wheels");
					 while (res.next()) {      
					   WheelsName.add(res.getString("WheelsName"));   
					}			
					 System.out.println(WheelsName);
	}

			finally {
			if (stmt != null)
			stmt.close();
			}
			
		}
			catch (Exception ex) {
			ex.printStackTrace();
			}
		return (ArrayList<String>) (WheelsName);


		}

	
}





//test lines 

/*int insert = stmt.executeUpdate(
"INSERT into team048.bike Values ('" +name + "','ID3',0,'ET13','SM77','BY01');");
}
catch (SQLException ex) {
ex.printStackTrace();
}*/