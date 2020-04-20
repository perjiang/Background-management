package com.sczy.service.impl;

import com.sczy.dao.roleDao;
import com.sczy.entity.permission;
import com.sczy.entity.role;
import com.sczy.service.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional

public class roleServiceimpl implements roleService {
    @Autowired
    private roleDao dao;
    @Override
    public List<role> findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public void save(role role) throws Exception {
        dao.save(role);
    }

    @Override
    public role findById(String roleId) throws Exception {

        return dao.findById(roleId);
    }

    @Override
    public List<permission> findOtherPermission(String roleId) throws Exception {
        return dao.findOtherPermission(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionId) {
        for (String perId : permissionId) {
            dao.addPermissionToRole(roleId,perId);
            System.out.println(perId);
            System.out.println(roleId);
        }

    }
}
