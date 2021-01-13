package org.BG.Controller;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
        HttpSession session = request.getSession(false);
//        System.out.println("session : "+session);
//        System.out.println("reqeust : "+request.getSession(false));

        if(session == null) {
            response.sendRedirect(request.getContextPath()+"/login.do");
            return false;
        }

        Boolean isLogin = (Boolean) session.getAttribute("isLogin");

        if(isLogin == null || !isLogin) {
            response.sendRedirect(request.getContextPath()+"/login.do");
            return false;
        }
        return true;
    }
}
