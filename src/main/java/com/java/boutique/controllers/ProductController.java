package com.java.boutique.controllers;

import com.java.boutique.dao.ProductDao;
import com.java.boutique.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDao productDao;
    private String errorMessage;

    //get all si param=0 et pagination
    @GetMapping("")
    public List<Product> getRange(@RequestParam(value = "range", required = false) String range) {
        if (range == null) {
            return productDao.listAll();
        } else {
            return productDao.range(range);
        }
    }

    //route get/id
    @GetMapping("/{id}")
    public @ResponseBody List<Product> findById(@PathVariable int id) {
        return productDao.findById(id);
    }

    //route get/first
    @GetMapping("/first")
    public @ResponseBody List<Product> first() {
        return productDao.first();
    }

    //route get/last
    @GetMapping("/last")
    public @ResponseBody List<Product> last() {
        return productDao.last();
    }

    //route add
    @PostMapping("")
    public int add(@RequestBody Product product){
        return productDao.add(product);
    }

    //route update
    @PutMapping("/{id}")
    public int update(@RequestBody Product product, @PathVariable int id){
        return productDao.updateById(product, id);
    }

    //route DELETE
    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable int id) {
        return productDao.deleteById(id);
    }

    @GetMapping("/search{type, rating, name, createdAt}")
    public @ResponseBody List<Product> search(
            @RequestParam (required = false) String type,
            @RequestParam (required = false) String name,
            @RequestParam (required = false) String createdAt
    ) {
        return productDao.search(type, name, createdAt);
    }

    @GetMapping("/triCroissantName")
    public @ResponseBody List<Product> triCroissant() {
        return productDao.triCroissantName();
    }

    @GetMapping("/triCroissantId")
    public @ResponseBody List<Product> triCroissantId() {
        return productDao.triCroissantId();
    }

    @GetMapping("/triCroissantType")
    public @ResponseBody List<Product> triCroissantType() {
        return productDao.triCroissantType();
    }

    @GetMapping("/triDecroissantName")
    public @ResponseBody List<Product> triDecroissant() {
        return productDao.triDecroissantName();
    }

    @GetMapping("/triDecroissantId")
    public @ResponseBody List<Product> triDecroissantId() {
        return productDao.triDecroissantId();
    }

    @GetMapping("/triDecroissantType")
    public @ResponseBody List<Product> triDecroissantType() {
        return productDao.triDecroissantType();
    }

}
