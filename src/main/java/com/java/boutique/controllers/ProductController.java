package com.java.boutique.controllers;

import com.java.boutique.dao.ProductDao;
import com.java.boutique.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;
    private String errorMessage;

    //route get all
    @GetMapping("/product")
    public @ResponseBody
    List<Product> listAll(){
        return productDao.listAll();
    }

    //route get/id
    @GetMapping("/product/get/{id}")
    public @ResponseBody List<Product> findById(@PathVariable int id) {
        return productDao.findById(id);
    }

    //route add
    @PostMapping("/product/add")
    public int add(@RequestBody Product product){
        return productDao.add(product);

    }

    //route DELETE
    @DeleteMapping("/product/delete/{id}")
    //renvoie JSON
    public int deleteById(@PathVariable int id) {
        return productDao.deleteById(id);
    }

}
