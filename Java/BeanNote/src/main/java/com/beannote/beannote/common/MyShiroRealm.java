package com.beannote.beannote.common;

import com.beannote.beannote.user.service.ShiroService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.Set;


public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    public ShiroService shiroService;

    {
        setName("MyShiroRealm");
    }

    /**
     * 授权,获取权限数据的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String username = (String) principals.getPrimaryPrincipal();

        // 通过用户获取角色数据
        Set<String> roles = shiroService.getRolesByUserName(username);

        Set<String> permissions = shiroService.getPermissionsByUserName(username);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(permissions);
        authorizationInfo.setRoles(roles);
        return authorizationInfo;
    }



    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户账号
        String username = token.getPrincipal().toString();

        String password = shiroService.getPasswordByUsername(username);
        if (password != null) {
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    username,   //认证通过后，存放在session,一般存放user对象
                    password,   //用户数据库中的密码
                    getName());    //返回Realm名
            return authenticationInfo;
        }
        return null;
    }
}
