package com.jdbc.exercise.model;

public class Nationality {

    private String id, name;

    public Nationality() {
    }

    public Nationality(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " - " + id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
