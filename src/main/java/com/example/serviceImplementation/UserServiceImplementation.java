package com.example.serviceImplementation;

import com.example.model.UserModel;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository repo;
    @Override
    public UserModel saveUser(UserModel user) {
        return repo.save(user);
    }

    @Override
    public List<UserModel> displayUsers() {
        return repo.findAll();
    }

    @Override
    public UserModel findUserById(UserModel user) {
        return repo.findById(user.getPhone()).orElse(null);
    }

    @Override
    public UserModel updateUser(UserModel user) {
        UserModel savedUser = repo.findById(user.getPhone()).orElse(null);
        if (savedUser!=null){
            savedUser.setUsername(user.getUsername());
            savedUser.setPhone(user.getPhone());
            savedUser.setPassword(user.getPassword());

            return repo.save(savedUser);
        }
        return repo.save(user);
    }

    @Override
    public void deleteUser(UserModel user) {
        UserModel savedUser = repo.findById(user.getPhone()).orElse(null);
        if (savedUser!=null){
            repo.delete(savedUser);
        }
    }
}
