package com.valunskii.university.controller.rest;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.valunskii.university.domain.Group;
import com.valunskii.university.repository.GroupRepository;

@RestController
@CrossOrigin
@Api(tags = {"GroupController"}, description = "Группы", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/groups")
public class GroupController {
    
    private GroupRepository groupRepo;
  
    @Autowired
    public void setGroupRepo(GroupRepository groupRepo) {
        this.groupRepo = groupRepo;
    }

    @ApiOperation(value = "Получить перечень элементов Группа (Group)", notes = "Возвращает список элементов", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @GetMapping
    public List<Group> retriveAll() {
        return groupRepo.findAll();
    }

    @ApiOperation(value = "Получить элемент Группа (Group)", notes = "Возвращает элемент по ID", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @GetMapping("{id}")
    public Group retriveOne(@PathVariable("id") Group group) {
        return group;
    }

    @ApiOperation(value = "Создать элемент Группа (Group)", notes = "Создает элемент", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @PostMapping
    public Group create(@RequestBody Group group) {
        return groupRepo.save(group);
    }

    @ApiOperation(value = "Обновить элемент Группа (Group)", notes = "Обновляет элемент по ID", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @PutMapping("{id}")
    public Group update(
            @PathVariable("id") Group groupFromDb,
            @RequestBody Group group
    ) {
        BeanUtils.copyProperties(group, groupFromDb, "id");
        return groupRepo.save(groupFromDb);
    }

    @ApiOperation(value = "Удалить элемент Группа (Group)", notes = "Удаляет элемент по ID", produces = MediaType.APPLICATION_JSON_VALUE, hidden = false)
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Group group) {
        groupRepo.delete(group);
    }
}
