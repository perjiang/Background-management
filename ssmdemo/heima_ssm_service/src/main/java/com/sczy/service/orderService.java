package com.sczy.service;

import com.sczy.entity.orders;

import java.util.List;

public interface orderService  {
    public List<orders> findAll(int page,int size) throws Exception ;

    orders findById(String ordersId) throws Exception;
}
