package com.tap.Servlets;

import java.io.IOException;
import com.tap.DAO.imples.Userimpl;
import com.tap.MODELS.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/callUserLoginValidation")
public class UserLoginValidation extends HttpServlet {

    private static final int MAX_ATTEMPTS = 3;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        Integer attemptsLeft = (Integer) session.getAttribute("attemptsLeft");
        if (attemptsLeft == null) {
            attemptsLeft = MAX_ATTEMPTS;
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Userimpl impl = new Userimpl();
        User user = impl.getUserPassWordWithName(username);

        if (user != null && password.equals(user.getPassword())) {
            // ✅ Successful login
            
            // =========================================================================
            // =========================  THIS IS THE FIX  ===========================
            // We are now using the key "user" so that all other servlets can find it.
            // =========================================================================
            session.setAttribute("user", user);
            
            // This is good practice to reset attempts on successful login
            session.removeAttribute("attemptsLeft"); 
            
            // Redirect to the home page
            resp.sendRedirect("home");
            
        } else {
            // ❌ Wrong login
            attemptsLeft--;
            session.setAttribute("attemptsLeft", attemptsLeft);

            if (attemptsLeft > 0) {
                req.setAttribute("display", "Invalid username or password! " + attemptsLeft + " attempts left.");
            } else {
                req.setAttribute("finaldisplay", "No attempts left. Please contact Admin.");
            }

            req.setAttribute("count", attemptsLeft);
            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.forward(req, resp);
        }
    }
}