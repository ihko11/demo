package com.example.demo.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.DefaultRes;
import com.example.demo.common.ResponseMessage;
import com.example.demo.common.StatusCode;
import com.example.demo.user.model.User;
import com.example.demo.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	UserService userService;

    @GetMapping("/users")
    public ResponseEntity getAllUsers() {
    	 List<User>  userList = userService.getUserList();
    	
        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS, userList), HttpStatus.OK);
    }
}
