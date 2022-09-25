package com.example.RestWithBaeldung.repo;

import com.example.RestWithBaeldung.domain.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "books",collectionResourceRel = "books")
public interface BookRepository extends PagingAndSortingRepository<Book,Long> {

}
