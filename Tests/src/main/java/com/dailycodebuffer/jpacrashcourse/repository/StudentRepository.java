package com.dailycodebuffer.jpacrashcourse.repository;

import com.dailycodebuffer.jpacrashcourse.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select s from Student s where s.email=?1")
//JPQL
    Student getStudentByEmailAddress(String email);

    @Query("select s.firstName from Student s where s.email=?1")
//JPQL
    String getStudentFirstNameByEmailAddress(String email);

    @Query(value = "select * from tbl_student s where s.email_address=?1", nativeQuery = true)
    Student getStudentByEmailAddressNative(String email);

    @Query(value = "select * from tbl_student s where s.email_address=:email", nativeQuery = true)
    Student getStudentByEmailAddressNativeNameParam(@Param("email") String email);
    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name=?1 where email_address=?2",
            nativeQuery = true)
    int updateStudentNameByEmailId(String firstname,String email);
}
