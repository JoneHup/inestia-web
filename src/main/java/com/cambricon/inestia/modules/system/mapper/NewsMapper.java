package com.cambricon.inestia.modules.system.mapper;

import com.cambricon.inestia.core.utils.MyMapper;
import com.cambricon.inestia.modules.system.po.News;

/**
 * @Description: TODO
 * @author: hupengk
 * @date: 2020/5/12 20:31
 * @Version: 1.0
 **/
public interface NewsMapper extends MyMapper<News> {

    News selectLatestNews();
}
