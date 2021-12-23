package com.fastcampus.blogpractice.biz.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostDAO postDAO;

    public List<PostVO> getPostList(PostVO vo) {
        return postDAO.getPostList(vo);
    }

    public PostVO getPost(PostVO vo) {
        return postDAO.getPost(vo);
    }

    public void deletePost(PostVO vo) {
        postDAO.deletePost(vo);
    }

    public void insertPost(PostVO vo) {
        postDAO.insertPost(vo);
    }

    public void updatePost(PostVO vo) {
        postDAO.updatePost(vo);
    }
}
