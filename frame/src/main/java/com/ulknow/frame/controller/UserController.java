package com.ulknow.frame.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.ulknow.frame.config.DruidConfig;
import com.ulknow.frame.domain.UserDO;
import com.ulknow.frame.service.UserService;
import com.ulknow.frame.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator
 * 2019-01-16
 */

@Controller
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    DruidConfig config;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object queryByKey(@PathVariable Long id) {
        UserDO userDO = userService.selectByKey(id);

        return userDO;
    }

    @RequestMapping(value = "/user/list")
    @ResponseBody
    public String queryAll() {
        List<UserDO> userDOList = userService.selectAll();

        return JSON.toJSONString(userDOList);
    }

    @RequestMapping(value = "/user/page")
    @ResponseBody
    public Object queryByPage(Page page) {
        PageInfo<UserDO> pageInfo = userService.selectByPage(page);
        return pageInfo;
    }
}
