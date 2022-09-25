package com.example.RestWithBaeldung;

import com.example.RestWithBaeldung.domain.Book;
import com.example.RestWithBaeldung.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class RestWithBaeldungApplication {
    @Autowired
    private BookRepository bookRepository;
    @Component
    class DataSetup implements ApplicationRunner{
        @Override
        public void run(ApplicationArguments args) throws Exception {
            bookRepository.save(Book.builder().title("CP3").isbn("1221").build());
            bookRepository.save(Book.builder().title("Cp Handbook").isbn("1222").build());
        }
    }
    public static void main(String[] args) {
        SpringApplication.run(RestWithBaeldungApplication.class, args);
    }
}
