package com.mjk.mysqlrestapp.service;

import com.mjk.mysqlrestapp.persist.entity.Product;
import com.mjk.mysqlrestapp.persist.entity.ProductLine;
import com.mjk.mysqlrestapp.persist.repository.ProductLineRepository;
import com.mjk.mysqlrestapp.persist.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassicModelsService implements IClassicModelsSerivce {

    private ProductLineRepository productLineRepository;
    private ProductRepository productRepository;

    public ClassicModelsService(ProductLineRepository productLineRepository,ProductRepository productRepository) {
        this.productLineRepository = productLineRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductLine> FindAllProductLines() {
        List<ProductLine> productLineList = productLineRepository.findAll();
        productLineList.forEach(productLine -> {
            List<Product> products = productRepository.findByProductLine(productLine.getProductLine());
            productLine.setProductList(products);
        });
        return productLineList;
    }

    @Override
    public List<ProductLine> FindByCode(int code) {
        return null;
    }

    @Override
    public void Bingo() {

    }
}