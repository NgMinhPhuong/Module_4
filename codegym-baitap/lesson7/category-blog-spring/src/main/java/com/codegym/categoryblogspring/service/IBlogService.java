package com.codegym.categoryblogspring.service;

import com.codegym.categoryblogspring.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    public List<Blog> findAll();
    public Page<Blog> findByType(Pageable pageable, String type);
    Optional<Blog> findById(Long id);
}
