package com.studentcourseregistrationsystem.service;

import com.studentcourseregistrationsystem.entity.Prerequisite;
import com.studentcourseregistrationsystem.repository.PrerequisiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrerequisiteService {
    @Autowired
    PrerequisiteRepository prerequisiteRepository;

    /*
    *
    * Add New Prerequisite
    *
    * */
    public boolean addNewPrerequisite(Prerequisite prerequisite){
        prerequisiteRepository.save(prerequisite);
        return true;
    }

    /*
    *
    * Update Existing Prerequisite
    *
    * */
    public boolean updateExistingPrerequisite(Prerequisite browserPrerequisite){
        try {
            Prerequisite dbPrerequisite = prerequisiteRepository.findById(browserPrerequisite.getPrerequisiteId()).get();
            dbPrerequisite.setCourseId(
                    browserPrerequisite.getCourseId()
            );
            dbPrerequisite.setPrerequisiteDescription(
                    browserPrerequisite.getPrerequisiteDescription()
            );
            prerequisiteRepository.save(dbPrerequisite);
        }catch (Exception e){
            return false;
        }

        return true;
    }

    /*
    *
    * Delete Existing Prerequisite
    *
    * */
    public boolean deleteExistingPrerequisite(Long prerequisiteId){
        try {
            Prerequisite dbPrerequisite = prerequisiteRepository.findById(prerequisiteId).get();
            prerequisiteRepository.delete(dbPrerequisite);
        }catch (Exception e){
            return false;
        }

        return true;
    }

    /*
    *
    * Get All Prerequisite
    *
    * */
    public List<Prerequisite> getAllPrerequisite(){
        return prerequisiteRepository.findAll();
    }

    /*
    *
    * Get Prerequisites by CourseId
    *
    * */
    public List<Prerequisite> getPrerequisiteByCourseId(Long courseId){
        return prerequisiteRepository.findByCourseId(courseId);
    }
}
