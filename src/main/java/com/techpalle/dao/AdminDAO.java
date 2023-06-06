package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.techpalle.model.Admin;

public class AdminDAO 
{
	private static Connection conn = null; 
	private static PreparedStatement pstm = null; 
	private static ResultSet rset = null;
	
	private static final String dbDriver = "com.mysql.cj.jdbc.Driver";
	private static final String dbUrl = "jdbc:mysql://localhost:3306/springmvc";
	private static final String dbUser = "root";
	private static final String dbPass = "Ashis_admin$5";
	
	private static final String insert = "INSERT INTO ladmin(aname, apass) VALUES(?, ?)";
	private static final String validate = "SELECT aname, apass FROM ladmin WHERE aname = ? AND apass = ?";
	
	public static Connection connectionStart()
	{
		try 
		{
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Connection connectionClosePreparedStatement()
	{
		try
		{
			if(pstm != null) { pstm.close(); }
			if(conn !=null) { conn.close(); }
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Connection connectionCloseResultSet()
	{
		try 
		{
			if(rset != null) { rset.close(); } 
			if(pstm != null) { pstm.close(); } 
			if(conn != null) { conn.close(); }
		}
		catch (SQLException e) 
		{ 
			e.printStackTrace(); 
		}
		return conn;
	}

	public static void insertAdmin(Admin admin)
	{
		try 
		{
			conn = connectionStart();
			pstm = conn.prepareStatement(insert);
			pstm.setString(1, admin.getAname());
			pstm.setString(2, admin.getApass());
			pstm.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			connectionClosePreparedStatement();
		}
	}
	
	public static boolean validateAdmin(String adminName, String adminPass)
	{
		boolean valid = false;
		try 
		{
			conn = connectionStart();
			pstm = conn.prepareStatement(validate);
			pstm.setString(1, adminName);
			pstm.setString(2, adminPass);
			rset = pstm.executeQuery();
			valid = rset.next();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			connectionCloseResultSet();
		}
		return valid;
	}
}
