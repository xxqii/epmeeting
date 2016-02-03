package com.epmeeting.utils;

/**
 * Created by chqi on 2016/1/31.
 */
public class Page {
    /**
     * 总记录数目
     */
    private int totalCount = 0;
    /**
     * 总页数
     */
    private int totalPageCount = 0;

    /**
     * 第几页,默认显示第一页
     */
    private int page = 1;
    /**
     * 每页记录数,默认每页显示30条记录
     */
    private int pageSize = 10;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }
}
