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

    //route get all
    @GetMapping("")
    public @ResponseBody List<Product> listAll(){
        return productDao.listAll();
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

    //route get/range
    @GetMapping("/range")
    public @ResponseBody List<Product> range() {
        return productDao.range();
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

    //route get/rangeLimité
    @GetMapping("/rangelimit")
    public @ResponseBody List<Product> rangeLimit() {
        return productDao.rangeLimit();
    }

    @GetMapping("/search{type, rating, name, createdAt}")
    public @ResponseBody List<Product> search(
            @RequestParam (required = false) String type,
            @RequestParam (required = false) String name,
            @RequestParam (required = false) String createdAt
    ) {
        return productDao.search(type, name, createdAt);
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

}
