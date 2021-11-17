package com.java.boutique.controllers;

import com.java.boutique.dao.CategoryDao;
import com.java.boutique.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    //route get all
    @GetMapping("/category")
    public @ResponseBody List<Category> listAll(){
            return categoryDao.listAll();
    }

    //route get/id
    @GetMapping("/category/get/{id}")
    public @ResponseBody List<Category> findById(@PathVariable int id) {
        return categoryDao.findById(id);
    }

    //route add
    @PostMapping("/category/add")
    public int add(@RequestBody Category category){
        return categoryDao.add(category);
    }

    //route delete
    @DeleteMapping("/category/delete/{id}")
    // renvoie un json)
    public int deleteById(@PathVariable int id) {
        return categoryDao.deleteById(id);
    }

}
