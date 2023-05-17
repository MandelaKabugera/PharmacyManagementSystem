package com.example.service;

import com.example.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel saveUser(UserModel user);
    List<UserModel> displayUsers();
    UserModel findUserById(UserModel user);
    UserModel updateUser(UserModel user);
    void deleteUser(UserModel user);
}
