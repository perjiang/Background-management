package com.sczy.service.impl;

import com.github.pagehelper.PageHelper;
import com.sczy.dao.orderDao;
import com.sczy.entity.orders;
import com.sczy.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class orderServiceimpl implements orderService {
    @Autowired
    private orderDao dao;
    @Override
    public List<orders> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public orders findById(String ordersId) throws Exception {
        return dao.findById(ordersId);
    }
}
