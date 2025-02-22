/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import model.Product;
import productDAO.ProductDAO;

/**
 *
 * @author nkmq21
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/products"})
public class ProductServlet extends HttpServlet {

    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "insert":
                    insertForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    showDeleteForm(request, response);
                    break;
                default:
                    productList(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "insert":
                    insertProduct(request, response);
                    break;
                case "edit":
                    editProduct(request, response);
                    break;
                case "delete":
                    deleteProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void productList(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> products = productDAO.selectAllProducts();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/productList.jsp");
        dispatcher.forward(request, response);
    }

    private void insertForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        request.getRequestDispatcher("product/insertProduct.jsp").forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        try {
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            String description = request.getParameter("description");
            int stock = Integer.parseInt(request.getParameter("stock"));
            String importDateStr = request.getParameter("import_date");
            java.util.Date parseDate = null;
            java.sql.Date importDate = null;
            if (parseDate != null && importDate != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                parseDate = sdf.parse(importDateStr);
                importDate = new java.sql.Date(parseDate.getTime());
            }
            Product newProduct = new Product(name, price, description, stock, importDate);
            productDAO.insertProduct(newProduct);
            response.sendRedirect("products");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product existingProduct = productDAO.selectProduct(id);
        RequestDispatcher rd = request.getRequestDispatcher("product/editProduct.jsp");
        request.setAttribute("product", existingProduct);
        rd.forward(request, response);
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            String description = request.getParameter("description");
            int stock = Integer.parseInt(request.getParameter("stock"));
            String importDateStr = request.getParameter("import_date");
            java.sql.Date importDate = null;
            if (importDateStr != null && !importDateStr.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date parsedDate = sdf.parse(importDateStr);
                importDate = new java.sql.Date(parsedDate.getTime());
            }
            Product newProduct = new Product(id, name, price, description, stock, importDate);
            productDAO.updateProduct(newProduct);
            response.sendRedirect("products");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product existingProduct = productDAO.selectProduct(id);
        request.setAttribute("user", existingProduct);
        RequestDispatcher rd = request.getRequestDispatcher("product/deleteProduct.jsp");
        rd.forward(request, response);
    }
    
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.deleteProduct(id);
        response.sendRedirect("products");
    }
}
