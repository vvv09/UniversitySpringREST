package com.valunskii.university.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.valunskii.university.domain.Subject;
import com.valunskii.university.repository.SubjectRepository;

@RestController
@CrossOrigin
@RequestMapping("/subjects")
public class SubjectController {
    
    private SubjectRepository subjectRepo;

    @Autowired
    public void setSubjectRepo(SubjectRepository subjectRepo) {
        this.subjectRepo = subjectRepo;
    }

    @GetMapping
    public List<Subject> retriveAll() {
        return subjectRepo.findAll();
    }
    
    @GetMapping("{id}")
    public Subject retriveOne(@PathVariable("id") Subject subject) {
        return subject;
    }
    
    @PostMapping
    public Subject create(@RequestBody Subject subject) {
        return subjectRepo.save(subject);
    }
    
    @PutMapping("{id}")
    public Subject update(
            @PathVariable("id") Subject subjectFromDb,
            @RequestBody Subject subject
    ) {
        BeanUtils.copyProperties(subject, subjectFromDb, "id");
        return subjectRepo.save(subjectFromDb);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Subject subject) {
        subjectRepo.delete(subject);
    }
}
