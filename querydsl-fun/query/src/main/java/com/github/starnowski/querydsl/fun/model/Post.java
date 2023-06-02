package com.github.starnowski.querydsl.fun.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String body;

    @ManyToOne
    private User user;
}
