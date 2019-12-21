package com.encoursa.data.coursemanagementdata.course.repository;

import com.encoursa.data.coursemanagementdata.course.models.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course,String> {

    /**
     * Custom methods can be added like this
     *
     * */
    /*JPA will find all courses by name*/
    public List<Course> findByName(String name);

    /*JPA will find all courses by description*/
    public List<Course> findByDescription(String anyValue);

/*JPA will find Topic and then in the Topic find id --> so name findByTopicId*/
    public List<Course> findByTopicId(String id);
}
