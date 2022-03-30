package com.ruoyi.common.utils.bean;

public class PageData {
    private int limit = 20;
    private int page = 1;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "PageData{" +
                "limit=" + limit +
                ", page=" + page +
                '}';
    }
}
