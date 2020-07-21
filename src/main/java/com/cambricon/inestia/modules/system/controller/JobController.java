package com.cambricon.inestia.modules.system.controller;

import com.cambricon.inestia.core.annotation.SystemLog;
import com.cambricon.inestia.core.utils.PageResultSet;
import com.cambricon.inestia.core.utils.Result;
import com.cambricon.inestia.modules.system.po.Job;
import com.cambricon.inestia.modules.system.po.News;
import com.cambricon.inestia.modules.system.query.JobQuery;
import com.cambricon.inestia.modules.system.query.NewsQuery;
import com.cambricon.inestia.modules.system.service.JobService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

/**
 * @Description: TODO
 * @author: hupengk
 * @date: 2020/7/18 20:39
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    @RequiresPermissions("job:view")
    public String page(Model model) {
        return "system/job";
    }

    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("job:view")
    public PageResultSet<Job> list(JobQuery jobQuery) {
        return jobService.findByPage(jobQuery);
    }

    @ResponseBody
    @PostMapping("/create")
    @RequiresPermissions("job:create")
    @SystemLog("创建招聘")
    public Result create(@Valid Job job) {
        jobService.createJob(job);
        return Result.success();
    }

    @ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("news:update")
    @SystemLog("更新招聘")
    public Result update(Job job) {
        jobService.updateJob(job);
        return Result.success();
    }

    @ResponseBody
    @RequiresPermissions("job:delete")
    @SystemLog("删除招聘")
    @PostMapping("/delete")
    public Result delete(@RequestParam("id") Long[] ids) {
        Arrays.asList(ids).forEach(id->
        {
            Job job = new Job();
            job.setId(id);
            job.setDr(true);
            jobService.updateJob(job);
        });
        return Result.success();
    }
}
