package com.zp.web.service;

import com.zp.web.mapper.PermissionMapper;
import com.zp.web.mapper.RoleMapper;
import com.zp.web.mapper.UserMapper;
import com.zp.web.mapper.UserRoleMapper;
import com.zp.web.po.Permission;
import com.zp.web.po.Role;
import com.zp.web.po.User;
import com.zp.web.po.UserRole;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Zhang Peng on 2016/9/23.
 */
@Service
@Transactional
public class MyShiro extends AuthorizingRealm {

    @Autowired
    private UserMapper userDAO;
    @Autowired
    private UserRoleMapper userRoleDAO;
    @Autowired
    private RoleMapper roleDAO;
    @Autowired
    private PermissionMapper permissionsDAO;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("doGetAuthorizationInfo");
        String username = (String) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        User user = userDAO.selectByName(username);

        Set<String> roles = getUserRoles(user.getId());
        authorizationInfo.setRoles(roles);

        Set<String> permissions = getPermissions(user.getId());
        authorizationInfo.setStringPermissions(permissions);

        return authorizationInfo;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("doGetAuthenticationInfo");
        //以上校验码验证通过以后,查数据库
        String username = (String) authenticationToken.getPrincipal();
        User user = userDAO.selectByName(username);

        if (user == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserName(), //用户名
                user.getPwd(), //密码
                getName()  //realm name
        );
        return authenticationInfo;
    }

    private Set<String> getUserRoles(Long userId) {
        Set<String> roles = new HashSet<String>();
        List<UserRole> list = userRoleDAO.selectByUserID(userId);
        for (int i = 0; i < list.size(); i++) {
            Long roleId = list.get(i).getRoleId();
            Role role = roleDAO.selectByPrimaryKey(roleId);
            roles.add(role.getRoleName());
        }
        return roles;
    }

    private Set<String> getPermissions(Long userId) {
        Set<String> premissions = new HashSet<String>();
        List<UserRole> list = userRoleDAO.selectByUserID(userId);
        for (int i = 0; i < list.size(); i++) {
            Long roleId = list.get(i).getRoleId();
            List<Permission> permissionList = permissionsDAO.selectByRoleId(roleId);
            premissions.add(permissionList.get(0).getPermissionName());
        }
        return premissions;
    }
}
