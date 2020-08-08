package com.mjk.mysqlrestapp.persist.entity;

import javax.persistence.Entity;
import java.util.List;

//@Entity(name = "PRODUCTLINES")
public class ProductLine
{
    private String productLine;

    public String textDescription;

    public String htmlDescription;

    private byte[] image;

    private List<Product> productList;

    public ProductLine(String productLine, String textDescription, String htmlDescription) {
        this.productLine = productLine;
        this.textDescription = textDescription;
        this.htmlDescription = htmlDescription;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}