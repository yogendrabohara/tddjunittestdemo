package com.yogi.service;

import com.yogi.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserServiceTest {
    @Test
    @DisplayName("User object created")
    void testCreateUser_whenUserDetailsProvided_returnsUserObject() {
        //Arrange
        UserService userService = new UserServiceImpl();
        String firstName = "yogi";
        String lastName = "bohara";
        String email =  "test@test.com";
        String password = "12345678";
        String repeatPassword = "12345678";

        //ACt
        User user = userService.createUser(firstName, lastName, email, password, repeatPassword);



        //Assert
        assertNotNull(user, "The createUser() should not returned null");
        assertEquals(firstName, user.getFirstName(), "User's first name is not right");
        assertEquals(lastName, user.getLastName(), "Last name does not matches");
        assertEquals(email, user.getEmail(),"Email does not matches");
        assertNotNull(user.getId(), "User id is missing");
    }

}
