package com.sail.service;

import com.sail.domain.User;

import java.util.List;

public interface UserService {
    public boolean save(User user);
    public List<User> find(String key);
    public User findBySno(String sno);
    public List<User> findAll();
    public void deleteBySno(String sno);
    public void update(User user);
}
