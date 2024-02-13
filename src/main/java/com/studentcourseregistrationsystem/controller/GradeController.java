package com.studentcourseregistrationsystem.controller;

import com.studentcourseregistrationsystem.entity.Grade;
import com.studentcourseregistrationsystem.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class GradeController {
    @Autowired
    GradeService gradeService;

    /*
    *
    * Add Grade Record
    *
    * */
    @PostMapping("addGrade")
    public String addNewGrade(Grade addGrade){
        return gradeService.addNewGrade(addGrade) ? null : "null";
    }

    /*
    *
    * Update Existing Grade
    *
    * */
    @PostMapping("updateGrade")
    public String updateExistingGrade(Grade updateGrade, Model model){
        String printingMessage;
        if (gradeService.updateExistingGrade(updateGrade)){
            printingMessage = "Successfully updated grades";
        }else {
            printingMessage = "Something went wrong";
        }
        model.addAttribute("gradeMessage",printingMessage);
        model.addAttribute("allGrade",gradeService.getAllGrades());
        return null;
    }

    /*
    *
    * Delete Existing Grade
    *
    * */
    @RequestMapping("deleteGrade")
    public String deleteExistingGrade(Grade grade, Model model){
        String printingMessage;
        if (gradeService.deleteExistingGrade(grade.getGradeId())){
            printingMessage = "Successfully deleted grades";
        }else {
            printingMessage = "Something went wrong";
        }
        model.addAttribute("gradeMessage",printingMessage);
        model.addAttribute("allGrade",gradeService.getAllGrades());
        return null;
    }

    /*
    *
    * Get All Grades
    *
    * */
    @GetMapping("allGrades")
    public String getAllGrades(Model model){
        model.addAttribute("allGrade",gradeService.getAllGrades());
        return null;
    }

    /*
    *
    * Get Grades by StudentId
    *
    * */
    @GetMapping("gradesByStudentId")
    public String getGradesByStudentId(Long studentId, Model model){
        model.addAttribute("allGrade",gradeService.getGradesByStudentId(studentId));
        return null;
    }

    /*
    *
    * Get Grades by CourseId
    *
    * */
    @GetMapping("gradeByCourseId")
    public String getGradesByCourseId(Long courseId, Model model){
        model.addAttribute("allGrade", gradeService.getGradesByCourseId(courseId));
        return null;
    }

    /*
    *
    * Get All Grades by Obtained Grades
    *
    * */
    @GetMapping("gradesByObtained")
    public String getAllGradesByGradeObtained(String obtainedGrade, Model model){
        model.addAttribute("allGrade", gradeService.getAllGradesByGradeObtained(obtainedGrade));
        return null;
    }

    /*
    *
    * Get All Grades Between Dates
    *
    * */
    @GetMapping("gradeBetweenDate")
    public String getAllGradesBetweenDate(LocalDate startDate, LocalDate endDate, Model model){
        model.addAttribute("allGrade", gradeService.getAllGradesBetweenDate(startDate, endDate));
        return null;
    }
}
