/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productDAO;

import dao.DBConnection;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author nkmq21
 */
public class ProductDAO implements IProductDAO {

    private static final String INSERT_PRODUCT = "insert into Product(name, price, description, stock, import_date) values (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_PRODUCT = "select * from Product";
    private static final String SELECT_PRODUCT = "select * from Product where id=?";
    private static final String DELETE_PRODUCT = "delete from Product where id=?";
    private static final String UPDATE_PRODUCT = "update Product set name=?, price=?, description=?, stock=?, import_date=? where id=?";

    @Override
    public void insertProduct(Product pro) throws SQLException {
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(INSERT_PRODUCT)) {
            ps.setString(1, pro.getName());
            ps.setDouble(2, pro.getPrice());
            ps.setString(3, pro.getDescription());
            ps.setInt(4, pro.getStock());
            ps.setDate(5, new java.sql.Date(pro.getImport_date().getTime()));

            int rowInsert = ps.executeUpdate();
            if (rowInsert > 0) {
                System.out.println("A new product was inserted successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product selectProduct(int id) {
        Product pro = null;
        try (Connection con = DBConnection.getConnection()) {
            if (con != null) {
                PreparedStatement ps = con.prepareStatement(SELECT_PRODUCT);
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        pro = new Product(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getDouble("price"),
                                rs.getString("description"),
                                rs.getInt("stock"),
                                new java.util.Date(rs.getDate("import_date").getTime())
                        );
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }

    @Override
    public List<Product> selectAllProducts() {
        List<Product> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            if (con != null) {
                PreparedStatement ps = con.prepareStatement(SELECT_ALL_PRODUCT);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    String description = rs.getString("description");
                    int stock = rs.getInt("stock");
                    Date import_date = rs.getDate("import_date");
                    list.add(new Product(id, name, price, description, stock, new java.util.Date(import_date.getTime())));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        try (Connection con = DBConnection.getConnection()) {
            if (con != null) {
                PreparedStatement ps = con.prepareStatement(DELETE_PRODUCT);
                ps.setInt(1, id);
                int rowAffected = ps.executeUpdate();
                return rowAffected > 0;
            }
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product pro) throws SQLException {
        boolean rowAffected = false;
        try (Connection con = DBConnection.getConnection()) {
            if (con != null) {
                PreparedStatement ps = con.prepareStatement(UPDATE_PRODUCT);
                ps.setString(1, pro.getName());
                ps.setDouble(2, pro.getPrice());
                ps.setString(3, pro.getDescription());
                ps.setInt(4, pro.getStock());
                ps.setDate(5, new java.sql.Date(pro.getImport_date().getTime()));
                ps.setInt(6, pro.getId());
                int rowsUpdate = ps.executeUpdate();
                rowAffected = rowsUpdate > 0;
                if (rowAffected) {
                    System.out.println("product updated successfully");
                } else {
                    System.out.println("product updated failed");
                }
            }
            return rowAffected;
        }
    }

    public static void main(String[] args) throws SQLException {
        ProductDAO prodao = new ProductDAO();
//        prodao.insertProduct(new Product(0, "do choi con ngua", 3323.3, "toy for horse", 33, Date.valueOf("2025-02-13")));

//        Product pronigga = new Product(21, "do choi con cho", 3323.3, "toy for dog", 33, Date.valueOf("2025-02-13"));
        System.out.println(prodao.selectProduct(19));
    }

}
