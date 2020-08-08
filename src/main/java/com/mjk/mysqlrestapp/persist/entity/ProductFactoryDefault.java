package com.mjk.mysqlrestapp.persist.entity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductFactoryDefault implements ProductFactory {

    public Product newInstance() {
        return new Product();
    }

    @Override
    public Product populateInstance(ResultSet rs) throws SQLException {
        return newInstance(rs.getString("productCode"),
                rs.getString("productName"),
                rs.getString("productLine"),
                rs.getString("productScale"),
                rs.getString("productVendor"),
                rs.getString("productDescription"),
                rs.getInt("quantityInStock"),
                rs.getBigDecimal("buyPrice"),
                rs.getBigDecimal("msrp"));
    }

    public Product newInstance(String productCode, String productName, BigDecimal buyPrice) {
        return new Product(productCode, productName, buyPrice);
    }

    public Product newInstance(String productCode, String productName, String productLine, String productScale, String productVendor, String productDescription, int quantityInStock, BigDecimal buyPrice, BigDecimal msrp) {
        return new Product(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, msrp);
    }


}
