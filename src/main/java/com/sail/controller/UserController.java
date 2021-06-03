package com.sail.controller;

import com.sail.domain.User;
import com.sail.mapper.UserMapper;
import com.sail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController{
    @Autowired
    private UserService userService;
    @RequestMapping("/submit")

    public String submit(User user, MultipartFile uploadFile,HttpServletRequest request) throws Exception {
        System.out.println(uploadFile.toString());

        String filename=uploadFile.getOriginalFilename();
        if("".equals(filename)){
            return "noPhoto";
        }
        System.out.println(filename);
        //获取文件名，不是表单中的name getName（）就是获取的表单中的name
        String basePath =request.getSession().getServletContext().getRealPath("/images");
        //basePath="D:\\IDEAworkplace\\qihang\\src\\main\\webapp\\img\\";
        File directory = new File(basePath);
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH`mm`ss`SSS_");
        String targetPath=null;

        targetPath=basePath+File.separator+format.format(date)+uploadFile.getOriginalFilename();
        user.setLifePhoto(format.format(date)+uploadFile.getOriginalFilename());

        boolean flag = userService.save(user);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        try {
            //transferTo()方法将上传的文件写到服务器指定的文件

            System.out.println(targetPath);
            if(flag)
                uploadFile.transferTo(new File(targetPath));
        } catch (Exception ignored) {
        }



        if(!flag){
            return "false";
        }

        System.out.println(user);
        return "success";
    }




}
