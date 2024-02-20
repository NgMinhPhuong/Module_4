package com.codegym.blogajax.service.impl;

import com.codegym.blogajax.model.Blog;
import com.codegym.blogajax.repository.IBlogRepository;
import com.codegym.blogajax.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;



    public List<Blog> findAll(){
        return iBlogRepository.findAll();
    }

    @Override
    public Blog finById(Long id) {
        return iBlogRepository.findById(id).get();
    }

    public List<Blog> find(String name){
        return iBlogRepository.find(name);
    }
}
