package com.wqh.student.service;

import com.wqh.student.dao.StudentDao;
import com.wqh.student.entity.Students;
import com.wqh.student.enums.ResultEnum;
import com.wqh.student.exception.StudentExceprion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * 测试事务
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public void saveStus(Students student){
        studentDao.save(student);

    }

    public void getAge(String id) throws Exception {
        Students stu = studentDao.findOne(id);
        if(stu.getAge()<10){
            //抛出自定义异常
            throw new StudentExceprion(ResultEnum.PRIMARY_ERROR);
        }else if (stu.getAge()>10 && stu.getAge()<15){
            throw new StudentExceprion(ResultEnum.MIDDLE_ERROR);
        }else{
            throw new StudentExceprion(ResultEnum.WORK_ERROR);
        }
    }


}
