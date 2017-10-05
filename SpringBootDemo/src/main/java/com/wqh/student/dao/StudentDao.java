package com.wqh.student.dao;

import com.wqh.student.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDao extends JpaRepository<Students,String> {

    /**
     * 根据年龄查询
     * @param age
     * @return
     */
    List<Students> findByAge(Integer age);
 }
