package com.stupendousware.crm.models;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    private final String firstname;
    private final String lastname;
    private final String middleName;
    private final String id;
    private final int age;
    private final LocalDate birthDate;
    private String key;

    private User(Builder builder) {
        this.firstname = builder.firstName;
        this.lastname = builder.lastName;
        this.middleName = builder.middleName;
        this.id = builder.id;
        this.age = builder.age;
        this.birthDate = builder.birthDate;
    }

    public static User create(String firstname, String lastname) {
        var user = new Builder(firstname, lastname)
                .key(firstname + "." + lastname + "-key")
                .build();
        return user;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
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
    public boolean equals(Object obj) {
        var target = (User) obj;
        if (!firstname.equals(target.getFirstname()))
            return false;
        if (!lastname.equals(target.getLastname()))
            return false;
        if (this == obj) return true;
        return Objects.equals(id, target.id);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                '}';
    }

    public static class Builder {
        private final String firstName;
        private final String lastName;
        private String key;
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

        public Builder key(String key) {
            this.key = key;
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
