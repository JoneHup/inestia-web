package com.cambricon.inestia.modules.system.query;

import com.cambricon.inestia.modules.system.base.BaseQuery;
import com.cambricon.inestia.modules.system.po.User;

public class UserQuery extends BaseQuery<User> {

    /**
     * 用户名
     */
    private String username;

    private Boolean locked;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
}
