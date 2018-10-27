package com.softech.bookstore.controllers;

import com.softech.bookstore.models.Book;
import com.softech.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("")
    public String list(ModelMap map){
        Iterable<Book> books = bookService.findAll();
        map.addAttribute("books", books);
        return "books/index";
    }

    //--------------find-----------------
    @RequestMapping(value = "/find")
    public String find(@RequestParam String title, ModelMap map){
        Iterable<Book> books = bookService.findBookByTitleContaining(title);
        if (books != null){
            map.addAttribute("books", books);
        }
        return "books/find";
    }

    //---------------delete------------
    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id){
        bookService.deleteById(id);
        return "redirect:/book";
    }


    @RequestMapping(value = "/show/{id}")
    public String detail(@PathVariable(name = "id") Long id, ModelMap map){
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()){
            map.addAttribute("book", book.get());
            return "books/detail";
        }
        return "redirect:";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newBook(ModelMap map){
        Book book = new Book();
        map.addAttribute("book", book);

        return "books/saveOrUpdate";
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public String saveOrUpdate(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/book";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable(name = "id") long id, ModelMap map){
        Optional<Book> book =bookService.findById(id);
        if(book.isPresent()){
            map.addAttribute("book", book);
            return "books/edit";
        }
        return "books/new";
    }
}
