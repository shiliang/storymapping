package com.nju.storymapping.service;

import com.nju.storymapping.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;


public interface UserService {
    HashMap<String, String> register(String username, String password);
    User getUserById(int id);
    User getUserByName(String name);
    User addUser(User user);
    String addLoginTicket(long userId);


}
