package com.example.Notes.UserService;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    
    @Id // I am using email to uniquely identify user
    String username;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String password;
    java.time.LocalDate date;
    String role;
    String studentClass;
    public User(String username, String name, String password, String role, String studentClass) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.date=java.time.LocalDate.now();
        this.role="";
        this.studentClass="";
    }
    public User()
    {
        this.username="";
        this.name="";
        this.password="";
        this.date=java.time.LocalDate.now();
        this.role="";
        this.studentClass="";
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public java.time.LocalDate getDate() {
        return date;
    }
    public void setDate(java.time.LocalDate date) {
        this.date = date;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getStudentClass() {
        return studentClass;
    }
    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
    
}
