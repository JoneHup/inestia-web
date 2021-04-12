package com.cambricon.inestia.modules.system.query;

import com.cambricon.inestia.modules.system.base.BaseQuery;

public class ProcessQuery extends BaseQuery<ProcessQuery> {

    private String ProcessName;

    private Boolean dr;

    private Integer year;

    public String getProcessName() {
        return ProcessName;
    }

    public void setProcessName(String processName) {
        ProcessName = processName;
    }

    public Boolean getDr() {
        return dr;
    }

    public void setDr(Boolean dr) {
        this.dr = dr;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
