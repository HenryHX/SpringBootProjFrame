package com.ulknow.frame.service;

import java.util.List;

/**
 * Created by Administrator
 * 2019-01-16
 */

public interface BaseService<T> {
    int insert(T entity);

    int insertBatch(List<T> entityList);

    int deleteByKey(Object keyValue);

    int updateWithNull(T entity);

    int updateNotNull(T entity);

    T selectByKey(Object keyValue);

    List<T> selectAll();

    List<T> selectByExample(Object example);
}
