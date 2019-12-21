package com.encoursa.data.coursemanagementdata.course.controller;


import com.encoursa.data.coursemanagementdata.course.models.Course;
import com.encoursa.data.coursemanagementdata.course.servrice.CourseDataService;
import com.encoursa.data.coursemanagementdata.topic.models.Topic;
import com.encoursa.data.coursemanagementdata.topic.servrice.TopicDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics/{topicId}")
public class CourseDataController {

    @Autowired
    private CourseDataService courseDataService;

    @Autowired
    private TopicDataService topicDataService;

    @RequestMapping("/courses")
    public List<Course> getCourses() {
        return courseDataService.getCourses();
    }

    @RequestMapping("/course/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseDataService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST , value = "/courses")
    public void addCourse(@RequestBody Course course,@PathVariable("topicId") String topicId) {
      course.setTopic(new Topic(topicId,"",""));
      courseDataService.addCourse(course);

    }

    @RequestMapping(method = RequestMethod.PUT , value = "/courses/{id}")
    public void updateCourse(@PathVariable String id ,@PathVariable("topicId") String topicId,@RequestBody Course course){
        courseDataService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/course/{id}")
    public void deleteTopic(@PathVariable String id){
        Course course = courseDataService.getCourse(id);
        if(course != null ) {
            courseDataService.deleteCourse(course);
        }
    }
}
