package com.yogi.service;

import com.yogi.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserServiceTest {
    UserService userService;
    String firstName;
    String lastName;
    String email;
    String password;
    String repeatPassword;
    @BeforeEach
    void init() {
        userService = new UserServiceImpl();
        firstName = "yogi";
        lastName = "bohara";
        email =  "test@test.com";
        password = "12345678";
        repeatPassword = "12345678";

    }
    @Test
    @DisplayName("User object created")
    void testCreateUser_whenUserDetailsProvided_returnsUserObject() {
        //Arrange


        //ACt
        User user = userService.createUser(firstName, lastName, email, password, repeatPassword);



        //Assert
        assertNotNull(user, "The createUser() should not returned null");
        assertEquals(firstName, user.getFirstName(), "User's first name is not right");
        assertEquals(lastName, user.getLastName(), "Last name does not matches");
        assertEquals(email, user.getEmail(),"Email does not matches");
        assertNotNull(user.getId(), "User id is missing");
    }

    @DisplayName("Empty first name causes correct exception")
    @Test
    void testCreateUser_whenFirstNameIsEmpty_throwsIllegalArgumentException() {
        //Arrange
        String firstName = "";
        String expectedExceptionMessage =  "User's first name is empty";

        //Act & Assert
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(firstName, lastName, email, password, repeatPassword);


        }, "Empty first name should have caused an Illegal Argument Exception");


        //Assert
        assertEquals(expectedExceptionMessage, thrown.getMessage());
    }

    @DisplayName("Empty last name causes correction exception")
    @Test
    void testCreateUser_whenLastNameIsEmpty_throwsIllegalArgumentException() {
        //Arrange
        String lastName = "";
        String expectedExceptionMessage = "User's last name is empty";

        //Act & Assert
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(firstName, lastName, email, password, repeatPassword);
                }, "Empty last name should have caused an Illegal Argument Exception");





        //Assert
        assertEquals(expectedExceptionMessage, thrown.getMessage());
    }

}
