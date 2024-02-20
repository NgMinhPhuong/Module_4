package com.codegym.demo_springboot.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
public class LoginController {

//    @GetMapping("/login")
//    public String loginPage(@CookieValue(value = "username", defaultValue = "")String username,
//                            @CookieValue(value = "password", defaultValue = "")String password,
//                            Model model) {
//        model.addAttribute("username", username);
//        model.addAttribute("password", password);
//        return "loginPage";
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam("username")String username, @RequestParam("password")String password,
//                        @RequestParam(value = "remember-me", defaultValue = "false")Boolean rememberMe, HttpServletResponse http) {
//        // Login
//        if(rememberMe) {
//            Cookie cookieUsername = new Cookie("username", username);
//            Cookie cookiePassword = new Cookie("password", password);
//            cookieUsername.setMaxAge(3 * 24 * 60 * 60);
//            cookiePassword.setMaxAge(3 * 24 * 60 * 60);
//            http.addCookie(cookieUsername);
//            http.addCookie(cookiePassword);
//        }
//        return "redirect:/student";
//    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model, @RequestParam(value = "error", defaultValue = "")String error) {
        model.addAttribute("error", error);
        return "loginPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            UserDetails loginedUser = (UserDetails) ((Authentication) principal).getPrincipal();

            String message = "Hi " + principal.getName() //
                    + "<br>" + loginedUser.getUsername() + " do not have permission to access this page!";
            model.addAttribute("message", message);

        }
        return "403Page";
    }
}
