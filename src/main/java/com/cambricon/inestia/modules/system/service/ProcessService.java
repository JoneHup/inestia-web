package com.cambricon.inestia.modules.system.service;

import com.cambricon.inestia.core.utils.PageResultSet;
import com.cambricon.inestia.modules.system.po.Process;
import com.cambricon.inestia.modules.system.query.ProcessQuery;

import java.util.List;

public interface ProcessService {
    PageResultSet<Process> findByPage(ProcessQuery processQuery);

    List<String> findAllYears();
}
