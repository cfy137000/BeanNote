package com.beannote.beannote.user.service;

import com.beannote.beannote.common.ResponseData;
import com.beannote.beannote.common.User;
import com.beannote.beannote.user.dao.UserMapper;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int checkUserName(String username) {
        return userMapper.selectByUsername(username);
    }

    public ResponseData insertUser(String username, String password){
        User user = new User();
        user.setUsername(username)
                .setPassword(password);
        try {
            int count = userMapper.insertUser(user);
            if (count == 1) {
                return ResponseData.createSuccessWithMsg("注册成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseData.createSuccessWithMsg("注册失败");
    }
}
