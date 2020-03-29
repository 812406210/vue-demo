package com.vue.demo.controller;

import com.vue.demo.entity.User;
import com.vue.demo.entity.requestparams.UserRequestParams;
import com.vue.demo.mappper.UserMapper;
import com.vue.demo.service.UserService;
import com.vue.demo.utils.ResponseResult;
import com.vue.demo.utils.Result;
import com.vue.demo.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangwj
 * @date 2020/3/27 21:38
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/getUserByNameAndPsw" ,method = RequestMethod.POST)
    @CrossOrigin
    public Result getUserByNameAndPsw(@RequestBody UserRequestParams params){
        User user =userService.selectByUser(params);
        if(user == null){
           return ResponseResult.error(ResultCodeEnum.USERNAME_PASSWORD_ERROR.getCode(),ResultCodeEnum.USERNAME_PASSWORD_ERROR.getMessage());
        }
        return ResponseResult.success();
    }

    @RequestMapping(value = "/getUserByName" ,method = RequestMethod.GET)
    @CrossOrigin
    public Result getUserByName(@RequestParam String userName){
        User userOne =userService.getUserByName(userName);
        if(userOne == null){
            return ResponseResult.error(ResultCodeEnum.USERNAME_PASSWORD_ERROR.getCode(),ResultCodeEnum.USERNAME_PASSWORD_ERROR.getMessage());
        }
        return ResponseResult.success();
    }

}
