package com.example.course_service.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.course_service.models.CourseCategory;
@Repository
public interface CategoryRepository extends JpaRepository<CourseCategory, Long> {}

