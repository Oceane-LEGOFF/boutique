package com.java.boutique.controllers;

import com.java.boutique.dao.CategoryDao;
import com.java.boutique.dao.ProductDao;
import com.java.boutique.models.Product;
import com.java.boutique.models.viewmodels.ProductViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @Autowired
    private ProductDao productService;

    private String errorMessage;

    @RequestMapping("/product")
    public String index(Model model){
        model.addAttribute("listProduct", productService.listAll());
        return "indexProduct";
    }

    @RequestMapping(value = { "/products/add" }, method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("productForm", new ProductViewModel());
        return "add";
    }

    @RequestMapping(value = { "/products/add" }, method = RequestMethod.POST)
    public String addPost(Model model, @ModelAttribute("productForm") ProductViewModel productViewModel){

        if (productViewModel.getName() != null && productViewModel.getName().length() > 0 //
                && productViewModel.getType() != null &&  productViewModel.getType().length() > 0) {
            Product p = new Product();
            p.setName(productViewModel.getName());
            p.setType(productViewModel.getType());
            p.setRating(productViewModel.getRating());
            productService.add(p);

            return "redirect:/products";
        }
        errorMessage = "Nom et type obligatoiregi";
        model.addAttribute("errorMessage", errorMessage);
        return "add";


    }
}
