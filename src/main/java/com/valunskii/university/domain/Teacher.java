package com.valunskii.university.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@ApiModel(value = "Teacher Преподаватель")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    @ApiModelProperty(value = "ID преподавателя", required = true, position = 1, example = "1")
    private Long id;

    @Column(name = "first_name")
    @ApiModelProperty(value = "Имя преподавателя", required = true, position = 1, example = "1")
    private String firstName;

    @Column(name = "middle_name")
    @ApiModelProperty(value = "Отчество преподавателя", required = true, position = 1, example = "1")
    private String middleName;

    @Column(name = "last_name")
    @ApiModelProperty(value = "Фамилия преподавателя", required = true, position = 1, example = "1")
    private String lastName;
    
    public Teacher() {

    }
    
    public Teacher(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
}
