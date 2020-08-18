package com.berkay.webapp_4.repositories;

import com.berkay.webapp_4.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
