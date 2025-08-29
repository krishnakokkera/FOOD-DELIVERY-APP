package com.tap.Servlets;

import java.io.IOException;

import com.tap.DAO.imples.OrderImpl;
import com.tap.DAO.imples.OrderItemImpl;
import com.tap.MODELS.Cart;
import com.tap.MODELS.CartItem;
import com.tap.MODELS.Order;
import com.tap.MODELS.OrderItem;
import com.tap.MODELS.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/order")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        
        User user = (User) session.getAttribute("user");
        Cart cart = (Cart) session.getAttribute("cart");

        // --- FIX #1: Better Login and Cart Validation ---
        // If the user is not logged in, redirect to the login page.
        if (user == null) {
            resp.sendRedirect("login.jsp");
            return; 
        }
        // If the cart is empty or doesn't exist, redirect back to the cart page.
        if (cart == null || cart.getItems().isEmpty()) {
            resp.sendRedirect("Cart.jsp");
            return;
        }

        // --- FIX #2: Correct Parameter Names ---
        // These names now EXACTLY match the 'name' attributes in your Checkout.jsp form.
        String deliveryAddress = req.getParameter("deliveryAddress"); 
        String phoneNumber = req.getParameter("phoneNumber");
        String paymentMethod = req.getParameter("paymentMethod");
            
        // Create a new Order object
        Order order = new Order();
        order.setUserId(user.getUserId());
        
        // --- FIX #3: More Reliable Way to Get Restaurant ID ---
        // Get the restaurantId from the first item in the cart. This is much safer.
        if (!cart.getItems().isEmpty()) {
            CartItem firstItem = cart.getItems().values().iterator().next();
            order.setRestaurantId(firstItem.getRestaurantId());
        }
        
        order.setShippingAddress(deliveryAddress);
        order.setStatus("Pending"); // You can set an initial status
        order.setPhoneNumber(phoneNumber);
        order.setPaymentMode(paymentMethod);
            
        // Calculate the total amount from the cart items
        double totalAmount = 0.0;
        for (CartItem item : cart.getItems().values()) {
            totalAmount += item.getPrice() * item.getQuantity();
        }
        // Add delivery fee
        double deliveryFee = 40.0;
        totalAmount += deliveryFee;

        order.setTotalAmount(totalAmount);
        
        // Save the order to the database
        OrderImpl orderImpl = new OrderImpl();
        int orderId = orderImpl.AddOrder(order);
            
        if (orderId > 0) {
            // If the order was saved successfully, now save the individual order items
            OrderItemImpl orderItemImpl = new OrderItemImpl();
            for (CartItem item : cart.getItems().values()) {
                OrderItem orderItem = new OrderItem(orderId, item.getId(), item.getQuantity(), item.getPrice());
                orderItemImpl.AddOrder(orderItem); 
            }
            
            // Get the full order details that were just saved
            Order confirmedOrder = orderImpl.GetOrder(orderId);
            req.setAttribute("order", confirmedOrder);

            // Clear the cart from the session because the order is complete
            session.removeAttribute("cart");
            
            // Go to the confirmation page
            RequestDispatcher rd = req.getRequestDispatcher("ConfirmOrder.jsp"); // Case sensitive
            rd.forward(req, resp);
                
        } else {
            // This runs if the order failed to save in the database
            System.out.println("CheckoutServlet: Failed to save the order.");
            resp.sendRedirect("Cart.jsp?error=OrderSaveFailed"); // Case sensitive
        }
    } 
}