package com.valunskii.university.repository;

import java.time.DayOfWeek;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valunskii.university.domain.Group;
import com.valunskii.university.domain.Parity;
import com.valunskii.university.domain.Schedule;
import com.valunskii.university.domain.Teacher;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
    public List<Schedule> findAllByOrderByIdAsc();
    public List<Schedule> findAllByDayOfWeekOrderByIdAsc(DayOfWeek dayOfWeek);
    public List<Schedule> findAllByParityOrderByIdAsc(Parity parity);
    public List<Schedule> findAllByDayOfWeekAndParityOrderByIdAsc(DayOfWeek dayOfWeek, Parity parity);
    
    public List<Schedule> findByGroupOrderById(Group group);
    public List<Schedule> findByGroupAndDayOfWeekOrderById(Group group, DayOfWeek dayOfWeek);
    public List<Schedule> findByGroupAndParityOrderById(Group group, Parity parity);
    public List<Schedule> findByGroupAndDayOfWeekAndParityOrderById(Group group, DayOfWeek dayOfWeek, Parity parity);
    
    public List<Schedule> findByTeacherOrderById(Teacher teacher);
    public List<Schedule> findByTeacherAndDayOfWeekOrderById(Teacher teacher, DayOfWeek dayOfWeek);
    public List<Schedule> findByTeacherAndParityOrderById(Teacher teacher, Parity parity);
    public List<Schedule> findByTeacherAndDayOfWeekAndParityOrderById(Teacher teacher, DayOfWeek dayOfWeek, Parity parity);
}
