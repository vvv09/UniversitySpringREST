package com.valunskii.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valunskii.university.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
