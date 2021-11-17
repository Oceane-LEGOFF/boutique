package com.java.boutique.controllers;

import com.java.boutique.dao.CategoryDao;
import com.java.boutique.models.Category;
import com.java.boutique.models.viewmodels.CategoryViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoryController {

    @Autowired
    private CategoryDao categoryService;
    private String errorMessage;

    @RequestMapping("/category")
    public String index(Model model){
        model.addAttribute("listCategory", categoryService.listAll());
        return "index";
    }


    @RequestMapping(value = { "/categoriy/add" }, method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("categoryForm", new CategoryViewModel());
        return "add";
    }

    @RequestMapping(value = { "/categoriy/add" }, method = RequestMethod.POST)
    public String addPost(Model model, @ModelAttribute("categoryForm") CategoryViewModel categoryViewModel){

        if (categoryViewModel.getName() != null && categoryViewModel.getName().length() > 0) {
            Category c = new Category();
            c.setName(categoryViewModel.getName());
            categoryService.add(c);

            return "redirect:/categories";
        }
        errorMessage = "Nom obligatoire";
        model.addAttribute("errorMessage", errorMessage);
        return "add";

    }
}
