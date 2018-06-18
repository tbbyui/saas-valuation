package com.example.justin.myapplication;

import com.example.justin.myapplication.exceptions.UsernameAlreadyExistsException;

public interface User {
    String getUsername();

    Boolean login(String username, String password);

    Boolean usernameAlreadyExists(String username);

    String createUser(String username, String pw1, String pw2) throws UsernameAlreadyExistsException;

    Boolean isLoggedIn();
}
