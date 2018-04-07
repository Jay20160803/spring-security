package com.jk51.springsecurity;

import com.jk51.springsecurity.DAO.User;
import com.jk51.springsecurity.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringSecurityApplication.class)
public class SpringSecurityApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() throws SQLException {

       User user =  userMapper.findByUserName("jay");
    }

}
