package com.wqh.student.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @Author wqh
 * @Date 2017/10/05 14:33
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentActionTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * MockMvcResultMatchers.status().isOk():验证返回的状态码
     * MockMvcResultMatchers.content().string("ww")：验证返回的结果
     * @throws Exception
     */
    @Test
    public void save() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/studentAction/save")
                                                .param("name","wqh")
                                                .param("age","50")
                                                .param("money","132"))//添加参数
                .andExpect(MockMvcResultMatchers.status().isOk())//返回状态码为200
                .andDo(print())//打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();//将返回信息转化为String类型
//                .andExpect(MockMvcResultMatchers.content().string("ww"));//返回结果必须是ww
    }

}