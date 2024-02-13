package com.studentcourseregistrationsystem.controller;

import com.studentcourseregistrationsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;


}
