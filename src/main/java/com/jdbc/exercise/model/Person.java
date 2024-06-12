
package com.jdbc.exercise.model;

import java.io.Serializable;

public class Person implements Serializable{
    private int id;
    private String name;
    private String address;
    private String tel;
    private boolean gender;
    private String nationality;

    public Person() {
    }

    public Person(int id, String name, String address, String tel, boolean gender, String nationality) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.gender = gender;
        this.nationality = nationality;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    
}
