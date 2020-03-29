package com.vue.demo.service;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.vue.demo.entity.UserArticle;

import java.util.List;

/**
 * @author yangwj
 * @date 2020/3/28 10:08
 */

public interface UserArticleService {
    UserArticle getArticleByTitle(String title);

    UserArticle insertArticle(UserArticle userArticle);

    List<UserArticle> getAllArticles();

    DeleteResult delByName(String name);

    UpdateResult updateReadNumByTitle(String title);

    UpdateResult addUserComment(String title,String comment);

}
