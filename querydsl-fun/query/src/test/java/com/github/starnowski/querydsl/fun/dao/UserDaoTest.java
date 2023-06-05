package com.github.starnowski.querydsl.fun.dao;

import com.github.starnowski.querydsl.fun.model.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static com.github.starnowski.querydsl.fun.Application.CLEAR_DATABASE_SCRIPT_PATH;
import static com.github.starnowski.querydsl.fun.Application.ITEMS_SCRIPT_PATH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;
import static org.springframework.test.context.jdbc.SqlConfig.TransactionMode.ISOLATED;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(value = CLEAR_DATABASE_SCRIPT_PATH,
        config = @SqlConfig(transactionMode = ISOLATED),
        executionPhase = BEFORE_TEST_METHOD)
@Sql(value = CLEAR_DATABASE_SCRIPT_PATH,
        config = @SqlConfig(transactionMode = ISOLATED),
        executionPhase = AFTER_TEST_METHOD)
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void findAllUsers(){
        //TODO
        System.out.println("findAllUsers");
    }

    @Test
    @Sql(value = {CLEAR_DATABASE_SCRIPT_PATH, ITEMS_SCRIPT_PATH},
            config = @SqlConfig(transactionMode = ISOLATED),
            executionPhase = BEFORE_TEST_METHOD)
    public void findAllPostForUser() {
        // GIVEN
        long userId = 1L;

        // WHEN
        List<Post> posts = userDao.findAllPostForUser(userId);

        // THEN
        assertThat(posts).hasSize(1);
        assertThat(posts.stream().findFirst().get().getId()).isEqualTo(8L);
    }
}