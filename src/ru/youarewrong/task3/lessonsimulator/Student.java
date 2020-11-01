package ru.youarewrong.task3.lessonsimulator;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {

    private String name;
    private String surname;
    private String patronymic;
    private ArrayList<Integer> marks;

    public Student(String surname, String name, String patronymic) {
        marks = new ArrayList<>();
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public Student(String surname, String name) {
        this(surname, name, "");
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void addMark(int mark) {
        marks.add(mark);
    }

    public int getMark() {
        return (int) marks.stream().mapToDouble(x -> x).average().getAsDouble();

    }

    @Override
    public String toString() {
        if(marks.size()>0) {
            if (patronymic.isEmpty()) {
                return surname + " " + name + " " + getMark();
            }
            return surname + " " + name + " " + patronymic + " " + getMark();
        }
        return surname + " " + name + " " + patronymic;
    }

    @Override
    public int compareTo(Student student) {
        if (surname.compareTo(student.surname) == 0) {
            if (name.compareTo(student.name) == 0) {
                return patronymic.compareTo(student.patronymic);
            } else {
                return name.compareTo(student.name);
            }
        } else {
            return surname.compareTo(student.surname);
        }
    }
}
