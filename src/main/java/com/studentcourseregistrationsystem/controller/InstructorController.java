package com.studentcourseregistrationsystem.controller;

import com.studentcourseregistrationsystem.controller.page.Redirect;
import com.studentcourseregistrationsystem.entity.Instructor;
import com.studentcourseregistrationsystem.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InstructorController {
    @Autowired
    InstructorService instructorService;

    @Autowired
    Redirect pageredirect;

    /*
    *
    * Add New Instructor
    *
    * */
    public String addNewInstructor(Instructor browserInstructor, Model model){
        return instructorService.addNewInstructor(browserInstructor) ? null : "null";
    }

    /*
    *
    * Update Existing Instructor
    *
    * */
    @PostMapping("updateInstructor")
    public String updateExistingInstructor(Instructor updatedInstructor, Model model){
        String printingMessage;
        if (instructorService.updateExistingInstructor(updatedInstructor)){
            printingMessage = "Successfully updated profile";
        }else {
            printingMessage = "Something went wrong";
        }

        model.addAttribute("instructorPageMessage",printingMessage);
        return null;
    }

    /*
    *
    * Delete Existing Instructor
    *
    * */
    @RequestMapping("deleteInstructor")
    public String deleteExistingInstructor(Instructor instructor, Model model){
        String printingMessage;
        if (instructorService.deleteExistingInstructor(instructor.getInstructorId())){
            printingMessage = "Successfully updated profile";
        }else {
            printingMessage = "Something went wrong";
        }

        model.addAttribute("instructorPageMessage",printingMessage);
        model.addAttribute("getAllInstructor",instructorService.getAllInstructors());

        return null;
    }

    /*
    *
    * Get All Instructors
    *
    * */
    @GetMapping("allInstructor")
    public String getAllInstructors(Model model){
        model.addAttribute("getAllInstructor",instructorService.getAllInstructors());
        return pageredirect.allInstructor(model);
    }

    /*
    *
    * Get Instructor by DepartmentId
    *
    * */
    @GetMapping("instructorByDepartmentId")
    public String getInstructorByDepartmentId(Long deptId, Model model){
        model.addAttribute("getAllInstructor",instructorService.getInstructorByDepartmentId(deptId));
        return null;
    }

    /*
    *
    * Get All Instructors by Instructor Name
    *
    * */
    @GetMapping("instructorsByName")
    public String getInstructorByName(String instructorName, Model model){
        model.addAttribute("getAllInstructor",instructorService.getInstructorByName(instructorName));
        return null;
    }
}
