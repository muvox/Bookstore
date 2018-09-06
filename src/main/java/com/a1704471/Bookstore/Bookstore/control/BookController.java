package com.a1704471.Bookstore.Bookstore.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class BookController {

    @GetMapping("/index")
    public String index(Model model){

        return "index";
    }
}
