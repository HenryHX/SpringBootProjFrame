package com.ulknow.frame.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ulknow.frame.domain.UserDO;
import com.ulknow.frame.service.UserService;
import com.ulknow.frame.util.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator
 * 2019-01-16
 */

@Service
public class UserServiceImpl extends BaseServiceImpl<UserDO> implements UserService {
    @Override
    public PageInfo<UserDO> selectByPage(Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<UserDO> userDOList = mapper.selectAll();
        PageInfo<UserDO> pageInfo = new PageInfo<>(userDOList);
        return pageInfo;
    }
}
