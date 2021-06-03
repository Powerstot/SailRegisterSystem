package com.sail.mapper;

import com.sail.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserMapper {
    public List<User> findAll();
    public void save(User user);
    public void deleteBySno(String sno);
    public List<User> find(String key);
    public void update(User user);
    public User findBySno(String sno);
}
