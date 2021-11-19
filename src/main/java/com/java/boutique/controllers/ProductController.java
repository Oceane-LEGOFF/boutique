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

    @GetMapping("/triCroissant")
    public List<Product> triCroissant(@RequestParam(value = "id", required = false) String id,
                                      @RequestParam(value = "type", required = false) String type,
                                      @RequestParam(value = "name", required = false) String name) {
        if (name == null && type == null && id != null){
            return productDao.triCroissantId();
        } else if (name == null && id == null && type != null){
            return productDao.triCroissantType();
        } else if (id == null && type == null && name != null){
            return productDao.triCroissantName();
        } else {
            return productDao.listAll();
        }
    }
    @GetMapping("/triDecroissant")
    public List<Product> triDecroissant(@RequestParam(value = "id", required = false) String id,
                                      @RequestParam(value = "type", required = false) String type,
                                      @RequestParam(value = "name", required = false) String name) {
        if (name == null && type == null && id != null){
            return productDao.triDecroissantId();
        } else if (name == null && id == null && type != null){
            return productDao.triDecroissantType();
        } else if (id == null && type == null && name != null){
            return productDao.triDecroissantName();
        } else {
            return productDao.listAll();
        }
    }

}
