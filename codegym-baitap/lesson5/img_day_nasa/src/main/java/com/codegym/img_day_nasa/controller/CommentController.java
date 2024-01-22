package com.codegym.img_day_nasa.controller;

import com.codegym.img_day_nasa.model.Comment;
import com.codegym.img_day_nasa.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentController {
    @Autowired
    private ICommentService iCommentService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", iCommentService.findAll());
        return "/index";
    }

    @PostMapping("/")
    public String index(@ModelAttribute Comment comment){
        iCommentService.save(comment);
        return "redirect:/";
    }

    @ResponseBody
    @GetMapping ("/likes")
    public String increaseLike(@RequestParam int id){
        return iCommentService.saveLike(id);
    }
}
