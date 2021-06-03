package com.sail.controller;

import com.sail.domain.User;
import com.sail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @RequestMapping("/sll_thinking_peach")
    public String operate(){
        return "admin";
    }
    @RequestMapping("/find")
    @ResponseBody
    public List<User> find(String key){
        System.out.println(key);
        return userService.find(key);
    }
    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll(){
//        System.out.println(userService.findAll());
        return userService.findAll();
    }
    @RequestMapping("/deleteBySno")
    @ResponseBody
    public String deleteBySno(String sno){
        userService.deleteBySno(sno);
        return "success";
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(User user){
        userService.update(user);
        return "success";
    }

}
