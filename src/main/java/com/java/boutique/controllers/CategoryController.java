package com.java.boutique.controllers;

import com.java.boutique.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping("/category")
    public String index(Model model){
        model.addAttribute("listCategory", categoryDao.listAll());
        return "index";
    }
}
