package com.codegym.blogajax.service;

import com.codegym.blogajax.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> find(String name);
    List<Blog> findAll();
    Blog finById(Long id);
}
