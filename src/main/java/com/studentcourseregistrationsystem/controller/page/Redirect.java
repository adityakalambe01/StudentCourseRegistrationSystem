package com.studentcourseregistrationsystem.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Redirect {
    @RequestMapping({"", "index", "home"})
    public String indexPage(){
        return "index";
    }
}
