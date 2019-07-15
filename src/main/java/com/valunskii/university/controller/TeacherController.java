package com.valunskii.university.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.valunskii.university.domain.Teacher;
import com.valunskii.university.repository.TeacherRepository;

@RestController
@CrossOrigin
@RequestMapping("/teachers")
public class TeacherController {
     
    private TeacherRepository teacherRepo;

    @Autowired
    public void setTeacherRepo(TeacherRepository teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @GetMapping
    public List<Teacher> retriveAll() {
        return teacherRepo.findAll();
    }
    
    @GetMapping("{id}")
    public Teacher retriveOne(@PathVariable("id") Teacher teacher) {
        return teacher;
    }
    
    @PostMapping
    public Teacher create(@RequestBody Teacher teacher) {
        return teacherRepo.save(teacher);
    }
    
    @PutMapping("{id}")
    public Teacher update(
            @PathVariable("id") Teacher teacherFromDb,
            @RequestBody Teacher teacher
    ) {
        BeanUtils.copyProperties(teacher, teacherFromDb, "id");
        return teacherRepo.save(teacherFromDb);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Teacher teacher) {
        teacherRepo.delete(teacher);
    }
}
