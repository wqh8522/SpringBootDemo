package com.wqh.springbootmybatis.dao;

import com.wqh.springbootmybatis.domain.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author wqh
 * @Date 2017/10/03 17:49
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll() throws Exception {
        List<UserEntity> all = userMapper.findAll();
        for(UserEntity u :all){
            System.out.println(u);
        }
    }

}