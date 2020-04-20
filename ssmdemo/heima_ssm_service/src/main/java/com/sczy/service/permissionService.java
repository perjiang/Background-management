package com.sczy.service;

import com.sczy.entity.permission;

import java.util.List;

public interface permissionService {

    public List<permission> findAll() throws Exception;

    void save(permission permission) throws Exception;
}
