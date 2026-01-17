package com.levmin.nginxtest.service;

import com.levmin.nginxtest.entry.UserAccount;

public interface UserService {

    boolean saveUser(UserAccount userAccount);

    UserAccount selectUser(UserAccount userAccount);
}
