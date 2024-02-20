package com.codegym.practicecart.controller;

import com.codegym.practicecart.model.Product;
import com.codegym.practicecart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("listProductt")
public class ProductController {
    private IProductService iProductService;

    @Autowired
    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @ModelAttribute("listProductt")
    public Map<Long, Integer> productList(){
        return new HashMap<>();
    }
    @GetMapping("list")
    public String list(Model model){
        List<Product> listProduct = iProductService.findAll();
        model.addAttribute("listProduct", listProduct);
        return "/list";
    }

    @GetMapping("add")
    public String add(Model model, @ModelAttribute(value = "listProductt") Map<Long, Integer> listProduct, @RequestParam(value = "id",defaultValue = "0")Product product, RedirectAttributes redirectAttributes){
        Long id = product.getId();
        Integer num = listProduct.get(id);
        if(num == null){
            listProduct.put(id, 1);
        } else {
            listProduct.put(id, num + 1);
        }
        redirectAttributes.addFlashAttribute("msg", "ok");
        return "redirect:/list";
    }
}
