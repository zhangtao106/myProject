package com.fightingheart.student_core.testController;

import com.alibaba.fastjson.JSONObject;
import com.fightingheart.student_core.util.http.HttpRequestInfo;
import com.fightingheart.student_core.util.http.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/test")
public class HomeController {


    @RequestMapping("/testHello")
    public void testHello(HttpServletRequest request, HttpServletResponse response){
        HttpRequestInfo requestInfo = new HttpRequestInfo(request);
        String ip = requestInfo.getUserIp(request);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ip",ip);
        jsonObject.put("code",1);
        ResponseUtil.returnMsg(response,jsonObject.toJSONString());
        return;
    }

}
