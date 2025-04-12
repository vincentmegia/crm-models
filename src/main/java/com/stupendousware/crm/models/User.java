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

    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;
        this.id = builder.id;
        this.age = builder.age;
        this.birthDate = builder.birthDate;
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
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id);
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

    public static class Builder {
        private final String firstName;
        private final String lastName;
        private String middleName;
        private String id;
        private int age;
        private LocalDate birthDate;

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
