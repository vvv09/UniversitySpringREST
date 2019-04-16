package com.valunskii.university.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valunskii.university.domain.Classroom;
import com.valunskii.university.repository.ClassroomRepository;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {
    
    private ClassroomRepository classroomRepo;
    
    @Autowired
    public void setClassroomRepo(ClassroomRepository classroomRepo) {
        this.classroomRepo = classroomRepo;
    }

    @GetMapping
    public List<Classroom> retriveAll() {
        return classroomRepo.findAll();
    }
    
    @GetMapping("{id}")
    public Classroom retriveOne(@PathVariable("id") Classroom classroom) {
        return classroom;
    }
    
    @PostMapping
    public Classroom create(@RequestBody Classroom classroom) {
        return classroomRepo.save(classroom);
    }
    
    @PutMapping("{id}")
    public Classroom update(
            @PathVariable("id") Classroom classroomFromDb,
            @RequestBody Classroom classroom
    ) {
        BeanUtils.copyProperties(classroom, classroomFromDb, "id");
        return classroomRepo.save(classroomFromDb);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Classroom classroom) {
        classroomRepo.delete(classroom);
    }
}
