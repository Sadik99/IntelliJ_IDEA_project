package com.example.review;

import com.example.review.Review;
import com.example.course.CourseRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {
}
