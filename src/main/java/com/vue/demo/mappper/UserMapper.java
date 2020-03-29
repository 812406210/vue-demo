package com.vue.demo.mappper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vue.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    int deleteByPrimaryKey(Integer id);

    int insertUser(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUser(User user);


}