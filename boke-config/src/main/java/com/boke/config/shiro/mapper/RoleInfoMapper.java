package com.boke.config.shiro.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.boke.config.shiro.entity.RoleInfo;
import com.boke.config.shiro.entity.UserInfo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huitu123
 * @since 2018-01-23
 */
public interface RoleInfoMapper extends BaseMapper<RoleInfo> {

    List<RoleInfo> selectRoleByUser(UserInfo userInfo);
}
