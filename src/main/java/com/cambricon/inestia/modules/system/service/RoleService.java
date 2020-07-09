package com.cambricon.inestia.modules.system.service;


import com.cambricon.inestia.core.utils.PageResultSet;
import com.cambricon.inestia.modules.system.dto.RoleDto;
import com.cambricon.inestia.modules.system.po.Role;
import com.cambricon.inestia.modules.system.query.RoleQuery;

import java.util.List;
import java.util.Set;

public interface RoleService {

    PageResultSet<RoleDto> findByPage(RoleQuery roleQuery);

    void createRole(Role role);

    void updateRole(Role role);

    void deleteRole(Long roleId);

    Role findOne(Long roleId);

    List<Role> findAll();

    /**
     * 根据角色编号得到角色标识符列表
     * @param roleIds
     * @return
     */
    Set<String> findRoles(Long... roleIds);

    /**
     * 根据角色编号得到权限字符串列表
     * @param roleIds
     * @return
     */
    Set<String> findPermissions(Long[] roleIds);
}
