package com.cambricon.inestia.modules.system.query;

import com.cambricon.inestia.modules.system.base.BaseQuery;

public class JobQuery extends BaseQuery<JobQuery> {

    private String JobName;

    private Boolean dr;

    public String getJobName() {
        return JobName;
    }

    public void setJobName(String jobName) {
        JobName = jobName;
    }

    public Boolean getDr() {
        return dr;
    }

    public void setDr(Boolean dr) {
        this.dr = dr;
    }
}
