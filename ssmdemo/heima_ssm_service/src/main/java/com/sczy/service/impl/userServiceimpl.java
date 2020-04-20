package com.sczy.service.impl;

import com.github.pagehelper.PageHelper;
import com.sczy.dao.userdao;
import com.sczy.entity.role;
import com.sczy.entity.user;
import com.sczy.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class userServiceimpl implements userService {
    @Autowired
    private userdao dao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        user user = null;
        try {
            user = dao.findByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //User u = new User(user.getUsername(),"{noop}"+user.getPassword(),getJS(user.getRoles()));
        User u = new User(user.getUsername(),user.getPassword(),user.getStatus()==0?false:true,true,true,true,getJS(user.getRoles()));
        System.out.println(u.getAuthorities());
        return u;
    }

    public List<SimpleGrantedAuthority> getJS(List<role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (role r : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+r.getRoleName()));
        }

        return  list;
    }

    @Override
    public List<user> findAll() {
        PageHelper.startPage(1,4);
        List<user> userList = dao.findAll();
        return userList;
    }

    @Override
    public void save(user user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        dao.save(user);
    }

    @Override
    public user findById(String id) throws  Exception {
        user user = dao.findById(id);
        return user;
    }

    @Override
    public List<role> findOtherRole(String userId) throws Exception {
        List<role> otherRole = dao.findOtherRole(userId);
        return otherRole;
    }

    @Override
    public void addRoleToUser(String userId, String[] roleId) throws Exception {
        for (String role : roleId) {
            dao.addRoleToUser(userId,role);
        }
    }

    @Override
    public user findByName(String name) throws Exception {
        user user = dao.findByName(name);
        return user;
    }

    @Override
    public void updatePwd(String id,String password) {
        dao.updatePwd(id,bCryptPasswordEncoder.encode(password));
    }
}
