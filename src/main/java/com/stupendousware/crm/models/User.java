package com.stupendousware.crm.models;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final String id;
    private final int age;
    private final LocalDate birthDate;

    public User(String firstName, String lastName, String middleName, String id, int age, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.id = id;
        this.age = age;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                '}';
    }
}
