package com.beannote.beannote.user.service;

import com.beannote.beannote.common.ResponseData;

public interface UserService {
    int checkUserName(String username);

    ResponseData insertUser(String username, String password);
}
