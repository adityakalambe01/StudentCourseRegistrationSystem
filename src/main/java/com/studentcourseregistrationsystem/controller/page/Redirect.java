package com.studentcourseregistrationsystem.controller.page;

import com.studentcourseregistrationsystem.service.DepartmentService;
import com.studentcourseregistrationsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Redirect {
    @Autowired
    DepartmentService departmentService;

    @Autowired
    StudentService studentService;
    public static final String currentOpenTab = "currentOpenedTab";
    public static final String colorOfCurrentOpenedTab = "background-color: green !important;";

    public static void showCurrentTabColor(Model model){
        model.addAttribute(Redirect.currentOpenTab, Redirect.colorOfCurrentOpenedTab);
    }
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
    public String adminDashboardDepartment(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/department";
    }

    @RequestMapping("addDepartment")
    public String addDepartment(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/addDepartment";
    }

//    @RequestMapping("viewDepartment")
    public String viewDepartment(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/viewDepartment";
    }

    @RequestMapping("course")
    public String viewAdminCourses(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/courses";
    }

//    @RequestMapping("")

    public String viewCurrentCourse(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/viewCourses";
    }

    @RequestMapping("addCoursePage")
    public String addNewCourse(Model model){
        model.addAttribute("departments",departmentService.getAllDepartment());
        showCurrentTabColor(model);
        return "dashboard/adminPages/addCourses";
    }

    public String allPrerequisite(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/prerequisite";
    }

    public String viewCurrentPrerequisite(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/viewPrerequisite";
    }

    public String addPrerequisite(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/addPrerequisite";
    }

    public String allRegistration(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/registration";
    }

    public String viewCurrentRegistration(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/ViewRegistration";
    }

    public String addRegistration(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/addRegistration";
    }

    public String allGrade(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/grade";
    }

    public String addGrade(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/addGrade";
    }

    public String viewCurrentGrade(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/viewGrade";
    }

    public String allUser(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/user";
    }

    @RequestMapping("addNewUser")
    public String addUser(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/addUser";
    }

    public String viewCurrentUser(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/viewUser";
    }

    public String allStudent(Model model){
        model.addAttribute("allStudents", studentService.getAllStudents());
        showCurrentTabColor(model);
        return "dashboard/adminPages/student";
    }

    @RequestMapping("addStudentPage")
    public String addStudent(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/addStudent";
    }

    public String viewCurrentStudent(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/viewStudent";
    }

    public String allSemester(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/semester";
    }

    public String addSemester(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/addSemester";
    }

    public String viewCurrentSemester(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/viewSemester";
    }

    public String allInstructor(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/instructor";
    }

    public String addInstructor(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/addInstructor";
    }

    public String viewCurrentInstructor(Model model){
        showCurrentTabColor(model);
        return "dashboard/adminPages/viewInstructor";
    }
}
