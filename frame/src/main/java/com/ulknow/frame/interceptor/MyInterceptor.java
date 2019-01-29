package com.ulknow.frame.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by Administrator
 * 2019-01-17
 */

public class MyInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = request.getRemoteAddr();
        long reqStartTime = System.currentTimeMillis();
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        logger.info("用户：{} 访问 {}", ip, method.getDeclaringClass().getName() + "." + method.getName());

        request.getSession().setAttribute("reqStartTime", reqStartTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long reqEndTime = System.currentTimeMillis();
        long reqStartTime = (long) request.getSession().getAttribute("reqStartTime");
        long executeTime = reqEndTime - reqStartTime;

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        logger.info("用户：{} 访问 {} 耗时 {} ms", request.getRemoteAddr(), method.getDeclaringClass().getName() + "." + method.getName(), executeTime);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
