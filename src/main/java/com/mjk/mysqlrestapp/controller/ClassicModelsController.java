package com.mjk.mysqlrestapp.controller;
import com.mjk.mysqlrestapp.persist.entity.ProductLine;
import com.mjk.mysqlrestapp.persist.repository.ProductLineRepository;
import com.mjk.mysqlrestapp.service.IClassicModelsSerivce;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import com.mjk.mysqlrestapp.persist.entity.Product;
import com.mjk.mysqlrestapp.persist.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/classicmodels")
public class ClassicModelsController {

    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(getClass());
    private ProductRepository productRepository;
    private IClassicModelsSerivce classicModelsSerivce;

    public ClassicModelsController(ProductRepository productRepository,
                                   IClassicModelsSerivce classicModelsSerivce) {
        this.productRepository = productRepository;
        this.classicModelsSerivce = classicModelsSerivce;
    }

    @GetMapping("/products")
    @Secured("ROLE_USER")
    public List<Product> get(@RequestParam(value = "productLine", defaultValue = "") String productLine) {
        List<Product> products = (List<Product>) productRepository.findAll();
        if(!productLine.equals("")) {
            products = products.stream()
                    .filter(product -> product.getProductLine().equals(productLine))
                    .collect(Collectors.toList());
        }
            products.forEach(product -> System.out.println(product.getProductCode()));

        return products;
    }

    //@GetMapping("/productlines/productLine")
    //public List<ProductLine> getProductLine(@PathVariable("productLine") String productLine) {
    @GetMapping("/productlines")
    @Secured("ROLE_USER")
    public List<ProductLine> getProductLine(@RequestParam(value = "productLine", defaultValue = "") String productLine) {
        List<ProductLine> productLines = classicModelsSerivce.FindAllProductLines();
        if(!productLine.equals("")) {
                productLines = productLines.stream()
                    .filter(productLine1 -> productLine1.getProductLine().equals(productLine))
                    .collect(Collectors.toList());
        }
        return productLines;
    }

    @PatchMapping(path="/{id}", consumes = "application/json", produces = "application/json")
    @Secured("ROLE_ADMIN")
    public String patch(@PathVariable("id") int id,  @RequestBody String employee ) {
        System.out.println("id: " + id + ", employee: " + employee);
        return "Done";
    }

}