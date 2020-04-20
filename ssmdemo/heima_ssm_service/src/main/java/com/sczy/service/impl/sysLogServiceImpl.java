package com.sczy.service.impl;

import com.sczy.dao.sysdao;
import com.sczy.entity.syslog;
import com.sczy.service.sysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class sysLogServiceImpl implements sysLogService {

    @Autowired
    private sysdao dao;
    @Override
    public void save(syslog sysLog) throws Exception {
        dao.save(sysLog);
    }

    @Override
    public List<syslog> findAll() {
        return dao.findAll();
    }
}
