package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.service.IStudentService;

/**
 * (C) Copyright 2023 iHub Academy. All Rights Reserved.
 *
 * @author TrungDC
 * @version 1.0
 * @since 1/10/2024
 */
@Controller
@RequestMapping({"/student", ""})
public class StudentController { //bean

    @Autowired
    @Qualifier("studentServiceImpl")
    private IStudentService service;

    @GetMapping
    public String showList(Model model){
        model.addAttribute("studentList", service.findAll());
        return "list";
    }

    @GetMapping("/list")
    public String showList1(ModelMap model){
        model.addAttribute("studentList", service.findAll());
        return "list";
    }

    @GetMapping("/top")
    public ModelAndView showList2(){
        return new ModelAndView("list", "studentList", service.findAll());
    }
}