package com.wqh.student.service;

import com.wqh.student.entity.Students;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author wqh
 * @Date 2017/10/05 14:22
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void saveStus() throws Exception {

        Students student = new Students();
        student.setAge(155);
        student.setName("wqeqwasd");
        student.setMoney(13d);
        studentService.saveStus(student);

    }

    @Test
    public void getAge() throws Exception {
        studentService.getAge("22");
    }

}