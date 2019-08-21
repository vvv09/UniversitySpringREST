package com.valunskii.university.controller.rest;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.valunskii.university.domain.Subject;
import com.valunskii.university.repository.SubjectRepository;

@RestController
@CrossOrigin
@Api(tags = {"SubjectRepository"}, description = "Предмет", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/subjects")
public class SubjectController {
    
    private SubjectRepository subjectRepo;

    @Autowired
    public void setSubjectRepo(SubjectRepository subjectRepo) {
        this.subjectRepo = subjectRepo;
    }

    @ApiOperation(value = "Получить перечень элементов Предмет (Subject)", notes = "Возвращает список элементов", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @GetMapping
    public List<Subject> retriveAll() {
        return subjectRepo.findAll();
    }


    @ApiOperation(value = "Получить элементов Предмет (Subject)", notes = "Возвращает элемент по ID", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @GetMapping("{id}")
    public Subject retriveOne(@PathVariable("id") Subject subject) {
        return subject;
    }


    @ApiOperation(value = "Создать элемент Предмет (Subject)", notes = "Создает элемент", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @PostMapping
    public Subject create(@RequestBody Subject subject) {
        return subjectRepo.save(subject);
    }

    @ApiOperation(value = "Обновить элемент Предмет (Subject)", notes = "Обновляет элемент по ID", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @PutMapping("{id}")
    public Subject update(
            @PathVariable("id") Subject subjectFromDb,
            @RequestBody Subject subject
    ) {
        BeanUtils.copyProperties(subject, subjectFromDb, "id");
        return subjectRepo.save(subjectFromDb);
    }


    @ApiOperation(value = "Удалить элемент Предмет (Subject)", notes = "Удаляет элемент по ID", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Subject subject) {
        subjectRepo.delete(subject);
    }
}
