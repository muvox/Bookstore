package com.a1704471.Bookstore.Bookstore.web;

import com.a1704471.Bookstore.Bookstore.domain.SignupForm;
import com.a1704471.Bookstore.Bookstore.domain.User;
import com.a1704471.Bookstore.Bookstore.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "signup")
    public String addUser(Model model){
        model.addAttribute("signupform", new SignupForm());
        return "signup";
    }

    @RequestMapping(value = "saveuser", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            String pwd = signupForm.getPassword();
            BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
            String hashPwd = bc.encode(pwd);

            User newUser = new User();
            newUser.setPasswordHash(hashPwd);
            newUser.setUsername(signupForm.getUsername());

            //for easy creation of admin user
            String def = "jomppa";
            if(newUser.getUsername().equals(def))
                newUser.setRole("ADMIN");
            else
                newUser.setRole("USER");


            if(repository.findByUsername(signupForm.getUsername()) == null) {
                System.out.println("Creating user with user name: "+newUser.getUsername()+" and role: "+newUser.getRole());
                repository.save(newUser);
            } else {
                bindingResult.rejectValue("username", "err.username", "Username already exists!");
                return "signup";
            }
        } else {
            bindingResult.rejectValue("passwordCheck","err.passCheck", "Password does not match");
            return "signup";
        }
        return "redirect:/login";
    }
}
