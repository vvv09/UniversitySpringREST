package com.valunskii.university.controller.rest;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.valunskii.university.domain.Teacher;
import com.valunskii.university.repository.TeacherRepository;

@RestController
@CrossOrigin
@Api(tags = {"TeacherController"}, description = "Преподаватель", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/teachers")
public class TeacherController {
     
    private TeacherRepository teacherRepo;

    @Autowired
    public void setTeacherRepo(TeacherRepository teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @ApiOperation(value = "Получить перечень элементов Преподаватель (Teacher)", notes = "Возвращает список элементов", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @GetMapping
    public List<Teacher> retriveAll() {
        return teacherRepo.findAll();
    }

    @ApiOperation(value = "Получить элементов Преподаватель (Teacher)", notes = "Возвращает элемент по ID", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @GetMapping("{id}")
    public Teacher retriveOne(@PathVariable("id") Teacher teacher) {
        return teacher;
    }

    @ApiOperation(value = "Создать элемент Преподаватель (Teacher)", notes = "Создает элемент", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @PostMapping
    public Teacher create(@RequestBody Teacher teacher) {
        return teacherRepo.save(teacher);
    }


    @ApiOperation(value = "Обновить элемент Преподаватель (Teacher)", notes = "Обновляет элемент по ID", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @PutMapping("{id}")
    public Teacher update(
            @PathVariable("id") Teacher teacherFromDb,
            @RequestBody Teacher teacher
    ) {
        BeanUtils.copyProperties(teacher, teacherFromDb, "id");
        return teacherRepo.save(teacherFromDb);
    }

    @ApiOperation(value = "Удалить элемент Преподаватель (Teacher)", notes = "Удаляет элемент по ID", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Teacher teacher) {
        teacherRepo.delete(teacher);
    }
}
