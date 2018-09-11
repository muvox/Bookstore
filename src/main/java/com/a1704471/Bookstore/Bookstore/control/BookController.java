package com.a1704471.Bookstore.Bookstore.control;

import com.a1704471.Bookstore.Bookstore.BookRepository;
import com.a1704471.Bookstore.Bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired
    private BookRepository repo;

    public Book findBook(long id){
        return repo.findById(id).get();
    }

    @RequestMapping(value="/booklist")
    public String bookList(Model model){
        model.addAttribute("books", repo.findAll());
        return "booklist";
    }

    @RequestMapping(value= "/add")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(Book book){
        repo.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model){
        repo.deleteById(bookId);
        return "redirect:../booklist";
    }

    @RequestMapping(value ="/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model){
       Book book = findBook(bookId);
       model.addAttribute("book", book);
       return "editBook";
    }


}
