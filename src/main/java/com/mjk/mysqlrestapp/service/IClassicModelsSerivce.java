package com.mjk.mysqlrestapp.service;

import com.mjk.mysqlrestapp.persist.entity.ProductLine;

import java.util.List;

public interface IClassicModelsSerivce
{
    List<ProductLine> FindAllProductLines();

    List<ProductLine> FindByCode(int code);

    void Bingo();
}
