package com.java.boutique.controllers;

import com.java.boutique.dao.CategoryDao;
import com.java.boutique.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @GetMapping("/category")
    public @ResponseBody List<Category> listAll(){
            return categoryDao.listAll();
    }

    @GetMapping("/category/{id}")
    public @ResponseBody List<Category> findById(@PathVariable int id) {
        return categoryDao.findById(id);
    }

    // @deletemapping : indique quelle méthode (delete) on va utiliser
    @DeleteMapping("/category/delete/{id}")
    // reponsebody (pour renvoyer un json)
    public int deleteById(@PathVariable int id) {
        return categoryDao.deleteById(id);
    }


}
