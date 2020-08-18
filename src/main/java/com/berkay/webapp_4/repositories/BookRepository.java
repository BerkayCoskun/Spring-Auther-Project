package com.berkay.webapp_4.repositories;

import com.berkay.webapp_4.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
