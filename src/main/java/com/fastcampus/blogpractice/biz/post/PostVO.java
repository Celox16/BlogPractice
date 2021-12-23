package com.fastcampus.blogpractice.biz.post;

import lombok.Data;

import java.sql.Date;

@Data
public class PostVO {
    private int postId;
    private int blogId;
    private int categoryId;
    private  String title;
    private String content;
    private Date createDate;
    private int cntDisplayPost;
}
