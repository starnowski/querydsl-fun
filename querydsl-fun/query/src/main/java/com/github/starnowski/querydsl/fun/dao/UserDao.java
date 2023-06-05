package com.github.starnowski.querydsl.fun.dao;

import com.github.starnowski.querydsl.fun.model.Post;
import com.github.starnowski.querydsl.fun.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {

    public List<User> findAll()
    {
        //TODO
        return null;
    }

    public List<Post> findAllPostForUser(long userId)
    {
        //TODO
        return null;
    }
}
