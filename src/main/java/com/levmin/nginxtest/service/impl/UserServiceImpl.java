package com.levmin.nginxtest.service.impl;

import com.levmin.nginxtest.entry.UserAccount;
import com.levmin.nginxtest.entry.UserAccountExample;
import com.levmin.nginxtest.mapper.UserAccountMapper;
import com.levmin.nginxtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserAccountMapper userAccountMapper;

    @Override
    public boolean saveUser(UserAccount userAccount) {
        int insert = userAccountMapper.insert(userAccount);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    @Override
    public UserAccount selectUser(UserAccount userAccount) {
        UserAccount userAccountResult = userAccountMapper.selectByPrimaryKey(userAccount.getId());
        return userAccountResult;
    }
}
