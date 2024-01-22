package com.codegym.blogmanagementjpa.repository;

import com.codegym.blogmanagementjpa.model.Blog;

import java.util.List;

public interface IBlogRepository {
    Blog findById(int id);
    List<Blog> findAll();
    void save(Blog blog);
    void delete(int id);
}
