package com.studentcourseregistrationsystem.controller;

import com.studentcourseregistrationsystem.entity.Course;
import com.studentcourseregistrationsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    CourseService courseService;

    /*
    *
    * Add New Course
    *
    * */
    @PostMapping("addNewCourse")
    public String addNewCourse(Course course){
        if (courseService.addNewCourse(course)) return "AllCourses";
        return "AddCourse";
    }

    /*
    *
    * Update Existing Course
    *
    * */
    @RequestMapping("updateCourse")
    public String updateExistingCourse(Course updatedCourse){
        if (courseService.updateExistingCourse(updatedCourse)){
            return "Updated Course";
        }
        return null;
    }

    /*
    *
    * Delete Existing Course
    *
    * */
    @RequestMapping("deleteCourse")
    public String deleteExistingCourse(Course course){
        if (courseService.deleteExistingCourse(course)) return null;
        return null;
    }

    /*
    *
    * Get All Courses
    *
    * */
    @GetMapping("allCourses")
    public String getAllCourses(Model model){
        model.addAttribute("allCourses",courseService.getAllCourse());
        return null;
    }

    /*
    *
    * Get Course by Course Code
    *
    * */
    @GetMapping("courseByCode")
    public String getCourseByCourseCode(String courseCode, Model model){
        model.addAttribute("allCourses",courseService.getCourseByCourseCode(courseCode));
        return null;
    }

    /*
    *
    * Get Course by Course Title
    *
    * */
    @GetMapping("courseByTitle")
    public String getCourseByCourseTitle(String courseTitle, Model model){
        model.addAttribute("allCourses",courseService.getCourseByCourseTitle(courseTitle));
        return null;
    }

    /*
     *
     * Get Courses by Description
     *
     * */
    @GetMapping("courseByDescription")
    public String getCourseByCourseDescription(String courseDescription, Model model){
        model.addAttribute("allCourses",courseService.getCourseByCourseDescription(courseDescription));
        return null;
    }

    /*
     *
     * Get Courses by its Capacity Ranges
     *
     * */
    @GetMapping("getCourseByRange")
    public String getCoursesByCapacityRange(Long minimumRange, Long maximumRange, Model model){
        model.addAttribute("allCourses",courseService.getCoursesByCapacityRange(minimumRange, maximumRange));
        return null;
    }
}
