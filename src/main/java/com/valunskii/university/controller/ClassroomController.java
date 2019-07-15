package com.valunskii.university.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.valunskii.university.domain.Classroom;
import com.valunskii.university.repository.ClassroomRepository;

@RestController
@CrossOrigin
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
