package com.mjk.mysqlrestapp.persist;

import com.mjk.mysqlrestapp.persist.entity.ProductLine;

import java.util.List;

public interface IProductLinePersist {
    List<ProductLine> FindAll();
}
