package com.java.boutique.controllers;

import com.java.boutique.dao.ProductDao;
import com.java.boutique.models.Product;
import com.java.boutique.models.viewmodels.ProductViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    
    @Autowired
    private ProductDao productService;
    private String errorMessage;

    @GetMapping("/product")
    public String index(Model model){
        model.addAttribute("listProduct", productService.listAll());
        return "indexProduct";
    }

    @GetMapping(value = { "/products/add" })
    public String add(Model model){
        model.addAttribute("productForm", new ProductViewModel());
        return "add";
    }

    @PostMapping(value = { "/products/add" })
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
