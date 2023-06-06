package com.techpalle.model;

public class Library 
{
	private int bid;
	private String bname;
	private String publisher;
	private String pages;
	
	public int getBid() 
	{
		return bid;
	}
	public void setBid(int bid) 
	{
		this.bid = bid;
	}
	public String getBname() 
	{
		return bname;
	}
	public void setBname(String bname) 
	{
		this.bname = bname;
	}
	public String getPublisher() 
	{
		return publisher;
	}
	public void setPublisher(String publisher) 
	{
		this.publisher = publisher;
	}
	public String getPages() 
	{
		return pages;
	}
	public void setPages(String pages) 
	{
		this.pages = pages;
	}
	
	public Library() 
	{
		super();
	}
	
	public Library(String bname, String publisher, String pages) 
	{
		super();
		this.bname = bname;
		this.publisher = publisher;
		this.pages = pages;
	}
	
	public Library(int bid, String bname, String publisher, String pages) 
	{
		super();
		this.bid = bid;
		this.bname = bname;
		this.publisher = publisher;
		this.pages = pages;
	}
}
