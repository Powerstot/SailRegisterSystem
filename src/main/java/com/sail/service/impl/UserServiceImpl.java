package com.sail.service.impl;

import com.sail.domain.User;
import com.sail.mapper.UserMapper;
import com.sail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserMapper userMapper;
    @Override
    public boolean save(User user) {
        if(findBySno(user.getSno())!=null)
            return false;
        userMapper.save(user);

        if(userMapper.findBySno(user.getSno())!=null)
            return true;
        else
            return false;
    }

    @Override
    public List<User> find(String key) {
        return userMapper.find("%"+key+"%");
    }

    @Override
    public User findBySno(String sno) {
        return userMapper.findBySno(sno);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void deleteBySno(String sno) {
        userMapper.deleteBySno(sno);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

}
