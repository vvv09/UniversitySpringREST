package com.valunskii.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valunskii.university.domain.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Long>{

}
