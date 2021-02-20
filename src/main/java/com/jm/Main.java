package com.jm;

import com.jm.service.UserService;
import com.jm.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        List users = userService.listUsers();
        System.out.println(users);
    }
}
