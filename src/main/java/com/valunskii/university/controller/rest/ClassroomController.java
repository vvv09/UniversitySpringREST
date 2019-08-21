package com.valunskii.university.controller.rest;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.valunskii.university.domain.Classroom;
import com.valunskii.university.repository.ClassroomRepository;

@RestController
@CrossOrigin
@Api(tags = {"ClassroomController"}, description = "Аудитории", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/classrooms")
public class ClassroomController {
    
    private ClassroomRepository classroomRepo;
    
    @Autowired
    public void setClassroomRepo(ClassroomRepository classroomRepo) {
        this.classroomRepo = classroomRepo;
    }

    @ApiOperation(value = "Получить перечень элементов Аудитория (Classroom)", notes = "Возвращает список элементов", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @GetMapping
    public List<Classroom> retriveAll() {
        return classroomRepo.findAll();
    }

    @ApiOperation(value = "Получить элементов Аудитория (Classroom)", notes = "Возвращает элемент по ID", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @GetMapping("{id}")
    public Classroom retriveOne(@PathVariable("id") Classroom classroom) {
        return classroom;
    }

    @ApiOperation(value = "Создать элемент Аудитория (Classroom)", notes = "Создает элемент", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @PostMapping
    public Classroom create(@RequestBody Classroom classroom) {
        return classroomRepo.save(classroom);
    }

    @ApiOperation(value = "Обновить элемент Аудитория (Classroom)", notes = "Обновляет элемент по ID", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @PutMapping("{id}")
    public Classroom update(
            @PathVariable("id") Classroom classroomFromDb,
            @RequestBody Classroom classroom
    ) {
        BeanUtils.copyProperties(classroom, classroomFromDb, "id");
        return classroomRepo.save(classroomFromDb);
    }

    @ApiOperation(value = "Удалить элемент Аудитория (Classroom)", notes = "Удаляет элемент по ID", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Classroom classroom) {
        classroomRepo.delete(classroom);
    }
}
