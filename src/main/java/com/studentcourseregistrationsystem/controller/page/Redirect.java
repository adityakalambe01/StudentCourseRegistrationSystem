package com.studentcourseregistrationsystem.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Redirect {
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

    /*
    *
    * Users Page
    *
    * */
}
