package com.example.red.data.position;

public class Positions {
    private int id;
    private String position;
    private int salary;

    public Positions(int id, String position, int salary) {
        this.id = id;
        this.position = position;
        this.salary = salary;
    }

    public Positions(String position, int salary) {
        this.position = position;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
