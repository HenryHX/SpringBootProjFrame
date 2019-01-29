package com.ulknow.frame.service.impl;

import com.ulknow.frame.domain.UserDO;
import com.ulknow.frame.service.BaseService;
import com.ulknow.frame.util.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by Administrator
 * 2019-01-16
 */

public abstract class BaseServiceImpl<T> implements BaseService<T> {
    @Autowired
    protected MyMapper<T> mapper;

    /**
     * 保存实体，null的属性也会保存，不会使用数据库默认值
     * @param entity
     * @return
     */
    @Override
    public int insert(T entity) {
        return mapper.insert(entity);
    }

    /**
     * 保存实体列表
     * @param entityList
     * @return
     */
    @Override
    public int insertBatch(List<T> entityList) {
        return mapper.insertList(entityList);
    }

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @param keyValue 主键value
     * @return
     */
    @Override
    public int deleteByKey(Object keyValue) {
        return mapper.deleteByPrimaryKey(keyValue);
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param entity
     * @return
     */
    @Override
    public int updateWithNull(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    /**
     * 根据主键更新实体entity属性不为null的值
     * @param entity
     * @return
     */
    @Override
    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    /**
     * 根据主键字段进行查询
     * @param keyValue 主键value
     * @return
     */
    @Override
    public T selectByKey(Object keyValue) {
        return mapper.selectByPrimaryKey(keyValue);
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    /**
     * 根据Example条件进行查询
     * @param example 包括查询条件，通过selectProperties方法指定查询列，没有指定的列返回null
     * @return
     */
    @Override
    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }
}
