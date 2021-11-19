package com.java.boutique.controllers;

import com.java.boutique.dao.CategoryDao;
import com.java.boutique.models.Category;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(description = "Categories management")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;
    /*
    @GetMapping("")

    // retourne toutes les catégories  et si params dans l'url, renvoie à partir de l'index donné et la quantité donnée en size.
    @GetMapping("")
    public @ResponseBody List<Category> listAll(@RequestParam("start")int start,
                                                @RequestParam("size") int size) {
        if(start >= 0 && size >= 0) {
            return categoryDao.listAllPaginated(start, size);
        }
        return categoryDao.listAll();
    }
    */

    /**
     * Get all category list.
     *
     * @return the list
     */
    @ApiOperation(value = "Retrieves the whole list of categories.")

    public @ResponseBody List<Category> listAll(){
        return categoryDao.listAll();
    }

    //pagination
    @ApiOperation(value = "If no parameter is given, retrieves the whole list, otherwise returns the elements within the given range.")
    @GetMapping("")
    public List<Category> getRange(@RequestParam(value = "range", required = false) String range) {
        if (range == null) {
            return categoryDao.listAll();
        } else {
            return categoryDao.range(range);
        }
    }

    /**
     * Get the first category of the list.
     *
     * @params none
     * @return first category
     */
    @ApiOperation(value = "Retrieves the first category of the list")
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
    @ApiOperation(value = "Retrieves the last category of the list")
    @GetMapping("/last")
    public @ResponseBody List<Category> last() {
        return categoryDao.last();
    }

    /**
     * Add category of the list.
     *
     * @params none
     * @return int 1
     */
    @ApiOperation(value = "Adds a new category")
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
    @ApiOperation(value = "Updates a category via its id.")
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
    @ApiOperation(value = "Deletes a category via its id")
    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable int id) {
        return categoryDao.deleteById(id);
    }

    /**
     *
     * @param name
     * @return search by name
     */
    @ApiOperation(value = "Searches for a category via its name")
    @GetMapping("/search{name}")
    public @ResponseBody List<Category> find(@RequestParam String name){
        return categoryDao.find(name);
    }

    /**
     * Get one category list.
     *
     * @params id
     * @return category category
     */
    @ApiOperation(value = "Retrieves a category via its id")
    @GetMapping("/{id}")
    public @ResponseBody List<Category> findById(@PathVariable int id) {
        return categoryDao.findById(id);
    }

    @ApiOperation(value = "Retrieves the whole list of categories with an ascending sort according to the parameter, otherwise, retrieves all elements if no parameter is given.")
    @GetMapping("/triCroissant")
    public List<Category> triCroissant(@RequestParam(value = "id", required = false) String id,
                                        @RequestParam(value = "name", required = false) String name) {
        if (name == null && id != null){
            return categoryDao.triCroissantId();
        } else if (id == null && name != null){
            return categoryDao.triCroissantName();
        } else {
            return categoryDao.listAll();
        }
    }

    @ApiOperation(value = "Retrieves the whole list of categories with a descending sort according to the parameter, otherwise, retrieves all elements if no parameter is given.")
    @GetMapping("/triDecroissant")
    public List<Category> triDecroissant(@RequestParam(value = "id", required = false) String id,
                                        @RequestParam(value = "name", required = false) String name) {
        if (name == null && id != null){
            return categoryDao.triDecroissantId();
        } else if (id == null && name != null){
            return categoryDao.triDecroissantName();
        } else {
            return categoryDao.listAll();
        }
    }

}
