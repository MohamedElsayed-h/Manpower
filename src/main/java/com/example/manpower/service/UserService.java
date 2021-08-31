package com.example.manpower.service;

import com.example.manpower.entity.User;
import com.example.manpower.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void saveUser(User user) {
        userRepository.save(user);
    }


    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    public User getNameByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User getUserById(long id){
        return userRepository.findById(id).orElseThrow();
    }


    public void updateUser(User user) {
        User   userToDB=userRepository.findById(user.getId()).orElseThrow();
        userToDB.setUserName(user.getUserName());
        userToDB.setFirstname(user.getFirstname());
        userToDB.setEmail(user.getEmail());
        userToDB.setPassword(user.getPassword());
        userRepository.save(userToDB);
    }
/*
    public void removeUser(long id) {
        userRepository.deleteById(id);
    }

 */



    public void removeUser(long id) {
        userRepository.deleteById(id);
    }


}
