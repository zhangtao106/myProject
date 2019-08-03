package com.fightingheart.student_core.authority.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin/account")
public class AccountController {

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        // 1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        // 2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        // 3.执行登录方法
        if(!StringUtils.isEmpty(userName)) {
            try {
                subject.login(token);
                return "html/public/mainMenu";
            } catch (UnknownAccountException e) {
                System.out.println("用户名不存在！");
                modelMap.addAttribute("msg", "用户名不存在！");
                return "html/public/login";
            } catch (IncorrectCredentialsException e) {
                System.out.println("密码错误！");
                modelMap.addAttribute("msg", "密码错误！");
                return "html/public/login";
            }
        }
        modelMap.addAttribute("msg", "用户信息不能为空！");
        return "html/public/login";
    }
}
