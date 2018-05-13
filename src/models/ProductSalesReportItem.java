package models;

public class ProductSalesReportItem {
    private String getProductLine;
    private String productVendor;
    private String productCode;
    private String productName;
    private int quantityOrdered;
    private double priceEach;
    private String orderStatus;
    private String orderFromCity;

    public ProductSalesReportItem(){}
    public ProductSalesReportItem(String getProductLine, String productVendor, String productCode,String productName,
    int quantityOrdered, double priceEach, String orderStatus, String orderFromCity){
        this.getProductLine = getProductLine;
        this.productVendor = productVendor;
        this.productCode = productCode;
        this.productName = productName;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderStatus = orderStatus;
        this.orderFromCity = orderFromCity;
    }

    public String getGetProductLine() {
        return getProductLine;
    }

    public void setGetProductLine(String getProductLine) {
        this.getProductLine = getProductLine;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderFromCity() {
        return orderFromCity;
    }

    public void setOrderFromCity(String orderFromCity) {
        this.orderFromCity = orderFromCity;
    }
}
