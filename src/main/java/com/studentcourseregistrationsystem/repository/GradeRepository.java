package com.studentcourseregistrationsystem.repository;

import com.studentcourseregistrationsystem.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade,Long> {
}
