package com.vue.demo.service.serviceimpl;

import com.vue.demo.entity.User;
import com.vue.demo.entity.requestparams.UserRequestParams;
import com.vue.demo.mappper.UserMapper;
import com.vue.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangwj
 * @date 2020/3/28 9:31
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByUser(UserRequestParams params) {
        User user = new User();
        user.setUserName(params.getUserName());
        user.setPassword(params.getPassword());
        User userOne = userMapper.selectByUser(user);
        return userOne;
    }

    @Override
    public User getUserByName(String userName) {
        User u = new User();
        u.setUserName(userName);
        User userOne = userMapper.selectByUser(u);
        return userOne;
    }
}
