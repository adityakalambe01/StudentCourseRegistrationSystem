package com.studentcourseregistrationsystem.controller;

import com.studentcourseregistrationsystem.entity.Semester;
import com.studentcourseregistrationsystem.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SemesterController {
    @Autowired
    SemesterService semesterService;

    /*
     *
     * Add New Semester
     *
     * */
    @PostMapping("addSemester")
    public String addNewSemester(Semester semester){
        if (semesterService.addNewSemester(semester)){
            return null;
        }
        return null;
    }

    /*
     *
     * Update Existing Semester
     *
     * */
    @PostMapping("updateSemester")
    public String updateExistingSemester(Semester updatedSemester){
        if (semesterService.updateExistingSemester(updatedSemester)){

        }else {

        }

        return null;
    }

    /*
     *
     * Delete Existing Semester
     *
     * */
    @RequestMapping("deleteSemester")
    public String deleteExistingSemester(Semester semester){
        if (semesterService.deleteExistingSemester(semester.getSemesterSerialNumber())){

        }else {

        }
        return null;
    }

    /*
     *
     * Get All Semester
     *
     * */
    @GetMapping("allSemester")
    public String getAllSemester(Model model){
        model.addAttribute("allSemester", semesterService.getAllSemester());

        return null;
    }

    /*
     *
     * Get All Semester by Name
     *
     * */
    @GetMapping("semesterByName")
    public String getAllSemesterByName(String semesterName, Model model){
        model.addAttribute("allSemester", semesterService.getAllSemesterByName(semesterName));
        return null;
    }
}
