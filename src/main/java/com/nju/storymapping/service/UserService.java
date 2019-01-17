package com.nju.storymapping.service;

import com.nju.storymapping.domain.UserInfo;
import com.nju.storymapping.entity.User;
import com.nju.storymapping.respository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
public interface UserService {
    HashMap<String, String> register(String username, String password);
    User getUserById(int id);
    User getUserByName(String name);
    int addUser(User user);


}
