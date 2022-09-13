package com.example.course;

import com.example.core.BaseEntity;
import com.example.review.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface CourseRepository extends PagingAndSortingRepository<Course,Long> {
    @RestResource(rel = "title-contains",path = "containsTitle")
    Page<Course> findByTitleContaining(@Param("title")String title, Pageable page);
}
