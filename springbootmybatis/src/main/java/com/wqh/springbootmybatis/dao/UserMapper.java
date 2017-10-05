package com.wqh.springbootmybatis.dao;

import com.wqh.springbootmybatis.domain.UserEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author wqh
 * @Date 2017/10/03 17:35
 * @Description:
 */
public interface UserMapper {
    @Select("select * from users")
    public List<UserEntity> findAll();
}
