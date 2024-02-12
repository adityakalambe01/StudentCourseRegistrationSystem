package com.studentcourseregistrationsystem.repository;

import com.studentcourseregistrationsystem.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, Long> {
}
