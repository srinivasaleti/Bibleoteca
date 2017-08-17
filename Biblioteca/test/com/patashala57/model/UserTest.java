package com.patashala57.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void beforeEach() {
        this.user = new User("srinu", "123-123424", "1234", "srinivas.aleti03@gmail.com", "9848981244");
    }

    @Test
    void successfulLogin() {
        assertTrue(user.hasSameCredentials("123-123424", "1234"));
    }

    @Test
    void unSuccessfulLogin() {
        assertFalse(user.hasSameCredentials("123-123414", "1434"));
    }

    @Test
    void representationOfUser() {
        String expected = String.format("%-35s %-35s %-35s", "srinu", "srinivas.aleti03@gmail.com", "9848981244");
        assertEquals(this.user.representation(), expected);
    }

    @Test
    void userNotEqualToNull(){
        assertNotEquals(this.user,null);
    }

    @Test
    void userNotEqualToString(){
        assertNotEquals(this.user,"user");
    }

    @Test
    void userEqualToItSelf(){
        assertEquals(this.user,this.user);
    }

    @Test
    void userEqualToSameUser(){
        User sameUser = new User("srinu", "123-123424", "1234", "srinivas.aleti03@gmail.com", "9848981244");
        assertEquals(this.user,sameUser);
    }

}
