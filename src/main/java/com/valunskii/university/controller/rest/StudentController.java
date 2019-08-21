package com.valunskii.university.controller.rest;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.valunskii.university.domain.Student;
import com.valunskii.university.repository.StudentRepository;

@RestController
@CrossOrigin
@Api(tags = {"StudentController"}, description = "Студент", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/students")
public class StudentController {
    
    private StudentRepository studentRepo;

    @Autowired
    public void setStudentRepo(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @ApiOperation(value = "Получить перечень элементов Студент (Student)", notes = "Возвращает список элементов", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @GetMapping
    public List<Student> retriveAll() {
        return studentRepo.findAll();
    }


    @ApiOperation(value = "Получить элементов Студент (Student)", notes = "Возвращает элемент по ID", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @GetMapping("{id}")
    public Student retriveOne(@PathVariable("id") Student student) {
        return student;
    }


    @ApiOperation(value = "Создать элемент Студент (Student)", notes = "Создает элемент", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    @ApiOperation(value = "Обновить элемент Студент (Student)", notes = "Обновляет элемент по ID", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @PutMapping("{id}")
    public Student update(
            @PathVariable("id") Student studentFromDb,
            @RequestBody Student student
    ) {
        BeanUtils.copyProperties(student, studentFromDb, "id");
        return studentRepo.save(studentFromDb);
    }


    @ApiOperation(value = "Удалить элемент Студент (Student)", notes = "Удаляет элемент по ID", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Student student) {
        studentRepo.delete(student);
    }
}
