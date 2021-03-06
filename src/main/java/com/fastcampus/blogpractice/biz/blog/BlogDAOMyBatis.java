package com.fastcampus.blogpractice.biz.blog;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogDAOMyBatis {

    @Autowired
    private SqlSessionTemplate mybatis;

    // CRUD 기능의 메소드
    public List<BlogVO> getBlogList(BlogVO vo) {
        return mybatis.selectList("BlogDAO.getBlogList", vo);
    }

    public void insertBlog(BlogVO vo) {
        mybatis.insert("BlogDAO.insertBlog", vo);
    }

    public BlogVO getBlog(BlogVO vo) {
        return mybatis.selectOne("BlogDAO.getBlog", vo);
    }

    public void updateBlog(BlogVO vo) {
        mybatis.update("BlogDAO.updateBlog", vo);
    }

    public void  blogDeleteRequest(BlogVO vo) {
        mybatis.update("BlogDAO.blogDeleteRequest", vo);
    }

    public void deleteBlog(int blogId) {
        mybatis.delete("BlogDAO.deleteBlog", blogId);
    }
}
