package com.codegym.productmanagementthymeleaf.controller;

import com.codegym.productmanagementthymeleaf.model.Product;
import com.codegym.productmanagementthymeleaf.service.IProductService;
import com.codegym.productmanagementthymeleaf.service.ProductService;
import jdk.internal.icu.text.NormalizerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("products", iProductService.getAll());
        return "/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product, Model model){
        iProductService.add(product);
        model.addAttribute("products", iProductService.getAll());
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        model.addAttribute("product", iProductService.get(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Product product){
        iProductService.delete(product.getId());
        return "redirect:/products";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable String id, Model model){
        model.addAttribute("product", iProductService.get(id));
        return "/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Product product){
        iProductService.update(product);
        return "redirect:/products";
    }
}
