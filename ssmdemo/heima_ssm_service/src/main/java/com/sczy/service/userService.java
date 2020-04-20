package com.sczy.service;

import com.sczy.entity.role;
import com.sczy.entity.user;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface userService extends UserDetailsService {
    public List<user> findAll();

    public void save(user user);

    public user findById(String id) throws  Exception;

    List<role> findOtherRole(String userId) throws Exception;

    void addRoleToUser(String userId, String[] roleId) throws Exception;

    user findByName(String name) throws Exception;

    void updatePwd(String id,String password);
}
