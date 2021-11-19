package com.example.demo.user.service;

import java.util.List;

import com.example.demo.user.model.User;
 
public interface UserService {
    public int createUser(User user);
    public int modifyUser(User user);
    public int removeUser(int id);
    public User getUser(int id);
    public List<User> getUserList(); 
}
