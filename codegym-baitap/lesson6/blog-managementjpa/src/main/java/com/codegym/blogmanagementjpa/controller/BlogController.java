package com.codegym.blogmanagementjpa.controller;

import com.codegym.blogmanagementjpa.model.Blog;
import com.codegym.blogmanagementjpa.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("blogs", iBlogService.findAll());
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, Model model){
        model.addAttribute("blog", iBlogService.findById(id));
        return "/delete";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model){
        model.addAttribute("blog", iBlogService.findById(id));
        return "/edit";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam int id, Model model){
        model.addAttribute("content", iBlogService.findById(id).getContent());
        return "/detail";
    }

    @PostMapping("/createoredit")
    public String save(@ModelAttribute Blog blog){
        iBlogService.save(blog);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Blog blog){
        iBlogService.delete(blog.getId());
        return "redirect:/";
    }
}
