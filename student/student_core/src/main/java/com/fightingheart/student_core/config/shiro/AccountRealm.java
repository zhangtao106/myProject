package com.fightingheart.student_core.config.shiro;

import com.fightingheart.student_core.authority.entity.Account;
import com.fightingheart.student_core.authority.service.AccountService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

public class AccountRealm extends AuthorizingRealm {

    @Autowired(required = false)
    private AccountService accountService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("aaa");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("bbb");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Example example = new Example(Account.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("account",token.getUsername());
        Account account = accountService.selectListByExample(example).get(0);
        if(null == account){
            return null;
        }
        return new SimpleAuthenticationInfo("",account.getPassword(),"");
    }
}
