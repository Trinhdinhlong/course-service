package com.example.course_service.repositorys;

import com.example.course_service.models.Course;
import com.example.course_service.models.CourseLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCategoryId(Long categoryId);
    List<Course> findByLevel(CourseLevel level);
}
