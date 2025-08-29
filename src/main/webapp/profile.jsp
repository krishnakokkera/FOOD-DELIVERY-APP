<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Profile - FlavorHub</title>
    <link rel="stylesheet" href="profile.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>

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
    
    <div class="profile-container">
        <h1>Your Profile</h1>
        
        <%-- We check if the user is in the session. If not, we can show a message. --%>
        <% if (session.getAttribute("user") != null) { %>
            <div class="profile-details">
                <div class="detail-item">
                    <span class="label">Full Name</span>
                    <span class="value">${sessionScope.user.name}</span>
                </div>
                <div class="detail-item">
                    <span class="label">Username</span>
                    <span class="value">${sessionScope.user.userName}</span>
                </div>
                <div class="detail-item">
                    <span class="label">Email</span>
                    <span class="value">${sessionScope.user.email}</span>
                </div>
                <div class="detail-item">
                    <span class="label">Phone Number</span>
                    <span class="value">${sessionScope.user.phoneNumber}</span>
                </div>
                <div class="detail-item">
                    <span class="label">Address</span>
                    <span class="value">${sessionScope.user.address}</span>
                </div>
            </div>
        <% } else { %>
            <p class="login-prompt">Please <a href="login.jsp">log in</a> to view your profile.</p>
        <% } %>
    </div>

</body>
</html>