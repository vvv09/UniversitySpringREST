package com.valunskii.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valunskii.university.domain.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
