package com.sczy.controller;

import com.github.pagehelper.PageInfo;
import com.sczy.entity.orders;
import com.sczy.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//orders/findAll
@Controller
@RequestMapping("/orders")
public class ordersController {
    @Autowired
    private orderService service;
    //查询全部订单为分页
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws  Exception{
//        ModelAndView mv = new ModelAndView();
//        List<orders> ordersList = service.findAll();
//        mv.addObject("ordersList",ordersList);
//        mv.setViewName("orders-list");
//        return mv;
//    }


    @RequestMapping("/findAll.do")
    @Secured("ROLE_admin")
    public ModelAndView findAll(@RequestParam(name="page",required = true,defaultValue = "1") int page,
                                @RequestParam(name = "size",required = true, defaultValue = "4") int size
                                ) throws  Exception{
        ModelAndView mv = new ModelAndView();
        List<orders> ordersList = service.findAll(page,size);
        //pageInfo就是一个分页的bean
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String ordersId)throws Exception{
        ModelAndView mv = new ModelAndView();
        orders orders =  service.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
