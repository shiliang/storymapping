package com.nju.storymapping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StorymappingApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testPass() {
        String pass = "hello";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashPass = encoder.encode(pass);
        System.out.println(hashPass);
    }

}

