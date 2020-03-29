package com.vue.demo.controller;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.vue.demo.entity.UserArticle;
import com.vue.demo.service.UserArticleService;
import com.vue.demo.utils.ResponseResult;
import com.vue.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yangwj
 * @date 2020/3/28 10:16
 */
@RestController
public class UserArticleController {

    @Autowired
    private UserArticleService userArticleService;

    @RequestMapping("/getArticleByTitle")
    @CrossOrigin
    public Result getArticleByTitle(String title) {
        UserArticle userArticle = userArticleService.getArticleByTitle(title);
        return ResponseResult.success(userArticle);
    }

    @RequestMapping("/insertArticle")
    @CrossOrigin
    public Result insertArticle(@RequestBody UserArticle userArticle) {
        UserArticle article = userArticleService.insertArticle(userArticle);
        return ResponseResult.success(article);
    }

    @RequestMapping(value = "/getAllArticle",method = RequestMethod.GET)
    @CrossOrigin
    public Result getAllArticle() {
        List<UserArticle> articles = userArticleService.getAllArticles();
        return ResponseResult.success(articles);
    }

    @RequestMapping(value = "/delByName",method = RequestMethod.GET)
    @CrossOrigin
    public Result delByName(String articleName) {
        DeleteResult result = userArticleService.delByName(articleName);
        return ResponseResult.success(result);
    }


    @RequestMapping(value = "/updateReadNumByTitle",method = RequestMethod.GET)
    @CrossOrigin
    public Result updateReadNumByTitle(String title) {
        UpdateResult result = userArticleService.updateReadNumByTitle(title);
        return ResponseResult.success(result);
    }

    @RequestMapping(value = "/addUserComment",method = RequestMethod.GET)
    @CrossOrigin
    public Result addUserComment(String title,String comment) {
        UpdateResult result = userArticleService.addUserComment(title,comment);
        return ResponseResult.success(result);
    }







}
