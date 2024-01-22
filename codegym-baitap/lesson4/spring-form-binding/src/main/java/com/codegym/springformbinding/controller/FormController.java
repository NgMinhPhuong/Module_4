package com.codegym.springformbinding.controller;

import com.codegym.springformbinding.model.Form;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/form")
public class FormController {

    @GetMapping("/get")
    public String select(@ModelAttribute("form") Form form, Model model, @RequestParam(required = false) String message){
        model.addAttribute("form", new Form("Vietnamese","2",true,"thor"));
        return "/index";
    }

    @PostMapping("/get")
    public String show(@ModelAttribute("form") Form form,
                       @RequestParam String language, @RequestParam String size, Model model){
        form.setSize(size);
        form.setLanguage(language);
        model.addAttribute("message" , "123");
        model.addAttribute("form" , form);

        return "/index";
    }
}
