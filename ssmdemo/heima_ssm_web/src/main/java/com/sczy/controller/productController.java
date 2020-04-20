package com.sczy.controller;

import com.sczy.entity.product;
import com.sczy.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class productController {
    @Autowired
    private productService service;
    @RequestMapping("/findAll.do")
    @RolesAllowed("admin")
    public ModelAndView findAll() throws Exception{//查询全部产品
        ModelAndView mv = new ModelAndView();
        List<product> productList = service.findAll();
        mv.addObject("productList",productList);
        mv.setViewName("product-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(product product) throws Exception{//保存产品
        System.out.println(product);
        service.save(product);
        return "redirect:findAll.do";
    }
}
