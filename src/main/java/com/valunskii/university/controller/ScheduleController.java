package com.valunskii.university.controller;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import com.valunskii.university.domain.Group;
import com.valunskii.university.domain.Parity;
import com.valunskii.university.domain.Schedule;
import com.valunskii.university.domain.Teacher;
import com.valunskii.university.repository.GroupRepository;
import com.valunskii.university.repository.ScheduleRepository;
import com.valunskii.university.repository.TeacherRepository;

@RestController
@CrossOrigin
@RequestMapping("/schedule")
public class ScheduleController {
    
    private final String ANY = "any";

    private TeacherRepository teacherRepo;
    
    @Autowired
    public void setTeacherRepo(TeacherRepository teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    private GroupRepository groupRepo;
    
    @Autowired
    public void setGroupRepo(GroupRepository groupRepo) {
        this.groupRepo = groupRepo;
    }

    private ScheduleRepository scheduleRepo;

    @Autowired
    public void setScheduleRepo(ScheduleRepository scheduleRepo) {
        this.scheduleRepo = scheduleRepo;
    }
    
    @GetMapping
    public List<Schedule> retriveAll(WebRequest webRequest) {
        Map<String, String[]> params = webRequest.getParameterMap();
        String parity = null;
        String dayOfWeek = null;
        if (params.containsKey("parity")) {
            parity = params.get("parity")[0];
        }
        if (params.containsKey("dayOfWeek")) {
            dayOfWeek = params.get("dayOfWeek")[0];
        }
        if ((parity == null && dayOfWeek == null) || (parity.equals(ANY) && dayOfWeek.equals(ANY))) {
            return scheduleRepo.findAllByOrderByIdAsc();
        } else {
            if (parity.equals(ANY)) {
                return scheduleRepo.findAllByDayOfWeekOrderByIdAsc(DayOfWeek.valueOf(dayOfWeek));
            } else if (dayOfWeek.equals(ANY)) {
                return scheduleRepo.findAllByParityOrderByIdAsc(Parity.valueOf(parity));
            } else {
                return scheduleRepo.findAllByDayOfWeekAndParityOrderByIdAsc(DayOfWeek.valueOf(dayOfWeek), Parity.valueOf(parity));
            }
        }
    }
    
    @GetMapping("/group/{group}")
    public List<Schedule> retriveScheduleForGroup(@PathVariable Group group, WebRequest webRequest) {
        Map<String, String[]> params = webRequest.getParameterMap();
        String parity = null;
        String dayOfWeek = null;
        if (params.containsKey("parity")) {
            parity = params.get("parity")[0];
        }
        if (params.containsKey("dayOfWeek")) {
            dayOfWeek = params.get("dayOfWeek")[0];
        }
        if ((parity == null && dayOfWeek == null) || (parity.equals(ANY) && dayOfWeek.equals(ANY))) {
            return scheduleRepo.findByGroupOrderById(group);
        } else {
            if (parity.equals(ANY)) {
                return scheduleRepo.findByGroupAndDayOfWeekOrderById(group, DayOfWeek.valueOf(dayOfWeek));
            } else if (dayOfWeek.equals(ANY)) {
                return scheduleRepo.findByGroupAndParityOrderById(group, Parity.valueOf(parity));
            } else {
                return scheduleRepo.findByGroupAndDayOfWeekAndParityOrderById(group, DayOfWeek.valueOf(dayOfWeek), Parity.valueOf(parity));
            }
        }
    }
    
    @GetMapping("/teacher/{teacher}")
    public List<Schedule> retriveScheduleForTeacher(@PathVariable Teacher teacher, WebRequest webRequest) {
        Map<String, String[]> params = webRequest.getParameterMap();
        String parity = null;
        String dayOfWeek = null;
        if (params.containsKey("parity")) {
            parity = params.get("parity")[0];
        }
        if (params.containsKey("dayOfWeek")) {
            dayOfWeek = params.get("dayOfWeek")[0];
        }
        if ((parity == null && dayOfWeek == null) || (parity.equals(ANY) && dayOfWeek.equals(ANY))) {
            return scheduleRepo.findByTeacherOrderById(teacher);
        } else {
            if (parity.equals(ANY)) {
                return scheduleRepo.findByTeacherAndDayOfWeekOrderById(teacher, DayOfWeek.valueOf(dayOfWeek));
            } else if (dayOfWeek.equals(ANY)) {
                return scheduleRepo.findByTeacherAndParityOrderById(teacher, Parity.valueOf(parity));
            } else {
                return scheduleRepo.findByTeacherAndDayOfWeekAndParityOrderById(teacher, DayOfWeek.valueOf(dayOfWeek), Parity.valueOf(parity));
            }
        }
    }
    
    @PostMapping
    public Schedule create(@RequestBody Schedule schedule) {
        return scheduleRepo.save(schedule);
    }
    
    @PutMapping("{id}")
    public Schedule update(
            @PathVariable("id") Schedule scheduleFromDb,
            @RequestBody Schedule schedule
    ) {
        BeanUtils.copyProperties(schedule, scheduleFromDb, "id");
        return scheduleRepo.save(scheduleFromDb);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Schedule schedule) {
        scheduleRepo.delete(schedule);
    }
}
