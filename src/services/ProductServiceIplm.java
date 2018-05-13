package services;

import models.ProductSalesReportItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceIplm implements ProductService {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private static final String DB_URL = "jdbc:mysql://localhost:3306/classicmodels";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    private static final String SQL_GET_SALES_REPORT = "SELECT\n"
            + "  pl.productLine,\n"
            + "  p.productVendor,\n"
            + "  p.productCode,\n"
            + "  p.productName,\n"
            + "  od.quantityOrdered,\n"
            + "  od.priceEach,\n"
            + "  o.status,\n"
            + "  c.city\n"
            + "FROM products p\n"
            + "  INNER JOIN productlines pl ON p.productLine = pl.productLine\n"
            + "  INNER JOIN orderdetails od ON p.productCode = od.productCode\n"
            + "  INNER JOIN orders o ON od.orderNumber = o.orderNumber\n"
            + "  INNER JOIN customers c ON o.customerNumber = c.customerNumber\n"
            + "ORDER BY p.productLine, p.productVendor, p.productCode, od.quantityOrdered DESC, o.status, c.city;";

    @Override
    public List<ProductSalesReportItem> getSalesReport() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        String sql = SQL_GET_SALES_REPORT;
        Statement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery(sql);
        List<ProductSalesReportItem> products = new ArrayList<>();
        while (rs.next()){
            ProductSalesReportItem reportItem = new ProductSalesReportItem ();
            reportItem.setGetProductLine(rs.getString("productLine"));
            reportItem.setProductVendor(rs.getString("productVendor"));
            reportItem.setProductCode(rs.getString("productCode"));
            reportItem.setProductName(rs.getString("productName"));
            reportItem.setQuantityOrdered(rs.getInt("quantityOrdered"));
            reportItem.setPriceEach(rs.getDouble("priceEach"));
            reportItem.setOrderStatus(rs.getString("status"));
            reportItem.setOrderFromCity(rs.getString("city"));

            products.add(reportItem);
        }
        rs.close();
        statement.cancel();
        conn.close();
        return products;
    }
}
