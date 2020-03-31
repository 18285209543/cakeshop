package com.cakeshop.model;

import java.util.List;

/**
 * @author Page
 * @Date 2020/3/31 10:14
 * @Description 分页数据模型
 */
public class Page {
    private int pageNumber; // 当前是第几页
    private int pageSize;   // 每一页显示多少条数据
    private int totalCount; // 总记录数 数据总个数
    private int totalPage;  // 总页数

    private List<Object> list;

    // 总页数
    public void setPageSizeAndTotalCount(){
        // 总记录数/pageSize = 总页数    向上取整
        // 100 / 10 = 10
        totalPage = (int) Math.ceil((double) totalCount/pageSize);

    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
