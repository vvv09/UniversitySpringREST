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
@Table(name = "subjects")
@Getter
@Setter
@ApiModel(value = "Subject Предмет")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="subject_id")
    @ApiModelProperty(value = "ID предмета", required = true, position = 1, example = "1")
    private Long id;

    @ApiModelProperty(value = "Название предмета", required = true, position = 1, example = "ИНФОКОММУНИКАЦИОННЫЕ СИСТЕМЫ И ТЕХНОЛОГИИ")
    private String name;
      
    public Subject() {

    }
    
    public Subject(String name) {
        this.name = name;
    }
}
