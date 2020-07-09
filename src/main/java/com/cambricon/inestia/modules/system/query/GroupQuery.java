package com.cambricon.inestia.modules.system.query;

import com.cambricon.inestia.modules.system.base.BaseQuery;
import com.cambricon.inestia.modules.system.po.Group;

/**
 * @author cjbi
 */
public class GroupQuery extends BaseQuery<Group> {
    /**
     * 组名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
