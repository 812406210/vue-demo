package com.vue.demo.service.serviceimpl;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.vue.demo.entity.UserArticle;
import com.vue.demo.service.UserArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangwj
 * @date 2020/3/28 11:07
 */

@Service
public class UserArticleServiceImpl implements UserArticleService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UserArticle getArticleByTitle(String title) {
        Query query = new Query();
        query.addCriteria(Criteria.where("articleTitle").is(title));
        UserArticle article = mongoTemplate.findOne(query, UserArticle.class);
        return article;
    }

    @Override
    public UserArticle insertArticle(UserArticle userArticle) {
        List<UserArticle> userArticleList = mongoTemplate.findAll(UserArticle.class);
        if (userArticleList.isEmpty()) {
            userArticle.setId(1);
        } else {
            userArticle.setId(userArticleList.size() + 1);
        }
        UserArticle article = mongoTemplate.save(userArticle);
        return article;
    }

    @Override
    public List<UserArticle> getAllArticles() {
        List<UserArticle> userArticles = mongoTemplate.findAll(UserArticle.class);
        return userArticles;
    }

    @Override
    public DeleteResult delByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("articleTitle").is(name));
        DeleteResult result =mongoTemplate.remove(query,UserArticle.class);
        return result;
    }

    @Override
    public UpdateResult updateReadNumByTitle(String title) {
        Query query = new Query();
        query.addCriteria(Criteria.where("articleTitle").is(title));
        UserArticle article = mongoTemplate.findOne(query, UserArticle.class);
        Integer readNum = article.getReadNum() == null? 1: article.getReadNum()+1;
        article.setReadNum(readNum);
        Update update = new Update();
        update.set("readNum",article.getReadNum());
        UpdateResult result =  mongoTemplate.updateFirst(query,update,UserArticle.class);
        return result;
    }

    @Override
    public UpdateResult addUserComment(String title, String comment) {
        JSONObject jsonObject = new JSONObject();
        Query query = new Query();
        query.addCriteria(Criteria.where("articleTitle").is(title));
        UserArticle article = mongoTemplate.findOne(query, UserArticle.class);
        if(article.getComment() == null){
            jsonObject.put(title,comment);
        }else {
            jsonObject = (JSONObject) JSONObject.parse(article.getComment());
            jsonObject.put(title,comment);
        }
        Integer commentNum = article.getCommentNum() == null ? 1:article.getCommentNum()+1;
        Update update = new Update();
        update.set("comment",jsonObject.toJSONString());
        update.set("commentNum",commentNum);
        UpdateResult result =  mongoTemplate.updateFirst(query,update,UserArticle.class);
        return result;
    }
}
