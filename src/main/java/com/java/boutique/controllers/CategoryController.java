package com.java.boutique.controllers;

import com.java.boutique.dao.CategoryDao;
import com.java.boutique.models.Category;
import com.java.boutique.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    /**
     * Get all category list.
     *
     * @return the list
     */
    @GetMapping("")
    public @ResponseBody List<Category> listAll(){
            return categoryDao.listAll();
    }

    // retourne toutes les catégories  et si params dans l'url, renvoie à partir de l'index donné et la quantité donnée en size.
    /*@GetMapping("")
    public @ResponseBody List<Category> listAll(@RequestParam("start")int start,
                                                @RequestParam("size") int size) {
        if(start >= 0 && size >= 0) {
            return categoryDao.listAllPaginated(start, size);
        }
        return categoryDao.listAll();
    } */

    @GetMapping("/search{name}")
    public @ResponseBody List<Category> find(@RequestParam String name){
        return categoryDao.find(name);
    }

    /**
     * Get one product list.
     *
     * @params id
     * @return product product
     */
    @GetMapping("/{id}")
    public @ResponseBody List<Category> findById(@PathVariable int id) {
        return categoryDao.findById(id);
    }

    /**
     * Get all category list.
     *
     * @params none
     * @return category sort by name
     */
    @GetMapping("/triCroissantName")
    public @ResponseBody List<Category> triCroissant() {
        return categoryDao.triCroissantName();
    }

    /**
     * Get all category list.
     *
     * @params none
     * @return category sort by id
     */
    @GetMapping("/triCroissantId")
    public @ResponseBody List<Category> triCroissantId() {
        return categoryDao.triCroissantId();
    }

    /**
     * Get all category list.
     *
     * @params none
     * @return category sort by name
     */
    @GetMapping("/triDecroissantName")
    public @ResponseBody List<Category> triDecroissant() {
        return categoryDao.triDecroissantName();
    }

    /**
     * Get all category list.
     *
     * @params none
     * @return category sort by id
     */
    @GetMapping("/triDecroissantId")
    public @ResponseBody List<Category> triDecroissantId() {
        return categoryDao.triDecroissantId();
    }

    /**
     * Get the first category of the list.
     *
     * @params none
     * @return first category
     */
    @GetMapping("/first")
    public @ResponseBody List<Category> first() {
        return categoryDao.first();
    }

    /**
     * Get the last category of the list.
     *
     * @params none
     * @return last category
     */
    @GetMapping("/last")
    public @ResponseBody List<Category> last() {
        return categoryDao.last();
    }

    /**
     * Get the 10 first category of the list.
     *
     * @params none
     * @return 10 category product
     */
    @GetMapping("/range")
    public @ResponseBody List<Category> range() {
        return categoryDao.range();
    }

    /**
     * Get the 3  category of the list from the 5th place.
    *
    * @params none
     * @return 3 category
     */
    @GetMapping("/rangelimit")
    public @ResponseBody List<Category> rangeLimit() {
        return categoryDao.rangeLimit();
    }

    /**
     * Add category of the list.
     *
     * @params none
     * @return int 1
     */
    @PostMapping("")
    public int add(@RequestBody Category category){
        return categoryDao.add(category);
    }

    /**
     * update category of the list.
     *
     * @params id
     * @return updated category
     */
    @PutMapping("/{id}")
    public int update(@RequestBody Category category, @PathVariable int id){
        return categoryDao.updateById(category, id);
    }

    /**
     * delete category of the list.
     *
     * @params id
     * @return
     */
    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable int id) {
        return categoryDao.deleteById(id);
    }

}
