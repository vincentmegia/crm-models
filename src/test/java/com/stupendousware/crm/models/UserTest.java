package com.stupendousware.crm.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void firstNameSuccess() {
        var user = new User.Builder("john", null).build();
        Assertions.assertTrue("john".equals(user.getFirstname()));
    }

    @Test
    public void lastNameSuccess() {
        var user = new User.Builder("john", "doe").build();
        Assertions.assertTrue("doe".equals(user.getLastname()));
    }
}
