package com.valunskii.university.domain;

public enum Parity {
    ODD("Нечетная неделя"), EVEN("Нечетная неделя");
    
    private String name;
    
    Parity(String name){
        this.name = name;
    }
}
