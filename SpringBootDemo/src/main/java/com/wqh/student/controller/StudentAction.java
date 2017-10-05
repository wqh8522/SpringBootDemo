package com.wqh.student.controller;


import com.wqh.student.Utils.ResultUtil;
import com.wqh.student.dao.StudentDao;
import com.wqh.student.entity.ResponseResult;
import com.wqh.student.entity.Students;
import com.wqh.student.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/studentAction")
public class StudentAction {

    /** 打印日志 */
    private final static Logger logger = LoggerFactory.getLogger(StudentAction.class);

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StudentService studentService;

    /**
     * 查询所有学生
     * @return
     */
    @GetMapping(value = "/list")
    public List<Students> list(){
        logger.info("学生={}",studentDao.findAll());
        return studentDao.findAll();
    }

    /**
     * 添加学生
     * @param name
     * @param age
     * @return
     */

    @PostMapping(value = "/saveStudent")
    public Students saveStudent(@RequestParam("name") String name,
                                @RequestParam("age") Integer age){
        Students students = new Students();
        students.setName(name);
        students.setAge(age);
        return studentDao.save(students);
    }

    /**
     * 添加学生  @Valid 验证该对象
     * @param students 自动封装对象
     * @param bindingResult 返回验证的结果
     * @return
     */
    @PostMapping(value = "/save")
    public ResponseResult save(@Valid  Students students, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
//            logger.info(bindingResult.getFieldError().getDefaultMessage());
        return ResultUtil.error(0,bindingResult.getFieldError().getDefaultMessage());
    }
        return ResultUtil.success(studentDao.save(students));
    }

    @PostMapping(value = "/saveTestTran")
    public void saveTestTran(){
//        this.studentService.saveStus();

    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping(value = "/findStuById/{id}")
    public Students findStuById(@PathVariable("id") String id){
        return this.studentDao.findOne(id);
    }

    @GetMapping(value = "/getage/{id}")
    public void getAge(@PathVariable("id") String id) throws Exception {
        studentService.getAge(id);
    }
    /**
     * 根据年龄查询
     * @param age
     * @return
     */
    @RequestMapping(value = "/findByAge/{age}")
    public List<Students> findByAge(@PathVariable("age") Integer age){
        return this.studentDao.findByAge(age);
    }

    /**
     * 插如数据
     * @param students
     * @return
     */
    @PutMapping(value = "/update")
    public Students update(Students students){
        //更新也是使用save方法，首先会根据id查询，如果没有则会直接插入
        return  this.studentDao.save(students);
    }

    /**
     * 根据id删除
     * @param id
     */
    @DeleteMapping(value = "/del/{id}")
    public void deleteById(@PathVariable("id") String id){
        this.studentDao.delete(id);
    }
}
