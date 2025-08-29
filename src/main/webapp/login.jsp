<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - FlavorHub</title>
    
    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
    
    <!-- This MUST link to the CSS file with the shading colors. Let's call it "style.css" -->
    <link rel="stylesheet" href="login.css">
</head>
<body>

<%
   String str = (String) request.getAttribute("display");
   String finalstr = (String) request.getAttribute("finaldisplay");
   Integer countObj = (Integer) request.getAttribute("count");
   int count = (countObj != null) ? countObj : -1;
%>

<!-- We use the class "registration-card" to get the matching dark glass style -->
<div class="registration-card">
    <h2>Welcome Back!</h2>
    <p class="subtitle">Sign in to continue your journey</p>

    <%-- This is where your error messages will appear, correctly styled --%>
    <% if (count > 0 && str != null) { %>
        <p class="error-msg"><%= str %></p>
    <% } else if (count <= 0 && finalstr != null) { %>
        <p class="error-msg final"><%= finalstr %></p>
    <% } %>

    <form action="callUserLoginValidation" method="post">
        
        <label for="username">Username</label>
        <input type="text" id="username" name="username" placeholder="Enter your username" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Enter your password" required>

        <!-- The button will now have the vibrant pink color -->
        <button type="submit">Login</button>
    </form>

    <div class="login-link">
        <p>New here? <a href="registration.jsp">Create an account</a></p>
    </div>
</div>

</body>
</html>