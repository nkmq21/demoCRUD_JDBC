/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orderDAO;

import dao.DBConnection;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import model.Order;

/**
 *
 * @author nkmq21
 */
public class OrderDAO implements IorderDAO{
    private static final String SELECT_ORDER_BY_ID = "select * from Orders where id =?";
    private static final String INSERT_ORDER = "insert into Orders (user_id, total_price, status) values (?, ?, ?)";
    private static final String INSERT_OrderDetails = "insert into OrderDetails (order_id, product_id, quantity, price) values (?, ?, ?, ?)";
    

    @Override
    public void insertOrder(Order orderObj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Order getOrderById(int id) {
        Order order = null;
        try(Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement("SELECT_ORDER_BY_ID")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (con != null) {
                order = Order.fromResultSet(rs);
            } else {
                System.out.println("User not found");
            }
            
        } catch(SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return order;
    }

    @Override
    public List<Order> selectAllOrders() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteOrder(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateOrder(Order orderObj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
