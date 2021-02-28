package com.bh.oneproject.pojo;

/**
 * @Author:JL
 * @Date:2021/1/29
 */
public class Page {
    private String pageNo;
    private String pageCount;
    //private String ;
    public Page(){}
    public Page(String pageNo, String pageCount) {
        this.pageNo = pageNo;
        this.pageCount = pageCount;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }
}
