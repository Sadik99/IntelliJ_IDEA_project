package com.dailycodebuffer.jpacrashcourse.repository;

import com.dailycodebuffer.jpacrashcourse.entity.Guardian;
import com.dailycodebuffer.jpacrashcourse.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student=Student.builder()
                .email("sakib@gamil.com")
                .firstName("Sakib")
                .lastName("Hassan")
                //.guardianName("Adam")
                //.guardianEmail("adam@gmail.com")
                //.guardianMobile("12222222223")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian=Guardian.builder()
                .email("nannu@yahool.com")
                .name("Nannu")
                .mobile("01035473820").build();
        Student student=Student.builder()
                .firstName("Shamim")
                .email("shamim@gmail.com")
                .lastName("Khan")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }
    @Test
    public void printAllStudent(){
        List<Student>studentList=studentRepository.findAll();
        System.out.println("studentList:  "+studentList);
    }
    @Test
    public void printStudentByFirstName(){
        List<Student>students=studentRepository.findByFirstName("Sakib");
        System.out.println("Students: "+students);
    }
    @Test
    public void printStudentByFirstNameContaining(){
        List<Student>students=studentRepository.findByFirstNameContaining("S");
        System.out.println("Students: "+students);
    }
    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students=studentRepository.findByGuardianName("Nannu");
        System.out.println("Guardian Name: "+students);
    }
    @Test
    public void printgetStudentByEmailAddress(){
        Student student=studentRepository.getStudentByEmailAddress("sakib@gamil.com");
        System.out.println("Email :"+student);
    }
    @Test
    public void printgetStudentFirstNameByEmailAddress(){
        String firstName=studentRepository.getStudentFirstNameByEmailAddress("shamim@gmail.com");
        System.out.println("Firstname: "+firstName);
    }
    @Test
    public void getStudentByEmailAddressNative(){
        Student student=studentRepository.getStudentByEmailAddressNative("shamim@gmail.com");
        System.out.println("Native.Q in Email: "+student);
    }
    @Test
    public void getStudentByEmailAddressNativeNameParam(){
        Student student=studentRepository.getStudentByEmailAddressNativeNameParam("shamim@gmail.com");
        System.out.println("Native.Q in Email: "+student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("Shakib","sakib@gamil.com");
    }
}