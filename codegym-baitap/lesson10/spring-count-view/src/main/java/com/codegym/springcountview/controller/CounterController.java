package com.codegym.springcountview.controller;

import com.codegym.springcountview.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("counter")
public class CounterController {
    @GetMapping("/delete")
    public String deleteSession(HttpServletResponse response, HttpServletRequest request, SessionStatus sessionStatus){
//        request.getSession().invalidate();
        sessionStatus.setComplete();
//        Cookie cookie = new Cookie("JSESSIONID", "");
//        cookie.setMaxAge(0);
//        response.addCookie(cookie);
        return "/index";
    }

    @ModelAttribute("counter")
    public Counter setUpCounter() {
        return new Counter();
    }

    @GetMapping
    public String get(@ModelAttribute("counter") Counter counter) {
        counter.increment();
        return "/index";
    }
}