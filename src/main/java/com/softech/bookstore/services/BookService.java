package com.softech.bookstore.services;

import com.softech.bookstore.models.Book;
import java.util.Optional;

public interface BookService {

    long count();

    void delete(Book t);

    void deleteAll();

    void deleteAll(Iterable<? extends Book> itrbl);

    void deleteById(Long id);

    boolean existsById(Long id);

    Iterable<Book> findAll();

    Iterable<Book> findAllById(Iterable<Long> itrbl);

    Optional<Book> findById(Long id);

    <S extends Book> S save(S s);

    <S extends Book> Iterable<S> saveAll(Iterable<S> itrbl);

    Iterable<Book> findBookByTitleContaining(String title);

    void updateTitle(Long id, String title);
}
