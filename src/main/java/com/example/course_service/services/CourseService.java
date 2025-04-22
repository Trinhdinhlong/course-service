package com.example.course_service.services;

import com.example.course_service.models.Course;
import com.example.course_service.models.CourseLevel;
import com.example.course_service.repositorys.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> getByCategory(Long categoryId) {
        return courseRepository.findByCategoryId(categoryId);
    }

    public List<Course> getByLevel(CourseLevel level) {
        return courseRepository.findByLevel(level);
    }

    public Optional<Course> getById(Long id) {
        return courseRepository.findById(id);
    }


    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }
}
