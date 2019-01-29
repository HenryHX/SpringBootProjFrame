package com.ulknow.frame.controller;

import com.ulknow.frame.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator
 * 2019-01-29
 */

@Controller
public class BaseErrorController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/ex/{id}")
    @ResponseBody
    public String error(ModelMap modelMap, @PathVariable int id) {
        System.out.println(modelMap.get("param"));
        System.out.println(id);

        try {
            int i = 1 / 0;
        } catch (Exception e) {
//            throw new BusinessException("业务逻辑出错", e);
            throw e;
        }
        return "ex错误";
    }

    /*@RequestMapping(value = "/error/500")
    @ResponseBody
    public String showServerError() {
        return "server error";
    }*/

    /**
     * 先进行ExceptionHandler， 没有再执行/error/500
     * @param e
     * @return
     */
    //@ExceptionHandler(Exception.class)
    @ResponseBody
    public String exHandler(Exception e) {
        if (e instanceof ArithmeticException) {
            return "ArithmeticException: /0";
        } else {
            return "发生了未知异常";
        }
    }
}
