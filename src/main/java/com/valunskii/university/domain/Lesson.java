package com.valunskii.university.domain;

public enum Lesson {
    FIRST("Первая пара", "9:00", "10:30"), SECOND("Вторая пара", "10:45", "12:15"),
    THIRD("Третья пара", "12:50", "14:20"), FOURTH("Четвертая пара", "14:35", "16:05"),
    FIFTH("Пятая пара", "16:20", "17:50"), SIXTH("Шестая пара", "18:05", "19:35");

    private String name;
    private String timeBegin;
    private String timeEnd;

    Lesson(String name, String timeBegin, String timeEnd) {
        this.name = name;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
    }

    String getDescription() {
        return (name + " ( начало в " + timeBegin + " / окончание в " + timeEnd + " )");
    }
}
