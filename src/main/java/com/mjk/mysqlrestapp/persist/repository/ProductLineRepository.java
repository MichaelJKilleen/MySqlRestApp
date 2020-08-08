package com.mjk.mysqlrestapp.persist.repository;

import com.mjk.mysqlrestapp.persist.entity.Product;
import com.mjk.mysqlrestapp.persist.entity.ProductLine;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public interface ProductLineRepository {
    int count();

    int save(ProductLine productLine);

    int update(ProductLine productLine);

    int deleteById(Long id);

    List<ProductLine> findAll();

    ProductLine findByProductLine(String productLine);

    // jdbcTemplate.queryForObject, populates a single object
    Optional<Product> findById(String id);


}
