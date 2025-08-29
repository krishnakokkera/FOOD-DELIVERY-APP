<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.MODELS.Cart, com.tap.MODELS.CartItem" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Cart - FlavorHub</title>
    
    <!-- This links to your NEW and FINAL cart stylesheet -->
    <link rel="stylesheet" href="cart.css">
    
    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>

    <!-- This is the navbar -->
    <header>
        <div class="header-container">
            <div class="logo">FlavorHub</div>
            <nav>
                <a href="home">Home</a>
                <a href="orderHistory">Orders</a>
                <a href="login.jsp">Login</a>
                <a href="profile.jsp">Profile</a>
            </nav>
        </div>
    </header>

    <div class="cart-container">
        
        <!-- THIS IS THE FIX: The heading is now separate -->
        <div class="cart-title">
            <h1>Your Shopping Cart</h1>
        </div>

        <main class="cart-body">
            <%
                Cart cart = (Cart) session.getAttribute("cart"); 
                if (cart != null && !cart.getItems().isEmpty()) {
                    for (CartItem item : cart.getItems().values()) {
            %>
            <div class="cart-item">
                <div class="item-header">
                    <p class="item-name"><%= item.getName() %></p>
                    <p class="item-price">₹<%= String.format("%.2f", item.getPrice()) %></p>
                </div>
                <div class="item-footer">
                    <div class="quantity-selector">
                        <form action="cart" method="post" class="quantity-form">
                            <input type="hidden" name="menuid" value="<%= item.getId() %>">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
                            <button type="submit" class="quantity-btn">-</button>
                        </form>
                        <span class="quantity"><%= item.getQuantity() %></span>
                        <form action="cart" method="post" class="quantity-form">
                            <input type="hidden" name="menuid" value="<%= item.getId() %>">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
                            <button type="submit" class="quantity-btn">+</button>
                        </form>
                    </div>
                    <form action="cart" method="post">
                        <input type="hidden" name="menuid" value="<%= item.getId() %>">
                        <input type="hidden" name="action" value="remove">
                        <button type="submit" class="remove-btn">Remove</button>
                    </form>
                </div>
            </div>
            <%
                    }
                } else {
            %>
            <div class="empty-cart-message"><p>Your cart is empty.</p></div>
            <%
                }
            %>
        </main>
        
        <% if (cart != null && !cart.getItems().isEmpty()) { %>
        <footer class="cart-footer">
            <%
                CartItem anyItemInCart = cart.getItems().values().iterator().next();
                int restaurantId = anyItemInCart.getRestaurantId(); 
            %>
            
            <a href="menu?restaurentId=<%= restaurantId %>" class="add-more-btn">Add More Items</a>
            
            <div class="subtotal-section">
                <span class="subtotal-label">Subtotal</span>
                <span class="subtotal-amount">₹<%= String.format("%.2f", cart.getSubtotal()) %></span>
            </div>
            
            <form action="Checkout.jsp" method="get">
                 <button type="submit" class="checkout-btn">Proceed to Checkout</button>
            </form>
        </footer>
        <% } %>
    </div>
</body>
</html>