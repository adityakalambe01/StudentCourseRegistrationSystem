package com.studentcourseregistrationsystem.controller;

import com.studentcourseregistrationsystem.controller.page.Redirect;
import com.studentcourseregistrationsystem.entity.Registration;
import com.studentcourseregistrationsystem.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;

    @Autowired
    Redirect pageRedirect;

    /*
    *
    * Add New Registration
    *
    * */
    @PostMapping("addRegistration")
    public String addNewRegistration(Registration registration, Model model){
        if (registrationService.addNewRegistration(registration)){

        }
        return null;
    }

    /*
     *
     * Update Existing Registration
     *
     * */
    @PostMapping("updateRegistration")
    public String updateExistingRegistration(Registration browserRegistration, Model model){
        if (
                registrationService.updateExistingRegistration(browserRegistration)
        ){

        }else {

        }
        return null;
    }

    /*
     *
     * Delete Existing Registration
     *
     * */
    @RequestMapping("deleteRegistration")
    public String deleteExistingRegistration(Registration registration){
        if (
                registrationService.deleteExistingRegistration(registration.getRegistrationId())
        ){

        }else {

        }
        return null;
    }

    /*
     *
     * Get All Registration
     *
     * */
    @GetMapping("allRegistration")
    public String getAllRegistration(Model model){
        model.addAttribute("allRegistration",registrationService.getAllRegistration());
        return pageRedirect.allRegistration(model);
    }

    /*
     *
     * Get All Pending Status
     *
     * */
    @GetMapping("allPendingStatus")
    public String getAllPendingStatus(Model model){
        model.addAttribute("allRegistration", registrationService.getAllPendingStatus());
        return null;
    }

    /*
     *
     * Get All Approved Status
     *
     * */
    @GetMapping("allApproved")
    public String getAllApprovedStatus(Model model){
        model.addAttribute("allRegistration", registrationService.getAllApprovedStatus());
        return null;
    }

    /*
     *
     * Get All Registration Status by StudentId
     *
     * */
    @GetMapping("statusByStudentId")
    public String getAllStatusByStudentIdAndStatus(Long studentId, String status, Model model){
        model.addAttribute("allRegistration",registrationService.getAllStatusByStudentIdAndStatus(studentId, status));
        return null;
    }

    /*
     *
     * Get All Registration Status by CourseId
     *
     * */
    @GetMapping("statusByCourseId")
    public String getAllStatusByCourseIdAndStatus(Long courseId, String status, Model model){
        model.addAttribute("allRegistration", registrationService.getAllStatusByCourseIdAndStatus( courseId, status));
        return null;
    }
}
