package com.codegym.img_day_nasa.service;

import com.codegym.img_day_nasa.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();
    Comment findById(int id);
    void save(Comment comment);
    String saveLike(int id);
}
