package com.codegym.practicesecurity.controller;

import com.codegym.practicesecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.PushBuilder;

@Controller
public class UserController {

    private AuthenticationManager authenticationManager;
    @Autowired
    public UserController(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/home")
    @PreAuthorize("hasAnyAuthority({'ROLE_ADMIN','ROLE_MEMBER'})")
    public String home(){
        return "/home";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String admin(){
        return "/admin";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model){
        boolean error = false;

        if(request.getParameter("error") != null){
            error = true;
        }
        model.addAttribute("error", error);
        return "/login";
    }

    @GetMapping("/error")
    public String error(){
        return "/403";
    }

    @PostMapping("/login")
    public void postLogin(@RequestParam("tendangnhap") String tk, @RequestParam("matkhau") String mk){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(tk,mk));
       SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
