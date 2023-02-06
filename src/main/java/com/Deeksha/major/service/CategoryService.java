package com.Deeksha.major.service;

import com.Deeksha.major.Repository.CategoryRepository;
import com.Deeksha.major.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteBYId(Integer id) {
        categoryRepository.deleteById(id);
    }

    public Optional<Category> getCategoryByid(Integer id) {
        return categoryRepository.findById(id);
    }
}
