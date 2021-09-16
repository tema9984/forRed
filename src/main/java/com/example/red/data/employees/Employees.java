package com.example.red.data.employees;

public class Employees {
    private int id;
    private String name;
    private String surname;
    private int positions_id;
    private int department_id;

    public Employees(int id, String name, String surname, int positions_id, int department_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.positions_id = positions_id;
        this.department_id = department_id;
    }

    public Employees(String name, String surname, int positions_id, int department_id) {
        this.name = name;
        this.surname = surname;
        this.positions_id = positions_id;
        this.department_id = department_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPositions_id() {
        return positions_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPositions_id(int positions_id) {
        this.positions_id = positions_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }
}
