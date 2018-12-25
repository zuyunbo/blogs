package com.boke.config.shiro.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.boke.config.shiro.entity.PermissionInfo;
import com.boke.config.shiro.entity.UserInfo;

import java.util.List;

/**
 * @since 2018
 */
public interface PermissionInfoMapper extends BaseMapper<PermissionInfo> {

    List<PermissionInfo> selectPermByUser(UserInfo userInfo);

}
