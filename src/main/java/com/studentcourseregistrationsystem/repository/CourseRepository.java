package com.studentcourseregistrationsystem.repository;

import com.studentcourseregistrationsystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
