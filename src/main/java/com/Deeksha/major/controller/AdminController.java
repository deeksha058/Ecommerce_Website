package com.Deeksha.major.controller;

import com.Deeksha.major.dto.ProductDto;
import com.Deeksha.major.model.Category;
import com.Deeksha.major.model.Product;
import com.Deeksha.major.service.CategoryService;
import com.Deeksha.major.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AdminController {


    // .................................................. Category section ................................................

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCat(Model model){
        model.addAttribute("categories" , categoryService.getAllCategory());
        return "categories";
    }
    @GetMapping("/admin/categories/add")
    public String addCat(Model model){
        model.addAttribute("category" , new Category());
        return "categoriesAdd";
    }


    @PostMapping("/admin/categories/add")
    public String postAddCat(@ModelAttribute("category") Category category){
        categoryService.addCategory(category );
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable("id") Integer id) {
        categoryService.deleteBYId(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String deleteCat(@PathVariable("id") Integer id ,Model model ) {
        Optional<Category> category = categoryService.getCategoryByid(id);
        if(category.isPresent()){
             model.addAttribute("category" , category.get() );
             return "categoriesAdd";
        }
        return "404 ";
    }

    //     ....................................Product Section ...............................................


    @Autowired
    private ProductService productService;

    @GetMapping("/admin/products")
    public String findAllELement(Model model) {
        model.addAttribute("products" , productService.getAllProduct());
        return "products";
    }

    @GetMapping("/admin/products/add")
    public String addProduct(Model model) {
        model.addAttribute("productDTO" , new ProductDto());

        model.addAttribute("categories" , categoryService.getAllCategory());
        return "productsAdd";
    }

}
