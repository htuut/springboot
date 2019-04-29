package com.htuut.annotationdemo.service;


import com.htuut.annotationdemo.annotation.DoSomething;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @DoSomething(key = "#id", value = "user")
    public void getUserById(String id) {

        System.out.println("======== in ========");

    }





}
