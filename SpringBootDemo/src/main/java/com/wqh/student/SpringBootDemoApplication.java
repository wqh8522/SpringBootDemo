package com.wqh.student;

import com.wqh.student.dao.StudentDao;
import com.wqh.student.entity.Students;
import com.wqh.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication {

    @Autowired
    private StudentDao studentService;

    public void saveStu(){
        Students students = new Students();
        students.setAge(23);
        students.setMoney(34.3);
        students.setName("sdasd");
        Students students1 = new Students();
        students1.setAge(232);
        students1.setMoney(3423.3);
        students1.setName("sdasdasd");
        studentService.save(students);
        studentService.save(students1);
    }

	public static void main(String[] args) {

		SpringApplication.run(SpringBootDemoApplication.class, args);

	}
}
