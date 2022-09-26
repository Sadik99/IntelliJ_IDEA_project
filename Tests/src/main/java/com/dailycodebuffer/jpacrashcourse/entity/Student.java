package com.dailycodebuffer.jpacrashcourse.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="tbl_student",uniqueConstraints =@UniqueConstraint(name = "email_unique",columnNames = "email_address"))
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence",sequenceName = "student_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_sequence")
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(name = "email_address",nullable = false)
    private String email;
    @Embedded
    private Guardian guardian;
}
