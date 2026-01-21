package com.levmin.nginxtest.service.impl;

import com.levmin.nginxtest.entry.UserAccount;
import com.levmin.nginxtest.entry.UserAccountExample;
import com.levmin.nginxtest.mapper.UserAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccountExample userAccountExample = new UserAccountExample();
        UserAccountExample.Criteria criteria = userAccountExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<UserAccount> userAccounts =
                userAccountMapper.selectByExample(userAccountExample);
        if (null == userAccounts.get(0)){
            throw new UsernameNotFoundException("用户不存在");
        }
        return User.builder()
                .username(userAccounts.get(0).getUsername())
                .password(userAccounts.get(0).getPassword())
                .authorities("ROLE_USER")
                .build();

    }
}
