<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.tap.MODELS.Restaurent" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FlavorHub - Food Delivery</title>
    
    <!-- This line is VERY important. It links to your CSS file. -->
    <link rel="stylesheet" href="restarent.css">
    
    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body>

    <header>
        <div class="header-container">
            <div class="logo">FlavorHub</div>
            <nav>
                <a href="home">Home</a>
                <a href="orderHistory">Orders</a>
                <a href="Cart.jsp">Cart</a>
                <a href="login.jsp">Login</a> <%-- Changed to .jsp --%>
                <a href="profile.jsp">Profile</a>
            </nav>
        </div>
    </header>

    <main>
        <div class="main-container">
            <h1>Featured Restaurants in Your Area</h1>
            <div class="restaurant-grid">
                <%
                    List<Restaurent> restaurents = (List<Restaurent>) request.getAttribute("allres");
                    if (restaurents != null) {
                        for (Restaurent res : restaurents) {
                %>
                <a href="menu?restaurentId=<%= res.getRestaurentId() %>" class="card-link">
                    <div class="restaurant-card">
                        <div class="card-image-container">
                            <img src="<%= res.getImagePath() %>" alt="<%= res.getName() %>">
                            <span class="active-tag">Active: YES</span>
                        </div>
                        <div class="card-content">
                            <h2><%= res.getName() %></h2>
                            <p class="location"><%= res.getAddress() %></p>
                            <p class="cuisine"><%= res.getCuisineType() %></p>
                            <div class="card-footer">
                                <span class="eta">ETA: with in <%= res.getDeliveryTime() %></span>
                                <span class="rating">★ <%= res.getRating() %></span>
                            </div>
                        </div>
                    </div>
                </a>
                <%
                        } // End for
                    } // End if
                %>
            </div>
        </div>
    </main>

</body>
</html>