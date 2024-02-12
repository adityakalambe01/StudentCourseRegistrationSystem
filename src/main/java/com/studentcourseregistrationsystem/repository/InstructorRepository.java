package com.studentcourseregistrationsystem.repository;

import com.studentcourseregistrationsystem.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
