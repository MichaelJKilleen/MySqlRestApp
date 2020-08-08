package com.mjk.mysqlrestapp.persist.repository;

import com.mjk.mysqlrestapp.persist.entity.Product;
import com.mjk.mysqlrestapp.persist.entity.ProductFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcProductRepository implements ProductRepository {

    // Spring Boot will create and configure DataSource and JdbcTemplate
    // To use it, just @Autowired
    private JdbcTemplate jdbcTemplate;
    private ProductFactory productFactory;

    //private NamedParameterJdbcTemplate jdbcTemplate;

    public JdbcProductRepository(JdbcTemplate jdbcTemplate, ProductFactory productFactory) {
        this.jdbcTemplate = jdbcTemplate;
        this.productFactory = productFactory;
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from products", Integer.class);
    }

    @Override
    public int save(Product product) {
        return jdbcTemplate.update(
                "insert into products (productName, buyPrice) values(?,?)",
                product.getProductName(), product.getBuyPrice());
    }

    @Override
    public int update(Product product) {
        return jdbcTemplate.update(
                "update products set buyPrice = ? where productCode = ?",
                product.getBuyPrice(), product.getProductCode());
    }


    @Override
    public int deleteById(Long id) {
        return -1;
//        return jdbcTemplate.update(
//                "delete books where id = ?",
//                id);
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(
                "select * from products",
                (rs, rowNum) ->
                        productFactory.newInstance(
                                rs.getString("productCode"),
                                rs.getString("productName"),
                                rs.getString("productLine"),
                                rs.getString("productScale"),
                                rs.getString("productVendor"),
                                rs.getString("productDescription"),
                                rs.getInt("quantityInStock"),
                                rs.getBigDecimal("buyPrice"),
                                rs.getBigDecimal("msrp"))
        );
    }

    // jdbcTemplate.queryForObject, populates a single object

    @Override
    public List<Product> findByProductLine(String productLine) {
        return jdbcTemplate.query(
                "select * from products where productLine = ?",
                new Object[]{productLine},
                (rs, rowNum) ->
                        productFactory.populateInstance(rs)
        );
    }


    @Override
    public Optional<Product> findById(String id) {
        return jdbcTemplate.queryForObject(
                "select * from products where productCode = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(productFactory.populateInstance(rs))
        );
    }

    @Override
    public List<Product> findByNameAndPrice(String name, BigDecimal price) {
        return jdbcTemplate.query(
                "select * from products where productName like ? and buyPrice <= ?",
                new Object[]{"%" + name + "%", price},
                (rs, rowNum) ->
                        productFactory.populateInstance(rs)
        );
    }

    @Override
    public String getNameById(String id) {
        return jdbcTemplate.queryForObject(
                "select name from products where productCode = ?",
                new Object[]{id},
                String.class
        );
    }
}