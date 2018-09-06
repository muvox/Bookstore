package com.a1704471.Bookstore.Bookstore.control;

import com.a1704471.Bookstore.Bookstore.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @Autowired
    private BookRepository repo;

    @RequestMapping(value="/")
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/booklist")
    public String bookList(Model model){
        model.addAttribute("books", repo.findAll());
        return "booklist";
    }



}
