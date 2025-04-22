package com.example.course_service.controllers;

import com.example.course_service.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.course_service.models.CourseCategory;

import java.util.List;

@RestController
@RequestMapping("api/courses/categories")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CourseCategory>> getAll() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
