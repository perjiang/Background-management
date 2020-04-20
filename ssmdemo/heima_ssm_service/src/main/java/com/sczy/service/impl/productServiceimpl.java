package com.sczy.service.impl;

import com.sczy.dao.productDao;
import com.sczy.entity.product;
import com.sczy.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class productServiceimpl implements productService {
    @Autowired
    private productDao productDao;
    @Override
    public List<product> findAll() throws Exception {
        return productDao.findALl();
    }

    @Override
    public void save(product product) throws Exception {

        productDao.save(product);
    }
}
