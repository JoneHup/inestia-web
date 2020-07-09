package com.cambricon.inestia.core.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 通用分页返回结果集
 *
 * @author cjbi
 */
public class PageResultSet<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 总数
     */
    private long total;
    /**
     * 返回的行数
     */
    private List<T> rows;

    /**
     * 获取更多新闻
     */
    private List<T> randomRows;

    private int currentPage;

    private long totalPage;

    private List<Long> pageList;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
        long totalPage = total % 6 == 0 ? total/6 : total/6 + 1;
        List<Long> list = new ArrayList<>();
        for (long i = 1; i <= totalPage; i++) {
            list.add(i);
        }
        this.pageList = list;
        this.totalPage = totalPage;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<Long> getPageList() {
        return pageList;
    }

    public void setPageList(List<Long> pageList) {
        this.pageList = pageList;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public List<T> getRandomRows() {
        return randomRows;
    }

    public void setRandomRows(List<T> randomRows) {
        this.randomRows = randomSub(this.rows, 4);
    }

    public static <T> List randomSub(List<T> tl, int n) {
        int count = tl.size()>n?n:tl.size();
        Random r = ThreadLocalRandom.current();
        //避免修改原列表
        List<T> temp = new ArrayList<>(tl);
        //记录返回列表
        List<T> list = new ArrayList<>(count);
        for (int i=0;i<count;i++) {
            int t=r.nextInt(temp.size());
            list.add(temp.get(t));
            temp.remove(t);
        }
        return list;
    }
}
