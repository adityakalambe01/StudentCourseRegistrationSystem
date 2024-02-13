package com.studentcourseregistrationsystem.service;

import com.studentcourseregistrationsystem.entity.Grade;
import com.studentcourseregistrationsystem.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GradeService {
    @Autowired
    GradeRepository gradeRepository;

    /*
    *
    * Add Grade Record
    *
    * */
    public boolean addNewGrade(Grade addGrade){
        gradeRepository.save(addGrade);
        return true;
    }

    /*
    *
    * Update Existing Grade
    *
    * */
    public boolean updateExistingGrade(Grade updateGrade){
        try {
            Grade dbGrade = gradeRepository.findById(updateGrade.getGradeId()).get();
            dbGrade.setCourseId(
                    updateGrade.getCourseId()
            );
            dbGrade.setStudentId(
                    updateGrade.getStudentId()
            );
            dbGrade.setGradeObtained(
                    updateGrade.getGradeObtained()
            );
            dbGrade.setGradeDate(
                    updateGrade.getGradeDate()
            );
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /*
    *
    * Delete Existing Grade
    *
    * */
    public boolean deleteExistingGrade(Long gradeId){
        try {
            Grade dbGrade = gradeRepository.findById(gradeId).get();
            gradeRepository.delete(dbGrade);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /*
    *
    * Get All Grades
    *
    * */
    public List<Grade> getAllGrades(){
        return gradeRepository.findAll();
    }

    /*
    *
    * Get Grades by StudentId
    *
    * */
    public List<Grade> getGradesByStudentId(Long studentId){
        return gradeRepository.findByStudentId(studentId);
    }

    /*
    *
    * Get Grades by CourseId
    *
    * */
    public List<Grade> getGradesByCourseId(Long courseId){
        return gradeRepository.findByCourseId(courseId);
    }

    /*
    *
    * Get All Grades by Obtained Grades
    *
    * */
    public List<Grade> getAllGradesByGradeObtained(String obtainedGrade){
        return gradeRepository.findByGradeObtained(obtainedGrade);
    }

    /*
    *
    * Get All Grades Between Date
    *
    * */
    public List<Grade> getAllGradesBetweenDate(LocalDate startDate, LocalDate endDate){
        return gradeRepository.findByGradeDateBetween(startDate,endDate);
    }
}
