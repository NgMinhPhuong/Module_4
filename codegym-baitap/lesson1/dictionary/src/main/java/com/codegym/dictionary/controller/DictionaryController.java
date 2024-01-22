package com.codegym.dictionary.controller;

import com.codegym.dictionary.service.IWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {
    IWorkService iWorkService;
    @Autowired
    public DictionaryController(IWorkService iWorkService){
        this.iWorkService = iWorkService;
    }

    @GetMapping("dictionary")
    public ModelAndView dictor(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @ResponseBody
    @PostMapping ("dictionary")
    public String dictor(@RequestParam String word){
        return iWorkService.get(word);    }
}
