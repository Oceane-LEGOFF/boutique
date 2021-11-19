package com.java.boutique.controllers;

import com.java.boutique.dao.ProductDao;
import com.java.boutique.models.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(description = "Products management")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDao productDao;
    private String errorMessage;

    //get all si param=0 et pagination
    @ApiOperation(value = "Retrieves all products if no parameter is given, otherwise retrieves elements in range given.")
    @GetMapping("")
    public List<Product> getRange(@RequestParam(value = "range", required = false) String range) {
        if (range == null) {
            return productDao.listAll();
        } else {
            return productDao.range(range);
        }
    }

    //route get/id
    @ApiOperation(value = "Retrieves a product via its id")
    @GetMapping("/{id}")
    public @ResponseBody List<Product> findById(@PathVariable int id) {
        return productDao.findById(id);
    }

    //route get/first
    @ApiOperation(value = "Retrieves the first product of the list")
    @GetMapping("/first")
    public @ResponseBody List<Product> first() {
        return productDao.first();
    }

    //route get/last
    @ApiOperation(value = "Retrieves the last product of the list")
    @GetMapping("/last")
    public @ResponseBody List<Product> last() {
        return productDao.last();
    }

    //route add
    @ApiOperation(value = "Adds a new product")
    @PostMapping("")
    public int add(@RequestBody Product product){
        return productDao.add(product);
    }

    //route update
    @ApiOperation(value = "Edits a product via its id")
    @PutMapping("/{id}")
    public int update(@RequestBody Product product, @PathVariable int id){
        return productDao.updateById(product, id);
    }

    //route DELETE
    @ApiOperation(value = "Deletes a product")
    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable int id) {
        return productDao.deleteById(id);
    }

    @ApiOperation(value = "Searches for the products linked to the parameter given in the URL")
    @GetMapping("/search{type, rating, name, createdAt}")
    public @ResponseBody List<Product> search(
            @RequestParam (required = false) String type,
            @RequestParam (required = false) String name,
            @RequestParam (required = false) String createdAt
    ) {
        return productDao.search(type, name, createdAt);
    }

    @ApiOperation(value = "Retrieves the whole list with an ascending sort according to the parameter, otherwise, retrieves all elements if no parameter is given.")
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

    @ApiOperation(value = "Retrieves the whole list with a descending sort according to the parameter, otherwise, retrieves all elements if no parameter is given.")
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
