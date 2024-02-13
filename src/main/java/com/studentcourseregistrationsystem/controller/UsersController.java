package com.studentcourseregistrationsystem.controller;

import com.studentcourseregistrationsystem.entity.Users;
import com.studentcourseregistrationsystem.repository.UsersRepository;
import com.studentcourseregistrationsystem.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class UsersController {
    @Autowired
    UsersService usersService;

    @Autowired
    UsersRepository usersRepository;

    /*
     *
     * Add New User
     *
     * */
    @PostMapping("signUp")
    public String addNewUser(Users user){
        if (usersService.addNewUser(user)){

        }else {

        }
        return null;
    }

    /*
     *
     * Update Existing User
     *
     * */
    @PostMapping("updateUser")
    public String updateExistingUser(Users updatedUser){
        if (usersService.updateExistingUser(updatedUser)){

        }else {

        }
        return null;
    }

    /*
     *
     * Delete Existing User
     *
     * */
    @RequestMapping("deleteUser")
    public String deleteExistingUser(Users user){
        if (usersService.deleteExistingUser(user.getUserid())){

        }else {

        }
        return null;
    }

    /*
     *
     * Login Users
     *
     * */
    @RequestMapping("login")
    public String loginUser(String emailId, String password){
        String role, redirect;
        Boolean userLogin = usersService.loginUser(emailId, password);
        if (userLogin==null){
            redirect = "";
        }else if (userLogin){
            role = usersRepository.findByUserEmailId(emailId).getUserRole();
            if (role.equalsIgnoreCase("admin")){
                redirect ="";
            } else if (role.equalsIgnoreCase("student")) {
                redirect ="";
            }else {
                redirect ="";
            }
        }else {
            redirect ="";
        }
        return redirect;
    }

    /*
     *
     * Get All Users
     *
     * */
    @GetMapping("allUsers")
    public String getAllUsers(Model model){
        model.addAttribute("allUsers", usersService.getAllUsers());
        return null;
    }

    /*
     *
     * Get All Users by Category
     *
     * */
    @GetMapping("usersByCategory")
    public String getAllUsersByCategory(String userRole, Model model){
        model.addAttribute("allUsers", usersService.getAllUsersByCategory(userRole));

        return null;
    }

    /*
     *
     * Search User
     *
     * */
    @GetMapping("searchUser")
    public String searchUserByName(String userName, Model model){
        model.addAttribute("allUsers", usersService.searchUserByName(userName));
        return null;
    }
}
