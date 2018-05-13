package controller;

import models.ProductSalesReportItem;
import services.ProductService;
import services.ProductServiceIplm;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {

    private ProductService productService = new ProductServiceIplm();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "delete":
                break;
            case "edit":
                break;
            default:
                listProduct(request,response);
                break;
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response){
        try {
            List<ProductSalesReportItem> salesReport = this.productService.getSalesReport();
            request.setAttribute("salesReport", salesReport);
            RequestDispatcher rd = request.getRequestDispatcher("product/report.jsp");
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.getStackTrace();
        }catch (ClassNotFoundException e){
            e.getStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
