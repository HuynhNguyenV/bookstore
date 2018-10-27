package com.softech.bookstore.repositories;

import com.softech.bookstore.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

    Iterable<Book> findBookByTitleContaining(String title);
}
