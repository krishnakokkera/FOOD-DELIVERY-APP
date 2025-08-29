package com.tap.Servlets;



import java.io.IOException;
import java.util.List;
import com.tap.DAO.imples.OrderImpl;
import com.tap.MODELS.Order;
import com.tap.MODELS.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/orderHistory")
public class OrderHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession session = req.getSession(false);

        // First, check if the user is logged in
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        // Get the logged-in user from the session
        User user = (User) session.getAttribute("user");
        
        // Create an instance of our DAO
        OrderImpl orderImpl = new OrderImpl();
        
        // Use the new method to get the user's order history
        List<Order> orderHistory = orderImpl.getOrdersByUserId(user.getUserId());
        
        // Set the list of orders as a request attribute so the JSP can access it
        req.setAttribute("orderHistory", orderHistory);
        
        // Forward to the JSP page to display the history
        RequestDispatcher rd = req.getRequestDispatcher("orderHistory.jsp");
        rd.forward(req, resp);
    }
}