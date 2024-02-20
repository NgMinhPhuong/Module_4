package com.codegym.blogresful.service.impl;

import com.codegym.blogresful.model.Blog;
import com.codegym.blogresful.repository.IBlogRepository;
import com.codegym.blogresful.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public Blog save(Blog entity) {
        return iBlogRepository.save(entity);
    }

    @Override
    public void delete(Blog blog) {
        iBlogRepository.delete(blog);
    }
}
