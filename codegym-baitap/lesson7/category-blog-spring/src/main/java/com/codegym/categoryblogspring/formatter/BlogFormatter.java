package com.codegym.categoryblogspring.formatter;

import com.codegym.categoryblogspring.model.Blog;
import com.codegym.categoryblogspring.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class BlogFormatter implements Formatter<Blog>{


    private final IBlogService iBlogService;

    @Autowired
    public BlogFormatter(IBlogService iBlogService){
        this.iBlogService = iBlogService;
    }


    @Override
    public Blog parse(String text, Locale locale) throws ParseException {
         return iBlogService.findById(Long.parseLong(text)).get();
    }

    @Override
    public String print(Blog object, Locale locale) {
        return null;
    }
}
