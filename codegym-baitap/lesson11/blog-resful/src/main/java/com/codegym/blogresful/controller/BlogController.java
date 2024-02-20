package com.codegym.blogresful.controller;

import com.codegym.blogresful.model.Blog;
import com.codegym.blogresful.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("blogs")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;
    @GetMapping
    public ResponseEntity<List<Blog>> getAll(){
        List<Blog> blogs = iBlogService.findAll();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> getById(@PathVariable Long id){
        Blog blog = iBlogService.findById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody Blog blog){
        iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        iBlogService.delete(iBlogService.findById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
