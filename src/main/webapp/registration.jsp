<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FlavorHub - User Registration</title>
    
    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
    
    <!-- This links to your new, improved stylesheet -->
    <link rel="stylesheet" href="registration.css">
</head>
<body>

<%
   String message = (String) request.getAttribute("message");
%>

<!-- This div is for the dark overlay, which improves readability -->
<div class="background-overlay"></div>

<div class="registration-card">
    <h2>Create an Account</h2>
    <p class="subtitle">Join FlavorHub today!</p>

    <% if (message != null) { %>
        <p class="error-message"><%= message %></p>
    <% } %>

    <form action="UserRegistration" method="post">
        
        <label for="name">Name</label>
        <input type="text" id="name" name="name" placeholder="Enter your full name" required>

        <label for="username">Username</label>
        <input type="text" id="username" name="username" placeholder="Choose a unique username" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Create a strong password" required>

        <label for="email">Email</label>
        <input type="email" id="email" name="email" placeholder="you@example.com" required>

        <label for="phonenumber">Phone Number</label>
        <input type="tel" id="phonenumber" name="phonenumber" placeholder="Enter your phone number" required>

        <label for="address">Address</label>
        <input type="text" id="address" name="address" placeholder="Your delivery address" required>

        <label for="role">Role</label>
        <input type="text" id="role" name="role" placeholder="e.g., Customer" required>

        <button type="submit">Register</button>
    </form>

    <div class="login-link">
        <p>Already have an account? <a href="login.jsp">Login Here</a></p>
    </div>
</div>

</body>
</html>