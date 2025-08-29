<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.MODELS.Cart, com.tap.MODELS.CartItem" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout - FlavorHub</title>
    
    <!-- This links to your NEW and FINAL checkout stylesheet -->
    <link rel="stylesheet" href="checkout.css">
    
    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>

    <!-- This is the navbar for consistency -->
    <header>
        <div class="header-container">
            <div class="logo">FlavorHub</div>
            <nav>
                <a href="home">Home</a>
                <a href="orderHistory">Orders</a>
                <a href="cart">Cart</a>
                <a href="login.jsp">Login</a>
                <a href="profile.jsp">Profile</a>
            </nav>
        </div>
    </header>

    <div class="checkout-container">
        
        <form action="order" method="post" class="checkout-form">
            
            <!-- ====== LEFT COLUMN: DETAILS ======= -->
            <div class="details-column">
                <h2>Secure Checkout</h2>
                
                <!-- Delivery Address Section -->
                <div class="form-section">
                    <h4>1. Delivery Details</h4>
                    <div class="form-group">
                        <label for="address">Delivery Address</label>
                        <input type="text" id="address" name="deliveryAddress" placeholder="Enter your full address" required>
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone Number</label>
                        <input type="tel" id="phone" name="phoneNumber" placeholder="Enter your 10-digit phone number" required>
                    </div>
                </div>

                <!-- Payment Method Section -->
                <div class="form-section">
                    <h4>2. Payment Method</h4>
                    <select name="paymentMethod" class="payment-select">
                        <option value="COD" selected>Cash on Delivery</option>
                        <option value="Card">Pay with Card (Not available)</option>
                        <option value="UPI">Pay with UPI (Not available)</option>
                    </select>
                </div>
            </div>

            <!-- ===== RIGHT COLUMN: SUMMARY ======= -->
            <div class="summary-column">
                <h4>Order Summary</h4>
                <%
                    Cart cart = (Cart) session.getAttribute("cart");
                    double deliveryFee = 40.00;
                    double total = 0;
                    if (cart != null && !cart.getItems().isEmpty()) {
                        total = cart.getSubtotal() + deliveryFee;
                %>
                <div class="summary-items">
                    <% for (CartItem item : cart.getItems().values()) { %>
                        <div class="summary-item">
                            <span><%= item.getQuantity() %> x <%= item.getName() %></span>
                            <span>₹<%= String.format("%.2f", item.getPrice() * item.getQuantity()) %></span>
                        </div>
                    <% } %>
                </div>
                <div class="summary-totals">
                    <div class="total-line">
                        <span>Subtotal</span>
                        <span>₹<%= String.format("%.2f", cart.getSubtotal()) %></span>
                    </div>
                    <div class="total-line">
                        <span>Delivery Fee</span>
                        <span>₹<%= String.format("%.2f", deliveryFee) %></span>
                    </div>
                    <div class="total-line grand-total">
                        <span>Total Amount</span>
                        <span>₹<%= String.format("%.2f", total) %></span>
                    </div>
                </div>
                <% } else { %>
                    <p class="empty-cart-message">Your cart is empty.</p>
                <% } %>
            </div>

            <!-- Form Buttons (at the bottom, spanning both columns) -->
            <div class="form-buttons">
                <a href="Cart.jsp" class="back-btn">Back to Cart</a>
                <button type="submit" class="place-order-btn">Place Your Order</button>
            </div>
            
        </form>
    </div>

</body>
</html>