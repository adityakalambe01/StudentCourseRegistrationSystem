package com.studentcourseregistrationsystem.repository;

import com.studentcourseregistrationsystem.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade,Long> {
    List<Grade> findByStudentId(Long studentId);

    List<Grade> findByCourseId(Long courseId);

    List<Grade> findByGradeObtained(String obtainedGrade);

    List<Grade> findByGradeDateBetween(LocalDate startDate, LocalDate endDate);
}
