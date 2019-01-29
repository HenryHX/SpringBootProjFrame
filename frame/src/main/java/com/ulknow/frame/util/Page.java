package com.ulknow.frame.util;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Administrator
 * 2019-01-17
 */

public class Page {
    private int pageNum;
    private int pageSize;
    private Map<String, Object> queryCondition;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, Object> getQueryCondition() {
        return queryCondition;
    }

    public void setQueryCondition(Map<String, Object> queryCondition) {
        this.queryCondition = queryCondition;
    }
}
