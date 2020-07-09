package com.cambricon.inestia.modules.system.service;


import com.cambricon.inestia.core.utils.PageResultSet;
import com.cambricon.inestia.modules.system.po.Log;
import com.cambricon.inestia.modules.system.query.LogQuery;

public interface LogService {

    /**
     * 创建日志
     * @param log
     * @return
     */
    void create(Log log);

    /**
     * 分页查询日志
     * @param log
     * @return
     */
    PageResultSet<Log> findByPage(LogQuery log);

}
