package com.example.springmvcblog.controller;

import com.example.springmvcblog.domain.Category;
import com.example.springmvcblog.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
    public final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public String create(Model model){
        model.addAttribute("category",new Category());
        return "admin/adminForm";
    }
    public String process(Category category, BindingResult result){
        if(result.hasErrors()){
            return "admin/adminForm";
        }
        categoryService.create(category);
        return "redirect:/categories";
    }
}
