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
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

//    @CrossOrigin(origins = "http://localhost:9528", allowedHeaders = "Access-Control-Allow-Origin")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> loginHandle(@RequestParam(value = "username") String userName,
                        @RequestParam(value = "password") String passWord) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        User user = userService.getUserByName(userName);
        String hashPass = DigestUtils.md5DigestAsHex(passWord.getBytes());

        if (user.getUsername().isEmpty()) {
            map.put("error", "用户名不存在");
            return map;
        }
        else if (!user.getPassword().equals(hashPass)) {
            map.put("error", "密码错误");
            return map;
        } else {
            map.put("success",user.getId());
            map.put("token", "admin");
            return map;
        }

    }
    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    public HashMap<String, Object> getInfo(@RequestParam(value = "token") String token) {
        HashMap<String, Object> userInfo = new HashMap<String, Object>();
        String[] role = new String[1];
        if (token.equals("admin")) {
            role[0] = "admin";
            userInfo.put("roles", role);
            userInfo.put("introduction","我是超级管理员");
            userInfo.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            userInfo.put("name","Super Admin");
        }
        return userInfo;
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public String logOut() {
        return "logout";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
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
        //返回给前台跳转到个人主页
        map.put("id",id);
        return map;

    }

    //跳转个人主页返回主页信息
    @RequestMapping(value = "/{id}/dashboard", method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String, Object> mainPage(@PathVariable String id) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        return map;
    }
}
