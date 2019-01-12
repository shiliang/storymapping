package com.nju.storymapping.controller;

import com.nju.storymapping.domain.UserInfo;
import com.nju.storymapping.respository.UserRepository;
import com.nju.storymapping.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository userRepository;

    private final UserService userService;


    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserInfo userInfo){
        userRepository.save(userInfo);
        return null;
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody UserInfo userInfo){
        UserInfo user = userService.updateUser(userInfo);
        return null;
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Long id){
        Optional<UserInfo> user = userRepository.findById(id);
        return null;
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return null;
    }
}
