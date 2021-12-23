package com.fastcampus.blogpractice.biz.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    public List<CategoryVO> getCategoryList(CategoryVO vo) {
        return categoryDAO.getCategoryList(vo);
    }

    public void insertCategory(CategoryVO vo) {
        categoryDAO.insertCategory(vo);
    }

    public CategoryVO getCategory(CategoryVO vo) {
        return categoryDAO.getCategory(vo);
    }

    public void updateCategory(CategoryVO vo) {
        categoryDAO.updateCategory(vo);
    }

    public void deleteCategory(int categoryId) {
        categoryDAO.deleteCategory(categoryId);
    }
}
