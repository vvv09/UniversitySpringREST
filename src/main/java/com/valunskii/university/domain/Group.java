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
@Table(name = "groups")
@Getter
@Setter
@ApiModel(value = "Group Группа")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    @ApiModelProperty(value = "ID группы", required = true, position = 1, example = "1")
    private Long id;

    @ApiModelProperty(value = "Название группы", required = true, position = 1, example = "K-3120")
    private String name;

    public Group() {
        
    }

    public Group(String name) {
        this.name = name;
    } 
}
