package com.fastcampus.blogpractice.biz.post;

import com.fastcampus.blogpractice.biz.common.JDBCUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostDAO {
    // JDBC 관련 변수
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    // SQL 명령어들
    private String POST_LIST = "";
    private String POST_LIST_CATEGORY = "";
    private String POST_DELETE = "";
    private String POST_INSERT = "";
    private String POST_GET = "";
    private String POST_UPDATE = "";

    public void insertPost(PostVO vo) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(POST_INSERT);
            stmt.setInt(1, vo.getBlogId());
            stmt.setInt(2, vo.getCategoryId());
            stmt.setString(3, vo.getTitle());
            stmt.setString(4, vo.getContent());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public List<PostVO> getPostList(PostVO vo) {
        List<PostVO> postList = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            if(vo.getCategoryId() != 0) {
                stmt = conn.prepareStatement(POST_LIST_CATEGORY);
                stmt.setInt(1, vo.getBlogId());
                stmt.setInt(2, vo.getCategoryId());
            } else {
                stmt = conn.prepareStatement(POST_LIST);
                stmt.setInt(1, vo.getBlogId());
            }

            rs = stmt.executeQuery();

            while(rs.next()) {
                PostVO post = new PostVO();
                post.setBlogId(rs.getInt("BLOG_ID"));
                post.setCategoryId(rs.getInt("CATEGORY_ID"));
                post.setContent(rs.getString("CONTENT"));
                post.setPostId(rs.getInt("POST_ID"));
                post.setCreateDate(rs.getDate("CREATE_DATE"));
                post.setTitle(rs.getString("TITLE"));
                postList.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return postList;
    }

    public void deletePost(PostVO vo) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(POST_DELETE);
            stmt.setInt(1, vo.getPostId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public PostVO getPost(PostVO vo) {
        PostVO post = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(POST_GET);
            stmt.setInt(1, vo.getPostId());
            rs = stmt.executeQuery();
            if(rs.next()) {
                post = new PostVO();
                post.setBlogId(rs.getInt("BLOG_ID"));
                post.setCategoryId(rs.getInt("CATEGORY_ID"));
                post.setContent(rs.getString("CONTENT"));
                post.setPostId(rs.getInt("POST_ID"));
                post.setCreateDate(rs.getDate("CREATE_DATE"));
                post.setTitle(rs.getString("TITLE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return post;
    }

    public void updatePost(PostVO vo) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(POST_UPDATE);
            stmt.setInt(1, vo.getPostId());
            stmt.setInt(2, vo.getCategoryId());
            stmt.setString(3, vo.getTitle());
            stmt.setString(4, vo.getContent());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
    }
}
