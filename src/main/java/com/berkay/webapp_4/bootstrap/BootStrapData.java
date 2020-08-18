package com.berkay.webapp_4.bootstrap;

import com.berkay.webapp_4.domain.Author;
import com.berkay.webapp_4.domain.Book;
import com.berkay.webapp_4.domain.Publisher;
import com.berkay.webapp_4.repositories.AuthorRepository;
import com.berkay.webapp_4.repositories.BookRepository;
import com.berkay.webapp_4.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Spring App Basladı...");

        Publisher zambak = new Publisher();
        zambak.setName("Zambak");
        zambak.setCity("Istanbul");
        zambak.setState("Kadıkoy");

        publisherRepository.save(zambak);

        Author beko = new Author("berkay","Coskun");
        Book unic = new Book("Beceri kitabı", "123123");

        beko.getBooks().add(unic);
        unic.getAuthors().add(beko);
        unic.setPublisher(zambak);

        authorRepository.save(beko);
        bookRepository.save(unic);

        System.out.println("book sayısı --> " + bookRepository.count() );
        System.out.println("Beceri kİTABININ YAYINCISI ---> " + unic.getPublisher().getName());
        System.out.println("Yayıncı sayısı--->" + publisherRepository.count());

    }
}
