package com.sczy.service;

import com.sczy.entity.syslog;

import java.util.List;

public interface sysLogService {
    void save(syslog sysLog) throws Exception;

    List<syslog> findAll();
}
