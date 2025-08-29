<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.tap.MODELS.Menu" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Restaurant Menu - FlavorHub</title>
    
    <!-- This links to your NEW menu stylesheet -->
    <link rel="stylesheet" href="menu.css" />
    
    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body>

    <!-- This is the navbar for consistency -->
    <header>
        <div class="header-container">
            <div class="logo">FlavorHub</div>
            <nav>
                <a href="home">Home</a>
                <a href="orderHistory">Orders</a>
                <a href="Cart.jsp">Cart</a>
                <a href="login.jsp">Login</a>
                <a href="profile.jsp">Profile</a>
            </nav>
        </div>
    </header>

    <main>
        <div class="main-container">
            <h1>Explore Our Menu</h1>
            <div class="menu-grid">
                
                <%
                    List<Menu> menues = (List<Menu>) request.getAttribute("allmenu");
                    if (menues != null) {
                        for (Menu menu : menues) {
                %>
                <div class="menu-card">
                    <!-- NEW: Image container for positioning the rating -->
                    <div class="menu-image-container">
                        <img src="<%=menu.getImagePath()%>" class="menu-image" alt="<%=menu.getItemName()%>">
                        <!-- NEW: The rating is now here -->
                        <span class="rating">★ <%=menu.getRating() %></span>
                    </div>
                    
                    <div class="menu-content">
                        <div class="menu-name"><%=menu.getItemName()%></div>
                        <p class="menu-description"><%=menu.getDescription()%></p>
                        
                        <!-- The price is now inside the main content area -->
                        <span class="price">₹<%=menu.getPrice() %></span>
                        
                        <form action="cart" method="post" class="add-to-cart-form">
                            <input type="hidden" name="menuid" value="<%=menu.getMenuId() %>">
                            <input type="hidden" name="quantity" value="1">
                            <input type="hidden" name="restaurentId" value="<%=menu.getRestaurentId() %>">
                            <input type="hidden" name="action" value="add">
                            <!-- The button is now wrapped in the form at the bottom -->
                            <button type="submit" class="add-btn">Add to Cart</button>
                        </form>
                    </div>
                </div>
                <%
                        } // End for
                    } // End if
                %>
            </div>
        </div>
    </main>

</body>
</html>