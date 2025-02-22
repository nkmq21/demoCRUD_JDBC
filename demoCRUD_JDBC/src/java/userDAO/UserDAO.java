/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userDAO;

import dao.DBConnection;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author nkmq21
 */
public class UserDAO implements IUserDAO {

    private static final String LOGIN = "SELECT id from [Users] where name=? and password=?";
    private static final String LOGIN1 = "select id, name, role from [Users] where name=? and password=?";
    private static final String INSERT_USER = "insert into Users(name, email, country, role, status, password) values (?, ?, ?, ?, ?, ?)";
    private static final String INSERT_USER1 = "insert into Users(id, name, email, country, role, status, password) values (?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_USER_BY_ID = "select * from [Users] where id=?";
    private static final String UPDATE_USER = "update [Users] set name=?, email=?, country=?, role=?, status=?, password=? where id=?";
    private static final String SELECT_ALL_USER = "select * from [Users]";
    private static final String DELETE_BY_ID = "delete from [Users] where id=?";

    public boolean checkLogin(String username, String password) {
        try (Connection con = DBConnection.getConnection(); PreparedStatement ptm = con.prepareStatement(LOGIN)) {

            ptm.setString(1, username);
            ptm.setString(2, password);

            try (ResultSet rs = ptm.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static User checkLogin1(String userName, String password) {
        User us = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try (Connection con = DBConnection.getConnection()) {
            String sql = LOGIN1;
            ptm = con.prepareStatement(sql);
            ptm.setString(1, userName);
            ptm.setString(2, password);
            rs = ptm.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String role = rs.getString("role");
                us = new User(id, name, "", role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return us;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(INSERT_USER)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            ps.setString(4, user.getRole());
            ps.setBoolean(5, user.isStatus());
            ps.setString(6, user.getPassword());

            int rowInsert = ps.executeUpdate();
            if (rowInsert > 0) {
                System.out.println("A new user was inserted successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User selectUser(int id) {
        User us = null;
        try (Connection con = DBConnection.getConnection()) {
            if (con != null) {
                PreparedStatement ps = con.prepareStatement(SELECT_USER_BY_ID);
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        us = new User(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getString("country"),
                                rs.getString("role"),
                                rs.getBoolean("status"),
                                rs.getString("password")
                        );
                        System.out.println("User found: ");
                        System.out.println("ID: " + rs.getInt("id"));
                        System.out.println("Username: " + rs.getString("name"));
                        System.out.println("Email: " + rs.getString("email"));
                        System.out.println("Country: " + rs.getString("country"));
                        System.out.println("Status: " + rs.getBoolean("status"));
                        System.out.println("Password: " + rs.getString("password"));
                    } else {
                        System.out.println("User not found");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return us;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            if (con != null) {
                PreparedStatement ps = con.prepareStatement(SELECT_ALL_USER);
                System.out.println(ps);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String country = rs.getString("country");
                    users.add(new User(id, name, email, country));
                }

            }
        } catch (SQLException e) {
            e.getSQLState();
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        try (Connection con = DBConnection.getConnection()) {
            if (con != null) {
                PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE id = ?");
                ps.setInt(1, id);
                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;
            }
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated = false;
        try (Connection con = DBConnection.getConnection()) {
            if (con != null) {
                PreparedStatement ps = con.prepareStatement(UPDATE_USER);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getCountry());
                ps.setString(4, user.getRole());
                ps.setBoolean(5, user.isStatus());
                ps.setString(6, user.getPassword());
                ps.setInt(7, user.getId());

                int rowsUpdated = ps.executeUpdate();
                rowUpdated = rowsUpdated > 0;
                if (rowUpdated) {
                    System.out.println("User updated successfully");
                } else {
                    System.out.println("No user found with the given ID");
                }
            }
            return rowUpdated;
        }
    }

    public static void main(String[] args) throws SQLException {
        UserDAO dao = new UserDAO();
        User us = new User(1, "nigga", "nigga@gmail.com", "may beo", "chimto", true, "chimto123");
//        dao.insertUser(us);
        System.out.println(dao.updateUser(us));

    }

}
