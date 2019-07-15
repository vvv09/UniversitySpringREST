package com.valunskii.university.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.valunskii.university.domain.Group;
import com.valunskii.university.repository.GroupRepository;

@RestController
@CrossOrigin
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
