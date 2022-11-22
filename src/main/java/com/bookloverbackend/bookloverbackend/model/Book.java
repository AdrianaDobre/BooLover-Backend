package com.bookloverbackend.bookloverbackend.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @NotNull
    @Column(unique=true)
    private String title;

    @NotNull
    private String author;

    @NotNull
    private String category;

    @NotNull
    private String description;
}
