package com.sprinrest.springrest.services;

import com.sprinrest.springrest.dao.CourseDao;
import com.sprinrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

//    List<Course> list;
    @Autowired
    private CourseDao courseDao;


    public CourseServiceImpl() {
//        list=new ArrayList<>();
//        list.add(new Course(145,"Java Course","Basics of Java"));
//        list.add(new Course(146,"SpringBoot Course","Basics of SpringBoot"));
    }

    @Override
    public List<Course> getCourses() {
      //  return list;
        return this.courseDao.findAll();
    }

    @Override
    public Optional<Course> getCourse(Long courseId) {
//        Course c=null;
//        for(Course course:list){
//            if(course.getId()==courseId){
//                c=course;
//                break;
//            }
//        }
//        return c;
        //return courseDao.getOne(courseId);
        return this.courseDao.findById(courseId);
    }

    @Override
    public Course addCourse(Course course) {
//        list.add(course);
//        return course;
        return this.courseDao.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
//        for (Course c :list) {
//            if(course.getId()==c.getId()){
//                c=new Course(course,course.getId());
//            }
//        }
        this.courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long courseId) {
//        for (Course course:list) {
//            if(course.getId()==courseId){
//                list.remove(course);
//            }
//        }
        this.courseDao.delete(this.courseDao.getById(courseId));
    }
}
