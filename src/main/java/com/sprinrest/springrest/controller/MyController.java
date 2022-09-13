package com.sprinrest.springrest.controller;


import com.sprinrest.springrest.entities.Course;
import com.sprinrest.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/home")
    public String home(){
        return " Welcome to Course Application home";
    }

    //Get all courses
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseService.getCourses();
    }

    //Get courseByID
    @GetMapping("/courses/{courseId}")
    public Optional<Course> getCourse(@PathVariable String courseId){
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    //adding a Course
    @PostMapping(path="/courses",consumes = "application/json")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    //updating a course
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
       return this.courseService.updateCourse(course);
    }

    //deleting a course
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
