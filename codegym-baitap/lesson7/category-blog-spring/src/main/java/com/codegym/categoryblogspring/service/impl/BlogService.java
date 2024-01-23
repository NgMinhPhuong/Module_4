package com.codegym.categoryblogspring.service.impl;

import com.codegym.categoryblogspring.model.Blog;
import com.codegym.categoryblogspring.repository.BlogRepository;
import com.codegym.categoryblogspring.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findByType(Pageable pageable, String type) {
        return blogRepository.findByCategory_Typeee(pageable, type);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }
}
