package com.beannote.beannote.user.controller;

import com.beannote.beannote.common.ResponseData;
import com.beannote.beannote.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserControllerImpl {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public ResponseData login(String username, String password){
        //主体提交认证请求
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            token.clear();
            return ResponseData.createSuccessWithMsg("登录失败，用户名或密码错误！");
        }
        return ResponseData.createSuccessWithMsg("登录成功");
    }

    @PostMapping("register")
    @ResponseBody
    public ResponseData register(String username, String password){

        return userService.insertUser(username,password);
    }

    @PostMapping("checkUserName")
    @ResponseBody
    public ResponseData checkUserName(String username) {
        int count = userService.checkUserName(username);
        if (count == 0){
            return ResponseData.createSuccessWithMsg("没有该用户");
        }
        return ResponseData.createSuccessWithMsg("有");
    }


}
