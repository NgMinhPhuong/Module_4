package com.codegym.practicecart.controller;

import com.codegym.practicecart.model.Product;
import com.codegym.practicecart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartController {
    private IProductService iProductService;

    @Autowired
    public CartController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @GetMapping("cart")
    public String show(@SessionAttribute(value = "listProductt") Map<Long, Integer> mp, Model model){
        Map<Product, Integer> listProduct = new HashMap<>();
        if(mp != null) {
            for (Map.Entry<Long, Integer> mp1 : mp.entrySet()) {
                listProduct.put(iProductService.findById(mp1.getKey()).get(), mp1.getValue());
            }

        }
        model.addAttribute("listProduct", listProduct);
        return "/showCart";
    }
}
