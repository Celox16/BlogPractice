package com.fastcampus.blogpractice.biz.blog;

import lombok.Data;

@Data
public class BlogVO {
    private int blogId;
    private String title;
    private String tag;
    private int cntDisplayPost;
    private String status;
    private int userId;

    // 검색을 위한 변수
    private String searchCondition;
    private String searchKeyword;
    private String userName;
}
