package com.sczy.service.impl;

import com.sczy.dao.permissonDao;
import com.sczy.entity.permission;
import com.sczy.service.permissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class permissionServiceImpl implements permissionService {
    @Autowired
    private permissonDao dao;
    @Override
    public List<permission> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public void save(permission permission) throws Exception {
        dao.save(permission);
    }
}
