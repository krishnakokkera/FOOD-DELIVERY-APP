package com.tap.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.tap.DAO.imples.RestaurentImpl;
import com.tap.MODELS.Restaurent;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	RestaurentImpl resimpl = new RestaurentImpl();	
	
	List<Restaurent> allRes = resimpl.getAllRestaurent();
	
	PrintWriter out = resp.getWriter();
	
	for(Restaurent res:allRes)
	{
		out.println(res);
	}
	
	req.setAttribute("allres",allRes);
	RequestDispatcher rd = req.getRequestDispatcher("Restaurent.jsp");
	rd.forward(req,resp);
	
	
		
	}

}
