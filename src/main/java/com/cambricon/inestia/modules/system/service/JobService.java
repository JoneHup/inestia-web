package com.cambricon.inestia.modules.system.service;

import com.cambricon.inestia.core.utils.PageResultSet;
import com.cambricon.inestia.modules.system.po.Job;
import com.cambricon.inestia.modules.system.query.JobQuery;

public interface JobService {
    PageResultSet<Job> findByPage(JobQuery jobQuery);

}
