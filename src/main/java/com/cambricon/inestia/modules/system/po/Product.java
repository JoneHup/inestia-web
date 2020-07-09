package com.cambricon.inestia.modules.system.po;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * @Description: TODO
 * @author: hupengk
 * @date: 2020/6/16 19:17
 * @Version: 1.0
 **/
@Table(name="sys_product")
public class Product {

    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 根名称
     */
    private String rootName;

    /**
     * 父节点名称
     */
    private String parentName;

    /**
     * 节点名称
     */
    private String nodeName;

    /**
     * 访问地址
     */
    private String url;

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

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getDr() {
        return dr;
    }

    public void setDr(Boolean dr) {
        this.dr = dr;
    }
}
