package com.mjk.mysqlrestapp.persist.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

//@Entity
//@Table(name = "PRODUCTS")
public class Product
{
    private String  productCode;
    private String  productName;
    private String  productLine;
    private String  productScale;
    private String  productVendor;
    private String  productDescription;
    private int     quantityInStock;
    private BigDecimal buyPrice;
    private BigDecimal msrp;

    Product() {
        productCode = "";
        productName = "";
        productLine = "";
        productScale = "";
        productVendor = "";
        productDescription = "";
        quantityInStock = 0;
        buyPrice = BigDecimal.ZERO;
        msrp = BigDecimal.ZERO;
    }

    Product(String productCode, String productName, BigDecimal buyPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.buyPrice = buyPrice;
    }

    Product(String productCode, String productName, String productLine, String productScale, String productVendor, String productDescription, int quantityInStock, BigDecimal buyPrice, BigDecimal msrp) {
        this.productCode = productCode;
        this.productName = productName;
        this.productLine = productLine;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = new BigDecimal(String.valueOf(buyPrice));
        this.msrp = new BigDecimal(String.valueOf(msrp));
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

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getMsrp() {
        return msrp;
    }

    public void setMsrp(BigDecimal msrp) {
        this.msrp = msrp;
    }
}