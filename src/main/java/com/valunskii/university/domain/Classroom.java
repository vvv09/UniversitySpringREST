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
@Table(name = "classrooms")
@Getter
@Setter
@ApiModel(value = "Classroom Аудитория")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classroom_id")
    @ApiModelProperty(value = "ID аудитории", required = true, position = 1, example = "1")
    private Long id;

    @ApiModelProperty(value = "Название аудитории", required = true, position = 1, example = "466")
    private String name;
    
    public Classroom() {
        
    }

    public Classroom(String name) {
        this.name = name;
    } 
}
