package com.java.boutique.controllers;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.java.boutique.dao.CategoryDao;
import com.java.boutique.models.Category;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/category/{id}")
    public Category findById(@PathVariable int id) {
        return categoryDao.findById(id);
    }


}
