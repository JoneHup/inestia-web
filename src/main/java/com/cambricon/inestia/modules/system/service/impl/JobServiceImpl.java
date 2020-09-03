package com.cambricon.inestia.modules.system.service.impl;

import com.cambricon.inestia.core.utils.DateUtil;
import com.cambricon.inestia.core.utils.PageResultSet;
import com.cambricon.inestia.modules.system.mapper.JobMapper;
import com.cambricon.inestia.modules.system.po.Job;
import com.cambricon.inestia.modules.system.query.JobQuery;
import com.cambricon.inestia.modules.system.service.JobService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobMapper jobMapper;

    @Override
    public PageResultSet<Job> findByPage(JobQuery jobQuery) {
        if (!StringUtils.isEmpty(jobQuery.getOrderBy())) {
            PageHelper.orderBy(jobQuery.getOrderBy());
        }

        Weekend example = Weekend.of(Job.class);
        WeekendCriteria<Job, Object> criteria = example.weekendCriteria();

        if (!StringUtils.isEmpty(jobQuery.getJobName())) {
            criteria.andLike(Job::getJobName, "%" + jobQuery.getJobName() + "%");
        }

        jobQuery.setDr(false);
        criteria.andEqualTo(Job::getDr,jobQuery.getDr());

        PageResultSet<Job> resultSet = new PageResultSet<>();

        Page page = PageHelper.offsetPage(jobQuery.getOffset(), jobQuery.getLimit()).doSelectPage(()->
                jobMapper.selectByExample(example).forEach(e -> {
                    e.setModifyTime(DateUtil.toDateTimeString(e.getModifyDate()));
        }));

        resultSet.setRows(page.getResult());
        resultSet.setTotal(page.getTotal());
        return resultSet;
    }

}
