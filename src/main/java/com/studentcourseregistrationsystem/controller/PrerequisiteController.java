package com.studentcourseregistrationsystem.controller;

import com.studentcourseregistrationsystem.controller.page.Redirect;
import com.studentcourseregistrationsystem.entity.Prerequisite;
import com.studentcourseregistrationsystem.service.PrerequisiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrerequisiteController {
    @Autowired
    PrerequisiteService prerequisiteService;

    @Autowired
    Redirect pageRedirect;

    /*
    *
    * Add New Prerequisite
    *
    * */
    @PostMapping("addPrerequisite")
    public String addNewPrerequisite(Prerequisite prerequisite, Model model){


        return prerequisiteService.addNewPrerequisite(prerequisite) ? null : "null";
    }

    /*
    *
    * Update Existing Prerequisite
    *
    * */
    @PostMapping("updatePrerequisite")
    public String updateExistingPrerequisite(Prerequisite browserPrerequisite, Model model){
        String printingMessage;
        String printingMessageStyle;
        if (prerequisiteService.updateExistingPrerequisite(browserPrerequisite)){
            printingMessage = "Prerequisite updated!";
            printingMessageStyle = "color: green";
        }else {
            printingMessage = "Something went wrong!";
            printingMessageStyle = "color: red";
        }

        model.addAttribute("prerequisiteMessage",printingMessage);
        model.addAttribute("prerequisiteMessageStyle",printingMessageStyle);
        return null;
    }

    /*
    *
    * Delete Existing Prerequisite
    *
    * */
    @RequestMapping("deletePrerequisite")
    public String deleteExistingPrerequisite(Prerequisite prerequisite, Model model){
        String printingMessage;
        String printingMessageStyle;
        if (prerequisiteService.deleteExistingPrerequisite(prerequisite.getPrerequisiteId())){
            printingMessage = "Prerequisite deleted!";
            printingMessageStyle = "color: green";
        }else {
            printingMessage = "Something went wrong!";
            printingMessageStyle = "color: red";
        }

        model.addAttribute("prerequisiteMessage",printingMessage);
        model.addAttribute("prerequisiteMessageStyle",printingMessageStyle);
        return null;
    }

    /*
    *
    * Get All Prerequisite
    *
    * */
    @GetMapping("allPrerequisite")
    public String getAllPrerequisite(Model model){
        model.addAttribute("allPrerequisite", prerequisiteService.getAllPrerequisite());
        return pageRedirect.allPrerequisite();
    }

    /*
    *
    * Get Prerequisite by CourseId
    *
    * */
    @GetMapping("prerequisiteByCourseId")
    public String getPrerequisiteByCourseId(Long courseId,Model model){
        model.addAttribute("allPrerequisite", prerequisiteService.getPrerequisiteByCourseId(courseId));
        return null;
    }
}
