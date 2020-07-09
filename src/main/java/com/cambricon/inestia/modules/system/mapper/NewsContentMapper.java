package com.cambricon.inestia.modules.system.mapper;

import com.cambricon.inestia.core.utils.MyMapper;
import com.cambricon.inestia.modules.system.po.News;
import com.cambricon.inestia.modules.system.po.NewsContext;

/**
 * @Description: TODO
 * @author: hupengk
 * @date: 2020/5/12 20:31
 * @Version: 1.0
 **/
public interface NewsContentMapper extends MyMapper<NewsContext> {

    int insert(NewsContext newsContext);
}
