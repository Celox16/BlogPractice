package com.fastcampus.blogpractice.controller;

import com.fastcampus.blogpractice.biz.blog.BlogVO;
import com.fastcampus.blogpractice.biz.category.CategoryService;
import com.fastcampus.blogpractice.biz.category.CategoryVO;
import com.fastcampus.blogpractice.biz.post.PostService;
import com.fastcampus.blogpractice.biz.post.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("deletePost.do")
    public String deletePost(PostVO postVO) {
        postService.deletePost(postVO);

        return "forward:/blogMain.do";
    }

    @RequestMapping("/adminPost.do")
    public String adminPost(PostVO postVO, CategoryVO categoryVO, Model model, HttpSession session) {
        String postFlag = "insertPost";

        model.addAttribute("postFlag", "insertPost");
        if(categoryVO.getBlogId() == 0) {
            BlogVO blog = (BlogVO) session.getAttribute("blog");
            categoryVO.setBlogId(blog.getBlogId());
        }

        List<CategoryVO> categoryList = categoryService.getCategoryList(categoryVO);
        model.addAttribute("categoryList", categoryList);

        if(postVO.getPostId() !=  0) {
            postFlag = "updatePost";

            PostVO post = postService.getPost(postVO);
            model.addAttribute("post", post);
        }

        model.addAttribute("postFlag", postFlag);

        return "adminPost";
    }

    @RequestMapping("/insertPost.do")
    public String insertPost(PostVO postVO, Model model) {
        postService.insertPost(postVO);

        return "forward:/blogMain.do";
    }

    @RequestMapping("/updatePost.do")
    public String updatePost(PostVO postVO, Model model) {
        postService.updatePost(postVO);

        return "forward:/blogMain.do";
    }
}
