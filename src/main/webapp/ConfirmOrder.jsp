<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmed - FlavorHub</title>

    <!-- This links to your NEW and FINAL stylesheet -->
    <link rel="stylesheet" href="confirmation.css">
    
    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap" rel="stylesheet">
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

    <div class="confirmation-container">
        
        <!-- The SVG is now styled by the CSS to be white and animated -->
        <svg class="success-icon" viewBox="0 0 52 52" xmlns="http://www.w3.org/2000/svg">
            <circle class="icon-circle" cx="26" cy="26" r="25" fill="none"/>
            <path class="icon-check" fill="none" d="M14.1 27.2l7.1 7.2 16.7-16.8"/>
        </svg>

        <h1>Thank You!</h1>
        <p class="subtitle">Your order has been placed successfully.</p>
        
        <a href="home" class="action-button">Continue Shopping</a>
        
    </div>

</body>
</html>