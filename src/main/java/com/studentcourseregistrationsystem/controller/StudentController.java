package com.studentcourseregistrationsystem.controller;

import com.studentcourseregistrationsystem.controller.page.Redirect;
import com.studentcourseregistrationsystem.entity.Student;
import com.studentcourseregistrationsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    Redirect pageRedirect;

    /*
     *
     * Add New Student
     *
     * */
    @PostMapping("addStudent")
    public String addNewStudent(Student student){
        if (studentService.addNewStudent(student)){

        }
        return null;
    }

    /*
     *
     * Update Existing Student
     *
     * */
    @PostMapping("updateStudent")
    public String updateExistingStudent(Student updateStudent){
        if (studentService.updateExistingStudent(updateStudent)){

        }else {

        }
        return null;
    }

    /*
     *
     * Delete Existing Student
     *
     * */
    @RequestMapping("deleteStudent")
    public String deleteExistingStudent(Student student){
        if (studentService.deleteExistingStudent(student.getStudentSerialNumber())){

        }else {

        }

        return null;
    }

    /*
     *
     * Get All Student
     *
     * */
    @GetMapping("allStudents")
    public String getAllStudents(Model model){
        model.addAttribute("allStudents", studentService.getAllStudents());
        return pageRedirect.allStudent();
    }

    /*
     *
     * Get All Student By Name
     *
     * */
    @GetMapping("allStudentsByName")
    public String getAllStudentByName(String studentName, Model model){
        model.addAttribute("allStudents", studentService.getAllStudentByName(studentName));
        return null;
    }

    /*
     *
     * Get All Student By Gender
     *
     * */
    @GetMapping("allStudentsByGender")
    public String getAllStudentByGender(String gender, Model model){
        model.addAttribute("allStudents",studentService.getAllStudentByGender(gender));
        return null;
    }

    /*
     *
     * Get All Student by Ascending Order of Name
     *
     * */
    @GetMapping("studentNameAsc")
    public String getAllStudentsNameAsc(Model model){
        model.addAttribute("allStudents", studentService.getAllStudentsNameAsc());
        return null;
    }

    /*
     *
     * Get All Student By Ascending Order of StudentId
     *
     * */
    @GetMapping("studentsIdAsc")
    public String getAllStudentByStudentIdAsc(Model model){
        model.addAttribute("allStudents", studentService.getAllStudentByStudentIdAsc());
        return null;
    }
}
