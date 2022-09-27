package com.dailycodebuffer.jpacrashcourse.repository;

import com.dailycodebuffer.jpacrashcourse.entity.Course;
import com.dailycodebuffer.jpacrashcourse.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;
    @Test
    public void SaveCourseMaterial(){
        Course course= Course.builder().title(".net").credit(4).build();
        CourseMaterial courseMaterial= CourseMaterial.builder().url("https://spring.io/blog").
                course(course).
                build();
        courseMaterialRepository.save(courseMaterial);
    }
    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> courseMaterials=courseMaterialRepository.findAll();
        System.out.println("Course Material: "+courseMaterials);
    }



}