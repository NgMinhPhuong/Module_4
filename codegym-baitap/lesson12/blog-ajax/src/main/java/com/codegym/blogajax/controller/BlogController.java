package com.codegym.blogajax.controller;

import com.codegym.blogajax.model.Blog;
import com.codegym.blogajax.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @GetMapping
    public String index(Model model){
        model.addAttribute("blog", iBlogService.finById(1L));
        return "/index";
    }

    @ResponseBody
    @PostMapping("")
    public ResponseEntity<List<Blog>> find(@RequestBody String name){
         List<Blog> list = iBlogService.find(name);
        return new ResponseEntity<>(list,HttpStatus.OK);

    }
}
