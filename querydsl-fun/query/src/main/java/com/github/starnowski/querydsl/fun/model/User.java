package com.github.starnowski.querydsl.fun.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "user_info")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String login;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    private Set<Post> posts = new HashSet<>(0);
}