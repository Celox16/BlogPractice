package com.fastcampus.blogpractice.biz.user;

import lombok.Data;

// BLOG_USER 테이블과 매핑되는 객체
@Data
public class UserVO {
    private int userId;
    private String id;
    private String userName;
    private String role;
    private  String password;
}
