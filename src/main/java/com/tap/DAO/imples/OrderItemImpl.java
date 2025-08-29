package com.tap.DAO.imples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.OrderItemDAO;
import com.tap.DbConnection.DBConnection;
import com.tap.MODELS.OrderItem;

public class OrderItemImpl implements OrderItemDAO {
	

	 // SQL queries for the 'orderitem' table
     String INSERT= "INSERT INTO `orderitem` (`orderId`, `menuId`, `quantity`, `totalAmount`) VALUES (?, ?, ?, ?)";
     String SELECT= "SELECT * FROM `orderitem` WHERE `orderItemId` = ?";
     String SELECT_ALL = "SELECT * FROM `orderitem`";
     String UPDATE= "UPDATE `orderitem` SET `orderId` = ?, `menuId` = ?, `quantity` = ?, `totalAmount` = ? WHERE `orderItemId` = ?";
     String DELETE = "DELETE FROM `orderitem` WHERE `orderItemId` = ?";

    @Override
    public void AddOrder(OrderItem orderitem) {
        try (Connection con = DBConnection.getConnections();
             PreparedStatement pstmt = con.prepareStatement(INSERT);) {

           // pstmt.setInt(1, orderitem.getOrderItemId());
            pstmt.setInt(1, orderitem.getOrderId());
            pstmt.setInt(2, orderitem.getMenuId());
            pstmt.setInt(3, orderitem.getQuantity());
            pstmt.setDouble(4, orderitem.getTotalAmount());

            int res= pstmt.executeUpdate();
            System.out.print(res);
            
      

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderItem GetOrder(int id) {
        OrderItem o = null;
        try (Connection con = DBConnection.getConnections();
             PreparedStatement pstmt = con.prepareStatement(SELECT);) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int orderItemId = rs.getInt("orderItemId");
                int orderId = rs.getInt("orderId");
                int menuId = rs.getInt("menuId");
                int quantity = rs.getInt("quantity");
                double totalAmount = rs.getDouble("totalAmount");
                o = new OrderItem(orderItemId, orderId, menuId, quantity, totalAmount);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return o;
    }
    
    @Override
    public int Update(OrderItem orderitem) {
        int res = 0;
        try (Connection con = DBConnection.getConnections();
             PreparedStatement pstmt = con.prepareStatement(UPDATE);) {

            pstmt.setInt(1, orderitem.getOrderId());
            pstmt.setInt(2, orderitem.getMenuId());
            pstmt.setInt(3, orderitem.getQuantity());
            pstmt.setDouble(4, orderitem.getTotalAmount());
            pstmt.setInt(5, orderitem.getOrderItemId());

            res = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int Delete(int id) {
        int res = 0;
        try (Connection con = DBConnection.getConnections();
             PreparedStatement pstmt = con.prepareStatement(DELETE);) {

            pstmt.setInt(1, id);
            res = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<OrderItem> GetAll() {
    	OrderItem o=null;
        List<OrderItem> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnections();
             PreparedStatement pstmt = con.prepareStatement(SELECT_ALL);) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int orderItemId = rs.getInt("orderItemId");
                int orderId = rs.getInt("orderId");
                int menuId = rs.getInt("menuId");
                int quantity = rs.getInt("quantity");
                double totalAmount = rs.getDouble("totalAmount");
               
               o=new OrderItem(orderItemId, orderId, menuId, quantity, totalAmount);
           
            list.add(o);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}