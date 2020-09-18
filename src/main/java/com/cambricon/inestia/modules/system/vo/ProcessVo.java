package com.cambricon.inestia.modules.system.vo;

import com.cambricon.inestia.modules.system.po.Process;

import java.util.List;

public class ProcessVo {

    private int year;
    private List<Process> processes;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }
}
