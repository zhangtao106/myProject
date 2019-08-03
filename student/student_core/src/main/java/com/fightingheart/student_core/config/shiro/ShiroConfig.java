package com.fightingheart.student_core.config.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {


    @Bean("accountRealm")
    public AccountRealm getAccountRelam(){

        return new AccountRealm();
    }

    @Bean("securityManager")
    public DefaultWebSecurityManager getSecurityManager(@Qualifier("accountRealm") AccountRealm accountRealm){

        DefaultWebSecurityManager securityManager=  new DefaultWebSecurityManager();
        securityManager.setRealm(accountRealm);
        return securityManager;

    }

    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactory(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        bean.setSuccessUrl("/mainMenu");
        bean.setLoginUrl("/login");
        bean.setUnauthorizedUrl("/error");


        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/login","anno");
        filterMap.put("/error/noAccessable","anno");
        filterMap.put("/static/**","anon");
        filterMap.put("/**","authc");
        filterMap.put("/logout", "logout");

        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
