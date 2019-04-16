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

import com.valunskii.university.domain.Group;
import com.valunskii.university.repository.GroupRepository;

@RestController
@RequestMapping("/groups")
public class GroupController {
    
    private GroupRepository groupRepo;
  
    @Autowired
    public void setGroupRepo(GroupRepository groupRepo) {
        this.groupRepo = groupRepo;
    }

    @GetMapping
    public List<Group> retriveAll() {
        return groupRepo.findAll();
    }
    
    @GetMapping("{id}")
    public Group retriveOne(@PathVariable("id") Group group) {
        return group;
    }
    
    @PostMapping
    public Group create(@RequestBody Group group) {
        return groupRepo.save(group);
    }
    
    @PutMapping("{id}")
    public Group update(
            @PathVariable("id") Group groupFromDb,
            @RequestBody Group group
    ) {
        BeanUtils.copyProperties(group, groupFromDb, "id");
        return groupRepo.save(groupFromDb);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Group group) {
        groupRepo.delete(group);
    }
}
