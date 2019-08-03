package com.fightingheart.student_core.util.http;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class HttpRequestInfo {
    private HttpServletRequest request;
    private String url;
    private Cookie[] cookies;
    private String userIp;

    public HttpRequestInfo(HttpServletRequest request){
        this.request = request;
        this.cookies = request.getCookies();
        this.url = request.getRequestURI()+(request.getQueryString()!= null ?"?"+request.getQueryString():"");
    }

    public static String getAppURL(HttpServletRequest request) {
        StringBuffer url = new StringBuffer();
        url.append(getUrlHostPrefix(request));
        url.append(request.getContextPath());
        return url.toString();
    }

    public static String getUrlHostPrefix(HttpServletRequest request) {
        StringBuffer url = new StringBuffer();
        int port = request.getServerPort();
        if (port < 0) {
            port = 80;
        }

        String scheme = request.getScheme();
        url.append(scheme);
        url.append("://");
        url.append(request.getServerName());
        if (scheme.equals("http") && port != 80 || scheme.equals("https") && port != 443) {
            url.append(':');
            url.append(port);
        }

        return url.toString();
    }

    public static String getUserIp(HttpServletRequest request) {
        String ip = request.getHeader("Cdn-Src-Ip");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        if (ip.indexOf(",") > -1) {
            ip = ip.substring(0, ip.indexOf(","));
        }

        return ip;
    }
}
