package com.levmin.nginxtest.service.impl;

import com.levmin.nginxtest.entity.UserAccount;
import com.levmin.nginxtest.mapper.UserAccountMapper;
import com.levmin.nginxtest.service.IUserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账号表 服务实现类
 * </p>
 *
 * @author zhangyue
 * @since 2026-01-11
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements IUserAccountService {

}
