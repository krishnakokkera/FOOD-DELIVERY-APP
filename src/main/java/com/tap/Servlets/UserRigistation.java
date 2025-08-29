package com.tap.Servlets;

import java.io.IOException;
import com.tap.DAO.imples.Userimpl;
import com.tap.MODELS.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UserRegistarion")
public class UserRigistation extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {

        // Get parameters from form
        String Name = req.getParameter("name");
        String UserName = req.getParameter("username");
        String PassWord = req.getParameter("password");
        String Email = req.getParameter("email");
        String PhoneNumber = req.getParameter("phonenumber");
        String Address = req.getParameter("address");
        String Role = req.getParameter("role");

        // Create User object
        User user = new User(Name, UserName, PassWord, Email, PhoneNumber, Address, Role);

        // Insert user into DB
        Userimpl userImpl = new Userimpl();
        int res = userImpl.addUser(user);

        // ✅ After successful registration, redirect to login page
        if (res == 1) {
            resp.sendRedirect("login.jsp"); // go directly to login page
        } else {
            // If registration failed, show registration page again
            req.setAttribute("message", "Registration failed! Please try again.");
            req.getRequestDispatcher("registration.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.sendRedirect("registration.jsp");
    }
}
