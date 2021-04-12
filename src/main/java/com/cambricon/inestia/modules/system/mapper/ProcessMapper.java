package com.cambricon.inestia.modules.system.mapper;

import com.cambricon.inestia.core.utils.MyMapper;
import com.cambricon.inestia.modules.system.po.Process;

import java.util.List;

public interface ProcessMapper extends MyMapper<Process> {


    List<String> findAllYears();
}
