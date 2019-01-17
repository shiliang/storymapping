package com.nju.storymapping.controller;/*
 * @program:com.nju.storymapping.controller
 * @description:用户登录
 * @author:shiliang
 * @create:2019-01-14 21:42
 * */

import com.nju.storymapping.entity.User;
import com.nju.storymapping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginHandle(@RequestParam(value = "username") String userName,
                        @RequestParam(value = "password") String passWord) {

        return "hah";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public HashMap<String, Object> registerHandle(@RequestParam(value = "username") String userName,
                                            @RequestParam(value = "password") String passWord){
        HashMap<String, Object> map = new HashMap<String, Object>();
        User user = userService.getUserByName(userName);

        if (user != null) {
            map.put("msg", "用户名已被注册");
            return map;
        }

        user = new User();
        user.setUsername(userName);
        String hashPass = DigestUtils.md5DigestAsHex(passWord.getBytes());
        user.setPassword(hashPass);
        int userId = userService.addUser(user);
        String id = Integer.toString(userId);
        map.put("id",id);
        return map;

    }
}
