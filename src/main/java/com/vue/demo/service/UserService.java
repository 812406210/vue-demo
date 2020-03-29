package com.vue.demo.service;

import com.vue.demo.entity.User;
import com.vue.demo.entity.requestparams.UserRequestParams;

/**
 * @author yangwj
 * @date 2020/3/28 9:31
 */
public interface UserService {
    User selectByUser(UserRequestParams params);

    User getUserByName(String userName);

}
