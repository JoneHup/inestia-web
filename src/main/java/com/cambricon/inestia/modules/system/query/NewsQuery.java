package com.cambricon.inestia.modules.system.query;

import com.cambricon.inestia.modules.system.base.BaseQuery;

/**
 * @Description: TODO
 * @author: hupengk
 * @date: 2020/5/12 20:38
 * @Version: 1.0
 **/
public class NewsQuery extends BaseQuery<NewsQuery> {

    private String title;

    private String source;

    private Boolean dr;

    private String year;

    private String month;

    private int currentPage;

    private Long newsId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Boolean getDr() {
        return dr;
    }

    public void setDr(Boolean dr) {
        this.dr = dr;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }
}
