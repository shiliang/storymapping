package com.nju.storymapping;

import com.nju.storymapping.utility.Status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StorymappingApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void ts() {
        Status status = Status.COMPLETED;
        int index = status.getIndex();
        System.out.println("完成");
        System.out.println(index);
    }



}

