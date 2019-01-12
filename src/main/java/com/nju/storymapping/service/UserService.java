package com.nju.storymapping.service;

import com.nju.storymapping.domain.UserInfo;
import com.nju.storymapping.respository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public UserInfo updateUser(UserInfo newUser){
        Optional<UserInfo> oldUser = userRepository.findById(newUser.getUserId());
        oldUser.get().setAvatar(newUser.getAvatar());
        oldUser.get().setEmail(newUser.getEmail());
        oldUser.get().setPassword(newUser.getPassword());
        userRepository.save(oldUser.get());
        return oldUser.get();
    }
}
