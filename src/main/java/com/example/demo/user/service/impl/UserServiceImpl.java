package com.example.demo.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.common.DefaultRes;
import com.example.demo.common.ResponseMessage;
import com.example.demo.common.StatusCode;
import com.example.demo.user.mapper.UserMapper;
import com.example.demo.user.model.User;
import com.example.demo.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
    private UserMapper userMapper;

	@Override
	public int createUser(User user) {
	      return userMapper.save(user); 
	}

	@Override
	public int modifyUser(User user) {
		return userMapper.update(user);
	}
	
	
	@Override
	public int removeUser(int id) {
		return userMapper.delete(id);
	}

	@Override
	public User getUser(int id) {
		return userMapper.findByUserId(id);
 	}

	@Override
	public List<User> getUserList() {
		return userMapper.findAll();
	}  
 
}
