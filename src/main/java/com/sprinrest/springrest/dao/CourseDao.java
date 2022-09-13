package com.sprinrest.springrest.dao;

import com.sprinrest.springrest.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course,Long> {
}
