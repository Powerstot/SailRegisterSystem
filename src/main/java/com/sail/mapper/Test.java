package com.sail.mapper;

import com.sail.domain.User;

import com.sail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Test {
    @Autowired
    private UserService userService;
    public static void main(String[] args) throws IOException {
        /*InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);*/

        //查集合
        /*List<User> users = sqlSession.selectList("userMapper.find","%2019%");
        for(User user:users)
            System.out.println(user);*/

       /* User user=new User();
        user.setUsername("宋立亮");
        user.setSno("2019666666");
        user.setPhone("110");
        user.setSkills("Java核心卷I java核心卷II jvm虚拟机 各种算法 计算机网络 SSM框架");
        user.setReason("带领你们走向光明");
        sqlSession.insert("userMapper.save",user);*/


        /*sqlSession.delete("userMapper.deleteBySno","2019666666");*/

        //更新
       /* User user=new User();
        user.setUsername("宋立亮");
        user.setEmail("mihayou@cn.com");
        user.setSno("2019666666");
        user.setPhone("110");
        user.setSkills("Java核心卷I java核心卷II jvm虚拟机 各种算法 计算机网络 SSM框架");
        user.setReason("带领你们走向光明");
        sqlSession.update("userMapper.update",user);*/

       /* List<User> users = null;
        //userMapper.find("6");
        System.out.println(users);
        System.out.println(123);*/

    }

}
