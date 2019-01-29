package com.ulknow.frame.service;

import com.github.pagehelper.PageInfo;
import com.ulknow.frame.domain.UserDO;
import com.ulknow.frame.util.Page;

import java.util.List;

/**
 * Created by Administrator
 * 2019-01-16
 */

public interface UserService extends BaseService<UserDO> {
    PageInfo<UserDO> selectByPage(Page page);
}
