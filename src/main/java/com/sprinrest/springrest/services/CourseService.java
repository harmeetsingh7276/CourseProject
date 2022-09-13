package com.sprinrest.springrest.services;

import com.sprinrest.springrest.entities.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    public List<Course> getCourses();

    public Optional<Course> getCourse(Long courseId);

    public Course addCourse(Course course);

    public Course updateCourse(Course course);


    void deleteCourse(long parseLong);
}
