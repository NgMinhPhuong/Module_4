package com.codegym.categoryblogspring.controller;

import com.codegym.categoryblogspring.model.Blog;
import com.codegym.categoryblogspring.model.Category;
import com.codegym.categoryblogspring.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @GetMapping("blog")
    public String blog(Model model, @RequestParam(value = "search", defaultValue = "") String type, @RequestParam(value = "page", defaultValue = "0") int page){
        Page<Blog> blogs =  iBlogService.findByType(PageRequest.of(page, 2, Sort.by("category.id").descending()), type);
        model.addAttribute("search", type);
        model.addAttribute("blogs", blogs);
        return "/index";
    }

    @GetMapping("check")
    public String checkFormat(@RequestParam(value = "id",defaultValue = "1")  Blog blog){
        return "index";
    }
}
