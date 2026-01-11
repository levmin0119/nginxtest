package com.levmin.nginxtest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.levmin.nginxtest.entity.UserAccount;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户账号表 Mapper 接口
 * </p>
 *
 * @author zhangyue
 * @since 2026-01-11
 */
@Mapper
public interface UserAccountMapper extends BaseMapper<UserAccount> {

}
