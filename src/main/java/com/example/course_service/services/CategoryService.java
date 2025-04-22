package com.example.course_service.services;

import com.example.course_service.repositorys.CategoryRepository;
import com.example.course_service.models.CourseCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.course_service.models.CourseCategory;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CourseCategory> getAllCategories() {
        return categoryRepository.findAll();
    }
}
