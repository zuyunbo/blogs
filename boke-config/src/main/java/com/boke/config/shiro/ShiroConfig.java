package com.boke.config.shiro;

import com.boke.config.shiro.entity.RoleInfo;
import com.boke.config.shiro.entity.UserInfo;
import com.boke.config.shiro.mapper.PermissionInfoMapper;
import com.boke.config.shiro.mapper.RoleInfoMapper;
import com.boke.config.shiro.mapper.UserInfoMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Component
public class ShiroConfig {


    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource    private RoleInfoMapper roleInfoMapper;
    @Resource
    private PermissionInfoMapper permissionInfoMapper;


    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroConfig.class);


    @Bean  // 配置Shirl过滤器
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/ajaxLogin", "anon");
        filterChainDefinitionMap.put("/admin", "anon");
        filterChainDefinitionMap.put("/ueditor/**","anon");
        filterChainDefinitionMap.put("/boke/boke-main/templates/**","anon");
        filterChainDefinitionMap.put("/boke/title/**", "anon");
        filterChainDefinitionMap.put("/boke/article/**", "anon");
        filterChainDefinitionMap.put("/zu/bo/**", "anon");

        // 静态资源无须身份验证
        filterChainDefinitionMap.put("/**", "authc");
        //authc表示需要验证身份才能访问，还有一些比如anon表示不需要验证身份就能访问等。

        // 表示现在要配置是一个安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 出现错误之后的跳转路径
        shiroFilterFactoryBean.setLoginUrl("/index");
        //  登录成功之后的跳转访问路径
/*
        shiroFilterFactoryBean.setSuccessUrl("/index");
*/
        // shiro里面需要针对与所有的路径进行配置，所有的配置需要通过文本的形式设置
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public AuthorizingRealm myShiroRealm() {

        AuthorizingRealm myShiroRealm = new AuthorizingRealm() {


            @Override
            protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
                LOGGER.info("认证 shiro+++++++++)");
                String username = (String) authenticationToken.getPrincipal();
                UserInfo user = new UserInfo();
                user.setUsername(username);
                UserInfo userInfo = userInfoMapper.selectOne(user);
                if (userInfo == null) {
                    //没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常
                    return null;
                }
                SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                        userInfo, //用户名
                        userInfo.getPassword(), //密码
                        getName()  //realm name
                );
                return authenticationInfo;

            }

            @Override
            protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
                LOGGER.info("权限认证 shiro+++++++++)");
                SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
                UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();

                List<RoleInfo> roles = roleInfoMapper.selectRoleByUser(userInfo);
                for (RoleInfo role : roles) {
                    authorizationInfo.addRole(role.getName());
                }
                permissionInfoMapper.selectPermByUser(userInfo).forEach(sysPermission -> {
                     authorizationInfo.addStringPermission(sysPermission.getPermission());
                 });


                return authorizationInfo;
            }

        };

        return myShiroRealm;
    }

    @Bean    // 配置SecurityManager管理
    public SecurityManager securityManager(AuthorizingRealm myShiroRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm);
        return securityManager;
    }


    /**
     *  开启shiro aop注解支持.
     *  使用代理方式;所以需要开启代码支持;
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }


}
