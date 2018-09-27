package com.a1704471.Bookstore.Bookstore.web;

import com.a1704471.Bookstore.Bookstore.domain.SignupForm;
import com.a1704471.Bookstore.Bookstore.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "signup")
    public String addUser(Model model){
        model.addAttribute("signupform", new SignupForm());
        return "signup";
    }
}
