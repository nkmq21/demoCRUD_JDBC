/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.*;


/**
 *
 * @author nkmq21
 */
public class Order {
    private int id;
    private int userID;
    private double totalPrice;
    private String status;

    public Order() {
    }
    
    public Order(int id, int userID, double totalPrice, String status) {
        this.id = id;
        this.userID = userID;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", userID=" + userID + ", totalPrice=" + totalPrice + ", status=" + status + '}';
    }
    
    public static Order fromResultSet(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setUserID(rs.getInt("user_id"));
        order.setTotalPrice(rs.getDouble("total_price"));
        order.setStatus(rs.getString("status"));
        return order;
    }
    
}
