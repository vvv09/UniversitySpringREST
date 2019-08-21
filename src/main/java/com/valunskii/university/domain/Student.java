package com.valunskii.university.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
@ApiModel(value = "Student Студент")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    @ApiModelProperty(value = "ID студента", required = true, position = 1, example = "1")
    private Long id;

    @Column(name = "first_name")
    @ApiModelProperty(value = "Имя студента", required = true, position = 1, example = "Иван")
    private String firstName;

    @Column(name = "middle_name")
    @ApiModelProperty(value = "Отчество студента", required = true, position = 1, example = "Иванович")
    private String middleName;

    @Column(name = "last_name")
    @ApiModelProperty(value = "Фамилия студента", required = true, position = 1, example = "Иванов")
    private String lastName;

    @OneToOne
    @JoinColumn(name = "group_id")
    @ApiModelProperty(value = "Группа студента", required = true, position = 1, example = "1")
    private Group group;
          
    public Student() {
    }

    public Student(String firstName, String middleName, String lastName, Group group) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.group = group;
    }
    
}

