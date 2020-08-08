package com.mjk.mysqlrestapp.persist.entity;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ProductFactory {

    Product newInstance();

    Product populateInstance(ResultSet rs) throws SQLException;

    Product newInstance(String productCode, String productName, String productLine, String productScale, String productVendor, String productDescription, int quantityInStock, BigDecimal buyPrice, BigDecimal msrp);

    Product newInstance(String productCode, String productName, BigDecimal buyPrice);

}
