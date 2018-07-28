package com.beannote.beannote.user.service;

import com.beannote.beannote.user.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class ShiroService {
    @Autowired
    private UserMapper userMapper;

    public String getPasswordByUsername(String username){
        if (userMapper.selectByUsername(username) == 1){
            return userMapper.getPassword(username);
        }
        return null;
    }

    public Set<String> getRolesByUserName(String username) {
        return new HashSet<String>(){{
            add("admin");
            add("user");
        }};
    }

    public Set<String> getPermissionsByUserName(String username) {
        return new HashSet<String>(){{
           add("user:delete");
           add("user:add");
        }};
    }
}
