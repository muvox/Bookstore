package com.a1704471.Bookstore.Bookstore;

import com.a1704471.Bookstore.Bookstore.web.BookController;
import com.a1704471.Bookstore.Bookstore.web.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

    @Autowired
    private BookController bookController;

    @Autowired
    private UserController userController;

    @Test
    public void contextLoads() throws Exception{
        assertThat(bookController).isNotNull();
        assertThat(userController).isNotNull();

    }
}
