package com.codegym.blogmanagementjpa.service;

import com.codegym.blogmanagementjpa.model.Blog;

import java.util.List;

public interface IBlogService {
    Blog findById(int id);
    List<Blog> findAll();
    void save(Blog blog);
    void delete(int id);
}
