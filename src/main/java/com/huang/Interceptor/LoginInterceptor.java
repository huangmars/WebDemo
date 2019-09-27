package com.huang.Interceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;


public class LoginInterceptor implements HandlerInterceptor {

    private Logger logger = Logger.getLogger("EmployeeController.class");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        if(session.getAttribute("LOGIN_USER")!=null) {
            // 登录成功不拦截
            logger.info(session.getAttribute("LOGIN_USER").toString());
            System.out.println();
            return true;
        }else {
            // 拦截后进入登录页面

            response.sendRedirect(request.getContextPath()+"/");
            return false;
        }
    }
}
