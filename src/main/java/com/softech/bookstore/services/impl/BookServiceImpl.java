package com.softech.bookstore.services.impl;

import com.softech.bookstore.models.Book;
import com.softech.bookstore.repositories.BookRepository;
import com.softech.bookstore.services.BookService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    public <S extends Book> S save(S s) {
        return bookRepository.save(s);
    }

    public <S extends Book> Iterable<S> saveAll(Iterable<S> itrbl) {
        return bookRepository.saveAll(itrbl);
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return bookRepository.existsById(id);
    }

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    public Iterable<Book> findAllById(Iterable<Long> itrbl) {
        return bookRepository.findAllById(itrbl);
    }

    public long count() {
        return bookRepository.count();
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public void delete(Book t) {
        bookRepository.delete(t);
    }

    public void deleteAll(Iterable<? extends Book> itrbl) {
        bookRepository.deleteAll(itrbl);
    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }

    @Override
    public Iterable<Book> findBookByTitleContaining(String title) {
        return bookRepository.findBookByTitleContaining(title);
    }

    @Override
    public void updateTitle(Long id, String title){
        try {
            Optional<Book> book = findById(id);
            if (book != null){
                book.get().setTitle(title);
                save(book.get());
            }

        }catch (Exception e){
            throw e;
        }
    }



}
