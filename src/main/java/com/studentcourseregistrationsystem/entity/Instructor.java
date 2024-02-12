package com.studentcourseregistrationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "instructors")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructorId;

    private String instructorFirstName;

    private String instructorMiddleName;

    private String instructorLastName;

    private String instructorEmailId;

    private Long instructorMobileNumber;

    private Long instructorDepartmentId;

}