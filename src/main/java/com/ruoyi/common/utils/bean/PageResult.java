package com.ruoyi.common.utils.bean;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public class PageResult {
    private int code;
    private int count;
    private List data;

    public PageResult(long total, List<T> list) {
        this.count = (int) total;
        this.data = list;
        this.code = 0;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
