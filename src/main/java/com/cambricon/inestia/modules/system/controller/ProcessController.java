package com.cambricon.inestia.modules.system.controller;

import com.cambricon.inestia.core.annotation.SystemLog;
import com.cambricon.inestia.core.utils.PageResultSet;
import com.cambricon.inestia.core.utils.Result;
import com.cambricon.inestia.modules.system.po.Process;
import com.cambricon.inestia.modules.system.query.ProcessQuery;
import com.cambricon.inestia.modules.system.service.ProcessService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

@Controller
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @GetMapping
    @RequiresPermissions("process:view")
    public String page(Model model) {
        return "system/process";
    }

    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("process:view")
    public PageResultSet<Process> list(ProcessQuery processQuery) {
        return processService.findByPage(processQuery);
    }

    @ResponseBody
    @PostMapping("/create")
    @RequiresPermissions("process:create")
    @SystemLog("创建历程")
    public Result create(@Valid Process process) {
        processService.createProcess(process);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("process:update")
    @SystemLog("更新历程")
    public Result update(Process process) {
        processService.updateProcess(process);
        return Result.success();
    }

    @ResponseBody
    @RequiresPermissions("process:delete")
    @SystemLog("删除历程")
    @PostMapping("/delete")
    public Result delete(@RequestParam("id") Long[] ids) {
        Arrays.asList(ids).forEach(id->
        {
            Process process = new Process();
            process.setId(id);
            process.setDr(true);
            processService.updateProcess(process);
        });
        return Result.success();
    }
}
