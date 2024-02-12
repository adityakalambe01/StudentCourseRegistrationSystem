package com.studentcourseregistrationsystem.service;

import com.studentcourseregistrationsystem.entity.Instructor;
import com.studentcourseregistrationsystem.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    @Autowired
    InstructorRepository instructorRepository;

    /*
    *
    * Add New Instructor
    *
    * */
    public boolean addNewInstructor(Instructor browserInstructor){
        instructorRepository.save(browserInstructor);
        return true;
    }

    /*
    *
    * Update Existing Instructor
    *
    * */
    public boolean updateExistingInstructor(Instructor updatedInstructor){
        try {
            Instructor dbInstructor = instructorRepository.findById(updatedInstructor.getInstructorId()).get();
            dbInstructor.setInstructorFullName(
                    updatedInstructor.getInstructorFullName()
            );
            dbInstructor.setInstructorEmailId(
                    updatedInstructor.getInstructorEmailId()
            );
            dbInstructor.setInstructorMobileNumber(
                    updatedInstructor.getInstructorMobileNumber()
            );
            dbInstructor.setInstructorDepartmentId(
                    updatedInstructor.getInstructorDepartmentId()
            );
            instructorRepository.save(dbInstructor);
        }catch (Exception e){
            return false;
        }

        return true;
    }

    /*
    *
    * Delete Existing Instructor
    *
    * */
    public boolean deleteExistingInstructor(Long instructorId){
        try {
            Instructor dbInstructor = instructorRepository.findById(instructorId).get();
            instructorRepository.delete(dbInstructor);
        }catch (Exception e){
            return false;
        }

        return true;
    }

    /*
    *
    * Get All Instructors
    *
    * */
    public List<Instructor> getAllInstructors(){
        return instructorRepository.findAll();
    }

    /*
    *
    * Get Instructor by DepartmentId
    *
    * */
    public List<Instructor> getInstructorByDepartmentId(Long departmentId){
        return instructorRepository.findByInstructorDepartmentId(departmentId);
    }

    /*
    *
    * Get All Instructors by Instructor Name
    *
    * */
    public List<Instructor> getInstructorByName(String instructorName){
        return instructorRepository.findByInstructorFullNameContaining(instructorName);
    }
}
