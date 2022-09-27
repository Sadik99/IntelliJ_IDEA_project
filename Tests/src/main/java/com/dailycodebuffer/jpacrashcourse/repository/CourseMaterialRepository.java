package com.dailycodebuffer.jpacrashcourse.repository;

import com.dailycodebuffer.jpacrashcourse.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {
}
