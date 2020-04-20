package com.sczy.controller;

import com.sczy.entity.permission;
import com.sczy.service.permissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.rmi.MarshalledObject;
import java.util.List;

@Controller
@RequestMapping("/permission")
public class permissionController {
    @Autowired
    private permissionService service;
    @RequestMapping("findAll.do")
    public ModelAndView findALl() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<permission> permissionList = service.findAll();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("save.do")
    public String save(permission permission) throws Exception{
        service.save(permission);
        return "redirect:findAll.do";
    }
}
