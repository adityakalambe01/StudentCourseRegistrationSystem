package com.studentcourseregistrationsystem.repository;

import com.studentcourseregistrationsystem.entity.Prerequisite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrerequisiteRepository extends JpaRepository<Prerequisite, Long> {
}
