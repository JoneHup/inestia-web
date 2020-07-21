package com.cambricon.inestia.modules.system.po;

import com.cambricon.inestia.core.utils.DateUtil;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: TODO
 * @author: hupengk
 * @date: 2020/5/12 20:23
 * @Version: 1.0
 **/
@Table(name="sys_job")
public class Job {

    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 岗位名称
     */
    @NotBlank(message = "岗位名称不能为空")
    private String jobName;

    /**
     * 岗位职责
     */
    private String jobDescription;

    /**
     * 岗位要求
     */
    private String jobRequire;

    /**
     * 工作地点
     */
    private String jobsite;

    /**
     * 创建时间
     */
    private Date createDate;

    @Transient
    private String createTime;

    /**
     * 修改时间
     */
    private Date modifyDate;

    @Transient
    private String modifyTime;


    /**
     * 删除标识
     */
    private Boolean dr = Boolean.FALSE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobRequire() {
        return jobRequire;
    }

    public void setJobRequire(String jobRequire) {
        this.jobRequire = jobRequire;
    }

    public String getJobsite() {
        return jobsite;
    }

    public void setJobsite(String jobsite) {
        this.jobsite = jobsite;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Boolean getDr() {
        return dr;
    }

    public void setDr(Boolean dr) {
        this.dr = dr;
    }
}
