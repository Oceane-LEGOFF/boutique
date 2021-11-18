package com.java.boutique.controllers;

import com.java.boutique.dao.CategoryDao;
import com.java.boutique.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    //route get all
    @GetMapping("")
    public @ResponseBody List<Category> listAll(){
            return categoryDao.listAll();
    }

    @GetMapping("/{name}")
    public @ResponseBody List<Category> find(@PathVariable String name){
        return categoryDao.find(name);
    }

    //route get/id
    @GetMapping("/{id}")
    public @ResponseBody List<Category> findById(@PathVariable int id) {
        return categoryDao.findById(id);
    }

    //route get/first
    @GetMapping("/first")
    public @ResponseBody List<Category> findFirst() {
        return categoryDao.findFirst();
    }

    //route get/last
    @GetMapping("/last")
    public @ResponseBody List<Category> last() {
        return categoryDao.last();
    }

    //route get/range
    @GetMapping("/range")
    public @ResponseBody List<Category> range() {
        return categoryDao.range();
    }

    //route get/rangeLimité
    @GetMapping("/rangelimit")
    public @ResponseBody List<Category> rangeLimit() {
        return categoryDao.rangeLimit();
    }

    //route add
    @PostMapping("")
    public int add(@RequestBody Category category){
        return categoryDao.add(category);
    }

    //route update
    @PutMapping("/{id}")
    public int update(@RequestBody Category category, @PathVariable int id){
        return categoryDao.updateById(category, id);
    }

    //route delete
    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable int id) {
        return categoryDao.deleteById(id);
    }

}
