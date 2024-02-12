package com.studentcourseregistrationsystem.repository;

import com.studentcourseregistrationsystem.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    List<Instructor> findByInstructorDepartmentId(Long departmentId);

    List<Instructor> findByInstructorFullNameContaining(String instructorName);
}
