package com.example.red.data.department;

public class Department {
    private int id;
    private String name;
    private String mail;
    private int phone;

    public Department(int id, String name, String mail, int phone) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
    }

    public Department(String name, String mail, int phone) {
        this.name = name;
        this.mail = mail;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public int getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
