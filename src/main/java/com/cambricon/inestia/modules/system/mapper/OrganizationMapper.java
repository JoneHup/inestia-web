package com.cambricon.inestia.modules.system.mapper;

import com.cambricon.inestia.core.utils.MyMapper;
import com.cambricon.inestia.modules.system.po.Organization;

public interface OrganizationMapper extends MyMapper<Organization> {

    int updateSalefParentIds(String makeSelfAsParentIds);
}