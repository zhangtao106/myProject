package com.fightingheart.student_core.authority.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {

    @RequestMapping("/mainMenu")
    public String getMainMenu(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        return "html/public/mainMenu";
    }

    @RequestMapping("/login")
    public String toIndex(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        return "html/public/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        return "redirect:/login";
    }
    @RequestMapping("/error")
    public String unAuth(){
        return "html/error/noAccessable";
    }
}
