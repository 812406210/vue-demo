package com.vue.demo.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author yangwj
 * @date 2020/3/28 10:03
 */
@Data
public class UserArticle {
    @Id
    @TableId(type = IdType.AUTO)
    private Integer id;   //id
    private String userName; // 用户名
    private String articleTitle; //标题
    private String articleType; //标题类型
    private String createTime;   //发布时间
    private String articleContent; //内容
    private String publishState;   //发布状态
    private Integer commentNum; //评论数
    private Integer readNum;  //阅读数
    private String comment;  //其他用户的评论
}
