package com.techpalle.model;

public class Admin 
{
	private int aid;
	private String aname;
	private String apass;
	
	public int getAid() 
	{
		return aid;
	}
	public void setAid(int aid) 
	{
		this.aid = aid;
	}
	public String getAname() 
	{
		return aname;
	}
	public void setAname(String aname) 
	{
		this.aname = aname;
	}
	public String getApass() 
	{
		return apass;
	}
	public void setApass(String apass) 
	{
		this.apass = apass;
	}
	
	public Admin() 
	{
		super();
	}
	
	public Admin(String aname, String apass) 
	{
		super();
		this.aname = aname;
		this.apass = apass;
	}
}
