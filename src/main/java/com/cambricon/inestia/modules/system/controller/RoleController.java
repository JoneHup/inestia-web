package com.cambricon.inestia.modules.system.controller;

import com.cambricon.inestia.core.annotation.SystemLog;
import com.cambricon.inestia.core.utils.PageResultSet;
import com.cambricon.inestia.core.utils.Result;
import com.cambricon.inestia.modules.system.base.BaseController;
import com.cambricon.inestia.modules.system.dto.RoleDto;
import com.cambricon.inestia.modules.system.po.Role;
import com.cambricon.inestia.modules.system.query.RoleQuery;
import com.cambricon.inestia.modules.system.service.ResourceService;
import com.cambricon.inestia.modules.system.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

/**
 * @author cjbi
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private ResourceService resourceService;

    @GetMapping
    @RequiresPermissions("role:view")
    public String page(Model model) {
        setCommonData(model);
        return "system/role";
    }

    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("role:view")
    public PageResultSet<RoleDto> list(RoleQuery roleQuery) {
        return roleService.findByPage(roleQuery);
    }

    @ResponseBody
    @RequiresPermissions("role:create")
    @SystemLog("角色管理创建角色")
    @PostMapping("/create")
    public Result create(@Valid Role role) {
        roleService.createRole(role);
        return Result.success();
    }

    @ResponseBody
    @RequiresPermissions("role:update")
    @SystemLog("角色管理更新角色")
    @PostMapping("/update")
    public Result update(@Valid Role role) {
        roleService.updateRole(role);
        return Result.success();
    }

    @ResponseBody
    @RequiresPermissions("role:delete")
    @SystemLog("角色管理删除角色")
    @PostMapping("/delete")
    public Result delete(@RequestParam("id") Long[] ids) {
        Arrays.asList(ids).forEach(id-> roleService.deleteRole(id));
        return Result.success();
    }

    private void setCommonData(Model model) {
        model.addAttribute("resourceList", resourceService.findAll());
    }

}
