package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.techpalle.model.Library;

public class LibraryDAO 
{
	private static Connection conn = null; 
	private static PreparedStatement pstm = null; 
	private static Statement stmt = null;
	private static ResultSet rset = null;
	
	private static Library library = null;
	
	private static final String dbDriver = "com.mysql.cj.jdbc.Driver";
	private static final String dbUrl = "jdbc:mysql://localhost:3306/springmvc";
	private static final String dbUser = "root";
	private static final String dbPass = "Ashis_admin$5";
	
	private static final String showAll = "SELECT * FROM library";
	private static final String insert = "INSERT INTO library(bname, publisher, pages) VALUES(?, ?, ?)";
	private static final String selectById = "SELECT * FROM library WHERE bid = ?";
	private static final String update = "UPDATE library SET bname = ?, publisher = ?, pages = ? WHERE bid = ?";
	private static final String delete = "DELETE FROM library WHERE bid = ?";
	
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
			if(pstm != null) 
			{ 
				pstm.close(); 
			}
			if(conn !=null) 
			{ 
				conn.close(); 
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Connection connectionCloseStatement()
	{
		try
		{
			if(rset != null) 
			{ 
				rset.close(); 
			}
			if(stmt != null) 
			{ 
				stmt.close(); 
			}
			if(conn !=null) 
			{ 
				conn.close(); 
			}
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
			if(rset != null) 
			{ 
				rset.close(); 
			}
			if(pstm != null) 
			{ 
				pstm.close(); 
			}
			if(conn !=null) 
			{ 
				conn.close(); 
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	public static ArrayList<Library> showAll()
	{
		ArrayList<Library> list = new ArrayList<Library>();
		try 
		{
			conn = connectionStart();
			stmt = conn.createStatement();
			rset = stmt.executeQuery(showAll);
			while(rset.next())
			{
				int id = rset.getInt("bid");
				String name = rset.getString("bname");
				String publ = rset.getString("publisher");
				String page = rset.getString("pages");
				library = new Library(id, name, publ, page);
				list.add(library);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			connectionCloseStatement();
		}
		return list;
	}
	
	public static void insert(Library library)
	{
		try 
		{
			conn = connectionStart();
			pstm = conn.prepareStatement(insert);
			pstm.setString(1, library.getBname());
			pstm.setString(2, library.getPublisher());
			pstm.setString(3, library.getPages());
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
	
	public static Library selectById(int id)
	{
		try
		{
			conn = connectionStart();
			pstm = conn.prepareStatement(selectById);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();
			int bkid = rset.getInt("bid");
			String name = rset.getString("bname");
			String publ = rset.getString("publisher");
			String page = rset.getString("pages");
			library = new Library(bkid, name, publ, page);
		}
		catch (SQLException e) 
		{ 
			e.printStackTrace(); 
		}
		finally 
		{ 
			connectionCloseResultSet(); 
		}
		return library;
	}
	
	public static void update(Library library)
	{
		try
		{
			conn = connectionStart();
			pstm = conn.prepareStatement(update);
			pstm.setString(1, library.getBname());
			pstm.setString(2, library.getPublisher());
			pstm.setString(3, library.getPages());
			pstm.setInt(4, library.getBid());
			pstm.executeUpdate();
		}
		catch ( SQLException e) 
		{ 
			e.printStackTrace(); 
		}
		finally 
		{ 
			connectionClosePreparedStatement(); 
		}
	}
	
	public static void delete(int id)
	{
		try
		{
			conn = connectionStart();
			pstm = conn.prepareStatement(delete);
			pstm.setInt(1, id);
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
}
