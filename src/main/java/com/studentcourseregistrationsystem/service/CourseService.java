package com.studentcourseregistrationsystem.service;

import com.studentcourseregistrationsystem.entity.Course;
import com.studentcourseregistrationsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    /*
    *
    * Add New Course
    *
    * */
    public boolean addNewCourse(Course course){
         courseRepository.save(course);
        return true;
    }

    /*
    *
    * Update Existing Course
    *
    * */
    public boolean updateExistingCourse(Course updatedCourse){
        Course dbCourse;
        try {
            dbCourse = courseRepository.findById(updatedCourse.getCourseId()).get();
            dbCourse.setCourseCapacity(updatedCourse.getCourseCapacity());
            dbCourse.setCourseCode(updatedCourse.getCourseCode());
            dbCourse.setCourseTitle(updatedCourse.getCourseTitle());
            dbCourse.setCourseDescription(updatedCourse.getCourseDescription());
            dbCourse.setDepartmentId(updatedCourse.getDepartmentId());

            courseRepository.save(dbCourse);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /*
    *
    * Delete Existing Course
    *
    * */
    public boolean deleteExistingCourse(Course browserCourse){
        Course dbCourse;
        try {
            dbCourse = courseRepository.findById(browserCourse.getCourseId()).get();
            courseRepository.delete(dbCourse);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /*
    *
    * Get All Courses
    *
    * */
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    /*
    *
    * Get Course by Course Code
    *
    * */
    public List<Course> getCourseByCourseCode(String courseCode){
        return courseRepository.findByCourseCode(courseCode);
    }

    /*
    *
    * Get Course by Course Title
    *
    * */
    public List<Course> getCourseByCourseTitle(String courseTitle){
        return courseRepository.findByCourseTitle(courseTitle);
    }

    /*
    *
    * Get Courses by Description
    *
    * */
    public List<Course> getCourseByCourseDescription(String courseDescription){
        return courseRepository.findByCourseDescription(courseDescription);
    }

    /*
    *
    * Get Courses by its Capacity Ranges
    *
    * */
    public List<Course> getCoursesByCapacityRange(Long minimumRange, Long maximumRange){
        return courseRepository.findByCourseCapacityBetween(minimumRange, maximumRange);
    }

    /*
    *
    * Get Courses by Department Name
    *
    * */
}
