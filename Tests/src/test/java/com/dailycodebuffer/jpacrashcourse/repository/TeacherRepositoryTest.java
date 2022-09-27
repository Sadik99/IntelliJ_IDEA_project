package com.dailycodebuffer.jpacrashcourse.repository;

import com.dailycodebuffer.jpacrashcourse.entity.Course;
import com.dailycodebuffer.jpacrashcourse.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void saveTeacher(){
        Course course1 =Course.builder().title("DBA").credit(3).build();
        Course course2 =Course.builder().title("Java").credit(3).build();
        Teacher teacher=Teacher.builder().firstName("Atiq")
                .lastName("Khan")//.courses(List.of(course1,course2))
                .build();

        teacherRepository.save(teacher);
    }
}