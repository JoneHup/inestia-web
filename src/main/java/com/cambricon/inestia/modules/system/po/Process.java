package com.cambricon.inestia.modules.system.po;

import com.cambricon.inestia.core.utils.DateUtil;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @Description: TODO
 * @author: hupengk
 * @date: 2020/5/12 20:23
 * @Version: 1.0
 **/
@Table(name="sys_process")
public class Process {

    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 历程标题
     */
    @NotBlank(message = "历程标题不能为空")
    private String processName;

    /**
     * 历程介绍
     */
    private String introduction;

    /**
     * 发布日期
     */
    private Date publishDate;

    @NotBlank(message = "发布日期不能为空")
    @Transient
    private String publishTime;


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

    @Transient
    private String position;

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

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
        this.publishTime = DateUtil.toDateString(this.publishDate);
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

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
