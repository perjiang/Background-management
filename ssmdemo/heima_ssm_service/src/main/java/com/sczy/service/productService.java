package com.sczy.service;

import com.sczy.entity.product;


import java.util.List;

public interface productService {
    public List<product> findAll() throws Exception;
    public void save(product product) throws Exception;
}
