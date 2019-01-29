package com.ulknow.frame.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by Administrator
 * 2019-01-15
 */

public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
