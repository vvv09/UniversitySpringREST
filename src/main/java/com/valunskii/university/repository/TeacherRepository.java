package com.valunskii.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valunskii.university.domain.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
