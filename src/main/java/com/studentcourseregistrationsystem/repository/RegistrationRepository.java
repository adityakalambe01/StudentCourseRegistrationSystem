package com.studentcourseregistrationsystem.repository;

import com.studentcourseregistrationsystem.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
