package com.zp.web.mapper;

import com.zp.web.po.UserRole;

import java.util.List;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectByUserID(Long userId);
}