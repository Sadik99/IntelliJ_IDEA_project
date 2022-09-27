package com.dailycodebuffer.jpacrashcourse.repository;

import com.dailycodebuffer.jpacrashcourse.entity.Course;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course>findByTitleContaining(String title, Pageable pageable);
}
