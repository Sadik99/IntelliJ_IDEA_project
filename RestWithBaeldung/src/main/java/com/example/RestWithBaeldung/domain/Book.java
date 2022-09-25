package com.example.RestWithBaeldung.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String title,isbn;
}
