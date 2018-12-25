package com.boke.config.shiro.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.boke.config.shiro.entity.UserInfo;

import java.util.List;


/**

 * @since 2018-01-23
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    List<UserInfo> selectRoleByUser(UserInfo userInfo);

}
