package com.studentcourseregistrationsystem.controller;

import com.studentcourseregistrationsystem.entity.Department;
import com.studentcourseregistrationsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    /*
     *
     * Add New Department
     *
     * */
    @PostMapping("addDepartment")
    public String addNewDepartment(Department department, Model model){
        if(departmentService.addNewDepartment(department)) return null;
        return null;
    }

    /*
     *
     * Update Existing Department
     *
     * */
    @PostMapping("updateDepartment")
    public String updateExistingDepartment(Department browserDepartment){
        return departmentService.updateExistingDepartment(browserDepartment) ? "null" : null ;
    }

    /*
     *
     * Delete Existing Department
     *
     * */
    @RequestMapping("deleteDepartment")
    public String deleteExistingDepartment(Long departmentId){
        return departmentService.deleteExistingDepartment(departmentId) ? "null" : null;
    }

    /*
     *
     * Get All Departments
     *
     * */
    @GetMapping("allDepartments")
    public String getAllDepartment(Model model){
        model.addAttribute("allDepartments",departmentService.getAllDepartment());
        return null;
    }

    /*
     *
     * Get Departments by Name
     *
     * */
    @GetMapping("departmentByName")
    public String getDepartmentByName(String departmentName, Model model){
        model.addAttribute("allDepartments",departmentService.getDepartmentByName(departmentName));
        return null;
    }
}
