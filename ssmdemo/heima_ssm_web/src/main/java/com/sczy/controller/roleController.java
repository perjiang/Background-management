package com.sczy.controller;

import com.sczy.entity.permission;
import com.sczy.entity.role;
import com.sczy.service.roleService;
import org.aspectj.lang.annotation.DeclareError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/role")
@Service
public class roleController {
    @Autowired
    private roleService service;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        List<role> roleList = service.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        role role = service.findById(id);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(role role) throws Exception{
        service.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) String roleId) throws Exception{
        ModelAndView mv = new ModelAndView();
        //根据RoleId查询role
        role role = service.findById(roleId);
        //查询所有的么有的权限
        List<permission> ohterPermission = service.findOtherPermission(roleId);
        mv.addObject("role",role);
        mv.addObject("permissionList",ohterPermission);
        mv.setViewName("role-permission-add");
        return mv;
    }
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true) String roleId,@RequestParam(name = "ids",required = true) String [] permissionId){
        System.out.println(roleId);
        service.addPermissionToRole(roleId,permissionId);
        return "redirect:findAll.do";
    }

}
