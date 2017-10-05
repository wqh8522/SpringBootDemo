package com.wqh.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Hello {

    /*使用@Value注解读取配置文件信息*/
   /* @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private Integer age;
    @Value("${content}")
    private String content;*/

    /*自动注入对象*/
   @Autowired
   private Content content;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(@RequestParam(value = "id",defaultValue = "21212") Integer myid){
        return "id:"+myid;
//        return content.getCupSize()+"=="+content.getAge();
    }

    @RequestMapping(value = "testHello",method = RequestMethod.GET)
    public String testHello(){
        return "index";
    }
}
