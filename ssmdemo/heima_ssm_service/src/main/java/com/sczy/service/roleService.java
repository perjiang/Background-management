package com.sczy.service;

import com.sczy.entity.permission;
import com.sczy.entity.role;

import java.util.List;

public interface roleService {

    public List<role> findAll() throws Exception;

    void save(role role) throws  Exception;

    role findById(String roleId) throws  Exception;

    List<permission> findOtherPermission(String roleId) throws  Exception;

    void addPermissionToRole(String roleId, String[] permissionId);
}
