package com.studentcourseregistrationsystem.controller.page;

import com.studentcourseregistrationsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Redirect {
    @Autowired
    DepartmentService departmentService;
    /*
    *
    * Home Page
    *
    * */
    @RequestMapping({"", "index", "home"})
    public String indexPage(){
        return "index";
    }

    /*
    *
    * Dashboard
    *
    * */

    @RequestMapping("adminDashboard")
    public String adminDashboard(){
        return "dashboard/admin";
    }

    @RequestMapping("instructorDashboard")
    public String instructorDashboard(){
        return "dashboard/instructor";
    }

    @RequestMapping("studentDashboard")
    public String studentDashboard(){
        return "dashboard/student";
    }

    /*
    *
    * Authentication
    *
    * */

    @RequestMapping("loginPage")
    public String loginUser(){
        return "auth/login";
    }

    @RequestMapping("signupPage")
    public String signUp(){
        return "auth/signup";
    }

    @RequestMapping("adminSignUp")
    public String adminSignUp(){
        return "auth/adminSignUp";
    }

    @RequestMapping("admin")
    public String adminLogin(){
        return "auth/adminLogin";
    }


    /*
    *
    * Admin Services
    *
    * */
    @RequestMapping("department")
    public String adminDashboardDepartment(){
        return "dashboard/adminPages/department";
    }

    @RequestMapping("addDepartment")
    public String addDepartment(){
        return "dashboard/adminPages/addDepartment";
    }

//    @RequestMapping("viewDepartment")
    public String viewDepartment(){
        return "dashboard/adminPages/viewDepartment";
    }

    @RequestMapping("course")
    public String viewAdminCourses(){
        return "dashboard/adminPages/courses";
    }

//    @RequestMapping("")

    public String viewCurrentCourse(){
        return "dashboard/adminPages/viewCourses";
    }

    @RequestMapping("addCoursePage")
    public String addNewCourse(Model model){
        model.addAttribute("departments",departmentService.getAllDepartment());
        return "dashboard/adminPages/addCourses";
    }
}
