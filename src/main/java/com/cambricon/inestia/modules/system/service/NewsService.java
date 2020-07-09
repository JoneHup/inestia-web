package com.cambricon.inestia.modules.system.service;

import com.cambricon.inestia.core.utils.PageResultSet;
import com.cambricon.inestia.modules.system.po.News;
import com.cambricon.inestia.modules.system.query.NewsQuery;

public interface NewsService {

    PageResultSet<News> findByPage(NewsQuery newsQuery);

    void createNews(News news);

    void updateNews(News news);

    void deleteNews(Long id);

    News findById(NewsQuery newsQuery);
}
