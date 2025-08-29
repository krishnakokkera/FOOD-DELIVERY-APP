package com.tap.Servlets;

import java.io.IOException;
import com.tap.DAO.imples.MenuImpl;
import com.tap.MODELS.Cart;
import com.tap.MODELS.CartItem;
import com.tap.MODELS.Menu;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        
        // Step 1: Get the cart from the session, or create a new one if it doesn't exist.
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        // --- FOR DEBUGGING: Let's see what the servlet is receiving ---
        System.out.println("CartServlet received action: " + req.getParameter("action"));
        System.out.println("CartServlet received menuid: " + req.getParameter("menuid"));

        // Step 2: Perform the action (add, update, remove)
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add":
                    addItemToCart(req, cart);
                    break;
                case "update":
                    updateItemInCart(req, cart);
                    break;
                case "remove":
                    removeItemFromCart(req, cart);
                    break;
            }
        }
        
        // Step 3: THIS IS THE MOST IMPORTANT STEP
        // After modifying the cart object, we MUST save it back into the session.
        session.setAttribute("cart", cart);

        // Step 4: Redirect the user to the cart page to see the result.
        resp.sendRedirect("Cart.jsp");
    }

    private void addItemToCart(HttpServletRequest req, Cart cart) {
        try {
            int menuId = Integer.parseInt(req.getParameter("menuid"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            
            MenuImpl menuImpl = new MenuImpl();
            Menu menuItem = menuImpl.GetMenu(menuId);
            
            if (menuItem != null) {
                CartItem item = new CartItem(
                    menuItem.getMenuId(),
                    menuItem.getItemName(),
                    menuItem.getRestaurentId(),
                    quantity,
                    menuItem.getPrice()
                );
                cart.addItemtoCart(item);
                System.out.println("Successfully added to cart: " + menuItem.getItemName());
            } else {
                System.out.println("ERROR: Menu item with ID " + menuId + " not found in database.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Could not parse menuid or quantity. Check your JSP form.");
            e.printStackTrace();
        }
    }

    private void updateItemInCart(HttpServletRequest req, Cart cart) {
        try {
            int menuId = Integer.parseInt(req.getParameter("menuid"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            cart.UpdateItemToCard(menuId, quantity);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void removeItemFromCart(HttpServletRequest req, Cart cart) {
        try {
            int menuId = Integer.parseInt(req.getParameter("menuid"));
            cart.removeItemTOCart(menuId); 
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    // Overriding service() is less common now, using doPost() is standard.
    // If you need to handle GET requests (e.g., just viewing the cart), you would add a doGet method.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // If a user just types /cart in the URL, we'll just show them the cart page.
        resp.sendRedirect("cart.jsp");
    }
}