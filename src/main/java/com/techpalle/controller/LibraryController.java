package com.techpalle.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techpalle.dao.AdminDAO;
import com.techpalle.dao.LibraryDAO;
import com.techpalle.model.Admin;
import com.techpalle.model.Library;

@Controller
public class LibraryController 
{
	ModelAndView mav = new ModelAndView();
	
	@RequestMapping(value = "library", params = "signin")
	public ModelAndView signinPage()
	{
		mav.setViewName("index.jsp");
		return mav;
	}
	
	@RequestMapping(value = "library", params = "signup")
	public ModelAndView signupPage()
	{
		mav.setViewName("signup.jsp");
		return mav;
	}
	
	@RequestMapping("adduser")
	public ModelAndView insertAdmin(HttpServletRequest request)
	{
		String name = request.getParameter("tbName");
		String pass = request.getParameter("tbPass");
		Admin admin = new Admin(name, pass);
		AdminDAO.insertAdmin(admin);
		mav = signinPage();
		return mav;
	}
	
	@RequestMapping("validate")
	public ModelAndView validateAdmin(HttpServletRequest request)
	{
		String name = request.getParameter("tbName");
		String pass = request.getParameter("tbPass");
		boolean result = AdminDAO.validateAdmin(name, pass);
		if (result)
		{
			mav = showAll();
		}
		else
		{
			mav = signinPage();
		}
		return mav;
	}
	
	@RequestMapping(value = "library", params = "showPage")
	public ModelAndView showAll()
	{
		ArrayList<Library> allBooks = LibraryDAO.showAll();
		mav.addObject("libr", allBooks);
		mav.setViewName("show.jsp");
		return mav;
	}
	
	@RequestMapping(value = "library", params = "insPage")
	public ModelAndView insertPage()
	{
		mav.setViewName("form.jsp");
		return mav;
	}
	
	@RequestMapping("insert")
	public ModelAndView insert(HttpServletRequest request)
	{
		String name = request.getParameter("tbName");
		String publ = request.getParameter("tbPublisher");
		String page = request.getParameter("tbPages");
		Library library = new Library(name, publ, page);
		LibraryDAO.insert(library);
		mav = showAll();
		return mav;
	}
	
	@RequestMapping("selectById")
	public ModelAndView selectById(HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Library libra = LibraryDAO.selectById(id);
		request.setAttribute("library", libra);
		mav.setViewName("form.jsp");
		return mav;
	}
	
	@RequestMapping("update")
	public ModelAndView update(HttpServletRequest request)
	{
		String name = request.getParameter("tbName");
		String publ = request.getParameter("tbPublisher");
		String page = request.getParameter("tbPages");
		Library library = new Library(name, publ, page);
		LibraryDAO.update(library);
		mav = showAll();
		return mav;
	}
	
	@RequestMapping("delete")
	public ModelAndView delete(HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		LibraryDAO.delete(id);
		mav = showAll();
		return mav;
	}
}
