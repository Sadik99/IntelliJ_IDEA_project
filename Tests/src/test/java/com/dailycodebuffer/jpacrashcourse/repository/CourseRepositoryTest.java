package com.dailycodebuffer.jpacrashcourse.repository;

import com.dailycodebuffer.jpacrashcourse.entity.Course;
import com.dailycodebuffer.jpacrashcourse.entity.Student;
import com.dailycodebuffer.jpacrashcourse.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void printCourses(){
        List<Course>courses=courseRepository.findAll();
        System.out.println("Courses: "+courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher= Teacher.builder().firstName("Jalil").lastName("Shah").build();
        Course course= Course.builder().title("Python").credit(3).teacher(teacher).build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecord=PageRequest.of(0,3);
        Pageable secondPageWithThreeRecord=PageRequest.of(1,2);
        List<Course> courses=
                courseRepository.findAll(firstPageWithThreeRecord).getContent();
        long totalElements=courseRepository.findAll(firstPageWithThreeRecord).getTotalElements();
        int totalPages=courseRepository.findAll(firstPageWithThreeRecord).getTotalPages();
        System.out.println("Total Pages: "+totalPages);
        System.out.println("Total Elements: "+totalElements);
        System.out.println("Courses: "+courses);


    }
    @Test
    public void findAllSorting(){
        Pageable sortByTitle=PageRequest.of(0,2,Sort.by("title"));
        Pageable sortByCreditDesc=PageRequest.of(0,2,Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc=PageRequest.of(0,2,Sort.by("title").descending().and(Sort.by("credit")));
        List<Course>courses=courseRepository.findAll(sortByTitle).getContent();
        System.out.println("Sort By Title: "+courses);
    }
    @Test
    public void printfindByTitleContaining(){
        Pageable firstPageTitleRecords= PageRequest.of(0,10);
        List<Course> courses=courseRepository.findByTitleContaining("D",firstPageTitleRecords);
        System.out.println("Seaching pages: "+ courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher=Teacher.builder().firstName("Tanvir").lastName("Ahmed").build();
        Student student= Student.builder().firstName("Rafayeat").lastName("Khan").email("raf@gmail.com").build();
        Course course= Course.builder().title("AI").credit(4).teacher(teacher).build();
        course.addStudents(student);
        courseRepository.save(course);
    }
}