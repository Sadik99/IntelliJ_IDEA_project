package com.dailycodebuffer.jpacrashcourse.repository;

import com.dailycodebuffer.jpacrashcourse.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
