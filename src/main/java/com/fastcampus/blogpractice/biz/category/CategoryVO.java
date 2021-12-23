package com.fastcampus.blogpractice.biz.category;

import lombok.Data;

@Data
public class CategoryVO {
    private int blogId;
    private int categoryId;
    private String categoryName;
    private String displayType;
    private int cntDisplayPost;
    private String description;
}
