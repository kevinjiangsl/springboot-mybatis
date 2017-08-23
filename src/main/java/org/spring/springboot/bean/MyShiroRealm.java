package org.spring.springboot.bean;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.spring.springboot.domain.User;
import org.spring.springboot.service.RoleService;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by Selim on 2017/8/14.
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;


    /**

     * 认证信息.(身份验证) : Authentication 是用来验证用户身份

     *

     * @param

     * @return

     * @throws AuthenticationException

     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User user = new User();
        user.setNickname(token.getUsername());
        user.setPswd(String.valueOf(token.getPassword()));
        // 从数据库获取对应用户名密码的用户
        User findUser = null;
        List<User> userList = userService.listByDomain(user);
        if(userList.size()!=0){
            findUser = userList.get(0);
        }
        if (null == findUser) {
            throw new AccountException("帐号或密码不正确！");
        }else if(findUser.getStatus()==0){
            /**
             * 如果用户的status为禁用。那么就抛出<code>DisabledAccountException</code>
             */
            throw new DisabledAccountException("帐号已经禁止登录！");
        }else{
            //更新登录时间 last login time
            findUser.setLastLoginTime(new Date());
            userService.update(findUser);
        }
        return new SimpleAuthenticationInfo(findUser, findUser.getPswd(), getName());

    }

    /**

     * 授权

     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        System.out.println("权限认证方法：MyShiroRealm.doGetAuthorizationInfo()");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Long userId = user.getId();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        /*//根据用户ID查询角色（role），放入到Authorization里。
        Role role = new Role();
        role.set
		List<Role> roleList = roleService.listByDomain(map);

		Set<String> roleSet = new HashSet<String>();

		for(Role role : roleList){

			roleSet.add(role.getType());

		}*/
        Set<String> roleSet = new HashSet<String>();
        roleSet.add("100002");
        info.setRoles(roleSet);
        //根据用户ID查询权限（permission），放入到Authorization里。

		/*List<SysPermission> permissionList = sysPermissionService.selectByMap(map);

		Set<String> permissionSet = new HashSet<String>();

		for(SysPermission Permission : permissionList){

			permissionSet.add(Permission.getName());

		}*/
        Set<String> permissionSet = new HashSet<String>();
        permissionSet.add("权限添加");
        permissionSet.add("权限删除");
        info.setStringPermissions(permissionSet);
        return info;
    }
}
