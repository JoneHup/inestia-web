package com.cambricon.inestia.modules.system.service.impl;

import com.cambricon.inestia.core.utils.DateUtil;
import com.cambricon.inestia.core.utils.PageResultSet;
import com.cambricon.inestia.modules.system.mapper.ProcessMapper;
import com.cambricon.inestia.modules.system.po.Process;
import com.cambricon.inestia.modules.system.query.ProcessQuery;
import com.cambricon.inestia.modules.system.service.ProcessService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.Calendar;
import java.util.Date;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private ProcessMapper processMapper;

    @Override
    public PageResultSet<Process> findByPage(ProcessQuery processQuery) {
        /*if (!StringUtils.isEmpty(processQuery.getOrderBy())) {
            PageHelper.orderBy(processQuery.getOrderBy());
        }*/

        PageHelper.orderBy("publish_date desc");

        Weekend example = Weekend.of(Process.class);
        WeekendCriteria<Process, Object> criteria = example.weekendCriteria();

        if (!StringUtils.isEmpty(processQuery.getProcessName())) {
            criteria.andLike(Process::getProcessName, "%" + processQuery.getProcessName() + "%");
        }

        processQuery.setDr(false);
        criteria.andEqualTo(Process::getDr,processQuery.getDr());

        PageResultSet<Process> resultSet = new PageResultSet<>();

        Page page = PageHelper.offsetPage(processQuery.getOffset(), processQuery.getLimit()).doSelectPage(()->
                processMapper.selectByExample(example).forEach(e -> {
                    e.setModifyTime(DateUtil.toDateTimeString(e.getModifyDate()));
        }));

        resultSet.setRows(page.getResult());
        resultSet.setTotal(page.getTotal());
        return resultSet;
    }

    @Override
    @Transactional
    public void createProcess(Process process) {
        process.setCreateDate(new Date());
        process.setModifyDate(new Date());
        process.setPublishDate(DateUtil.toDate(process.getPublishTime()));
        processMapper.insertSelective(process);
    }

    @Override
    @Transactional
    public void updateProcess(Process process) {
        process.setModifyDate(new Date());
        if (! StringUtils.isEmpty(process.getPublishTime())) {
            process.setPublishDate(DateUtil.toDate(process.getPublishTime()));
        }
        processMapper.updateByPrimaryKeySelective(process);
    }


}
