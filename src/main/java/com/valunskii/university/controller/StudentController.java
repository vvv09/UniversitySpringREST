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

import com.valunskii.university.domain.Student;
import com.valunskii.university.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
    
    private StudentRepository studentRepo;

    @Autowired
    public void setStudentRepo(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @GetMapping
    public List<Student> retriveAll() {
        return studentRepo.findAll();
    }
    
    @GetMapping("{id}")
    public Student retriveOne(@PathVariable("id") Student student) {
        return student;
    }
    
    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentRepo.save(student);
    }
    
    @PutMapping("{id}")
    public Student update(
            @PathVariable("id") Student studentFromDb,
            @RequestBody Student student
    ) {
        BeanUtils.copyProperties(student, studentFromDb, "id");
        return studentRepo.save(studentFromDb);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Student student) {
        studentRepo.delete(student);
    }
}
