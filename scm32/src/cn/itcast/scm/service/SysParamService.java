package cn.itcast.scm.service;

import java.util.Map;

import cn.itcast.scm.entity.SysParam;

public interface SysParamService extends BaseService<SysParam> {
    public Map<String,Object>selectList();
	 
}
