<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.MODELS.User" %>
<%@ page import="com.tap.MODELS.Order" %>
<%@ page import="java.util.List" %>

<%
    // Ensure the user is logged in, same as before
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    // Get the order history list that the servlet passed to this page
    List<Order> orderHistory = (List<Order>) request.getAttribute("orderHistory");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order History - FlavorHub</title>
    
    <!-- We will create this new CSS file in the next step -->
    <link rel="stylesheet" href="orderHistory.css">
    
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>

    <header>
        <div class="header-container">
            <div class="logo">FlavorHub</div>
            <nav>
                <a href="home">Home</a>
                <a href="orderHistory" style="font-weight: bold;">Orders</a> <%-- Highlight current page --%>
                <a href="Cart.jsp">Cart</a>
                <a href="login.jsp">Login</a>
                <a href="profile.jsp">Profile</a>
            </nav>
        </div>
    </header>

    <div class="history-container">
        <div class="history-box">
            <h1 class="history-title">Your Order History</h1>
            
            <%-- Check if the order history is empty or not --%>
            <% if (orderHistory != null && !orderHistory.isEmpty()) { %>
            
                <div class="order-list">
                    
                    <%-- Loop through each order in the list --%>
                    <% for (Order order : orderHistory) { %>
                    
                        <div class="order-item">
                            <div class="order-header">
                                <div class="order-id">
                                    <span class="label">Order ID</span>
                                    <span class="value">#<%= order.getOrderId() %></span>
                                </div>
                                <div class="order-date">
                                    <span class="label">Date</span>
                                    <span class="value"><%= order.getOrderDate() %></span>
                                </div>
                            </div>
                            <div class="order-body">
                                <div class="order-status">
                                    <span class="label">Status</span>
                                    <span class="value status-<%= order.getStatus().toLowerCase() %>"><%= order.getStatus() %></span>
                                </div>
                                <div class="order-total">
                                    <span class="label">Total Amount</span>
                                    <span class="value">$<%= String.format("%.2f", order.getTotalAmount()) %></span>
                                </div>
                            </div>
                        </div>
                        
                    <% } %> <%-- End of the loop --%>
                    
                </div>
                
            <% } else { %>
            
                <%-- This message will show if the user has no orders --%>
                <div class="no-orders-message">
                    <p>You haven't placed any orders yet.</p>
                    <a href="home" class="start-shopping-btn">Start Shopping</a>
                </div>
                
            <% } %> <%-- End of the if-else block --%>
            
        </div>
    </div>

</body>
</html>