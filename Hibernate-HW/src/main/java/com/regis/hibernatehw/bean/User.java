package com.regis.hibernatehw.bean;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "register")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "sex")
    private String sex;

    @Column(name = "country")
    private String country;

    public User() {}

    public User(int id, String name, String password, String email, String sex, String country) {
        this.id  = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.sex = sex;
        this.country = country;
    }

    // Getters and Setters
    // Ensure proper encapsulation and provide access to private fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    // Additional Methods
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
