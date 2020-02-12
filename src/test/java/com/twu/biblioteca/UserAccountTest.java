package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserAccountTest {

    @Test
    void shouldCheckTwoUserAccountsAreEqual() {
        UserAccount userAccount =new UserAccount("123-3456","password");

        assertEquals(userAccount,new UserAccount("123-3456","password"));
    }

    @Test
    void shouldCheckTwoUserAccountsAreNotEqual() {
        UserAccount userAccount =new UserAccount("123-3456","password");

        assertNotEquals(userAccount,new UserAccount("123-3456","coiewhvw"));
    }
}