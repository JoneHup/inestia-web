package com.cambricon.inestia.modules.system.service;

import com.cambricon.inestia.core.utils.PageResultSet;
import com.cambricon.inestia.modules.system.po.Process;
import com.cambricon.inestia.modules.system.query.ProcessQuery;

public interface ProcessService {
    PageResultSet<Process> findByPage(ProcessQuery processQuery);

    void createProcess(Process process);

    void updateProcess(Process process);
}
