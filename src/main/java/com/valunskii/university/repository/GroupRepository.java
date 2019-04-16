package com.valunskii.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valunskii.university.domain.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
