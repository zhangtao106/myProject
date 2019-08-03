package com.fightingheart.student_core.util.http;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseUtil {
    protected  HttpServletResponse response;

    public ResponseUtil(HttpServletResponse response){
        this.response = response;
    }
    public static void returnMsg(HttpServletResponse response,String content){
        response.setHeader("contentType","html/text,charset=UTF-8");
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            printWriter.write(content);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != printWriter){
                printWriter.close();
            }
        }
    }
}
