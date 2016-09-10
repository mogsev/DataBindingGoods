package com.mogsev.application.databindinggoods.model;

public class User {
    private String firstName;
    private String lastName;
    private int age;

    public User() {

    }

    public User (String firstName) {
        this.firstName = firstName;
    }

    public User (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
