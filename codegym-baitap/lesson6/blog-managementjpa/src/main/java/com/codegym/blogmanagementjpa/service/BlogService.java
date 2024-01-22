package com.codegym.blogmanagementjpa.service;

import com.codegym.blogmanagementjpa.model.Blog;
import com.codegym.blogmanagementjpa.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        iBlogRepository.delete(id);
    }
}
