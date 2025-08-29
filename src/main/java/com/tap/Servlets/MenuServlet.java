package com.tap.Servlets;

import java.io.IOException;
import java.util.List;

import com.tap.DAO.imples.MenuImpl;
import com.tap.MODELS.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/menu")
public class MenuServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	int  restaurentId = Integer.parseInt(req.getParameter("restaurentId"));
	
	
     MenuImpl impl = new MenuImpl();
      List<Menu> allmenu=impl.getAllMenuwithRestaurentid(restaurentId);
      for(Menu menu:allmenu)
      {
    	 System.out.println(menu);
      }
      req.setAttribute("allmenu", allmenu);
      
      HttpSession session = req.getSession();
      session.setAttribute("allmenu",allmenu);
      session.setAttribute("restaurentId",restaurentId);
      RequestDispatcher rd = req.getRequestDispatcher("Menu.jsp");
      rd.forward(req,resp);
	
      
      
      
	}

}
