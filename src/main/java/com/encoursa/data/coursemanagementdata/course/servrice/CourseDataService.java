package com.encoursa.data.coursemanagementdata.course.servrice;


import com.encoursa.data.coursemanagementdata.course.models.Course;
import com.encoursa.data.coursemanagementdata.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseDataService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        Iterable<Course> courseIterable = courseRepository.findAll();
        if(courseIterable != null){
            courseIterable.forEach(courses :: add);
        }
        return courses;
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public Course getCourse(String id){

        Course course = null;

        Optional<Course> byId = courseRepository.findById(id);

        if (byId.isPresent()){
            course = byId.get();
        }

        return course;
    }

    public void deleteCourse(Course course) {
        courseRepository.delete(course);
    }


}
