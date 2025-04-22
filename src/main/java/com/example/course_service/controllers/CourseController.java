package com.example.course_service.controllers;

import com.example.course_service.models.Course;
import com.example.course_service.models.CourseLevel;
import com.example.course_service.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin("*")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Course>> getByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(courseService.getByCategory(categoryId));
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<List<Course>> getByLevel(@PathVariable String level) {
        CourseLevel courseLevel = CourseLevel.valueOf(level);
        return ResponseEntity.ok(courseService.getByLevel(courseLevel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable Long id) {
        return courseService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.save(course));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course updated) {
        return courseService.getById(id)
                .map(existing -> {
                    existing.setTitle(updated.getTitle());
                    existing.setDescription(updated.getDescription());
                    existing.setLevel(updated.getLevel());
                    existing.setCategory(updated.getCategory());
                    return ResponseEntity.ok(courseService.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
