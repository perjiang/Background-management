package com.sczy.controller;

import com.sczy.entity.role;
import com.sczy.entity.user;
import com.sczy.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    private userService service;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        List<user> userList = service.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(user user){
        service.save(user);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception{
        user user = service.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("user-show1");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userId) throws Exception {
        ModelAndView mv = new ModelAndView();
        //根据用户id查询锁要寻找的用户
        user user = service.findById(userId);
        //查询当前用户还能添加的角色
        List<role> otherRole =  service.findOtherRole(userId);
        mv.addObject("user",user);
        mv.addObject("roleList",otherRole);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) String [] roleId) throws Exception {
        service.addRoleToUser(userId,roleId);
        return "redirect:findAll.do";
    }
    @RequestMapping("/getUser.do")
    public ModelAndView getUser(String name) throws Exception {
        ModelAndView mv = new ModelAndView();
        user user = service.findByName(name);
        mv.addObject("user",user);
        mv.setViewName("updatePwd");
        return mv;
    }
    @RequestMapping("/changePwd.do")
    public String changePwd(@RequestParam(name = "id") String id,@RequestParam(name = "password") String password){
        service.updatePwd(id, password);
        return "redirect:/login.jsp";
    }

}
