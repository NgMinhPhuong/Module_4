package com.codegym.borrowbookaspects.controller;

import com.codegym.borrowbookaspects.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BorrowBookController {

    private final IBorrowBookService iBorrowBookService;

    @Autowired
    public BorrowBookController(IBorrowBookService iBorrowBookService) {
        this.iBorrowBookService = iBorrowBookService;
    }

    @GetMapping("")
    public String index(){
        return "/index";
    }

    @PostMapping("/borrow")
    public String borrow(@RequestParam("code") String code, Model model) throws Exception {
        model.addAttribute("messageBorrow", iBorrowBookService.borrow(code));
        return "/index";
    }

    @PostMapping("back")
    public String back(@RequestParam("code") String code, Model model) throws Exception {
        model.addAttribute("messageBack", iBorrowBookService.bookBack(code));
        return "/index";
    }
    @ExceptionHandler(Exception.class)
    public String error(){
        return "/error";
    }

}
