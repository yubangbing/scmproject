package cn.itcast.scm.dao;

import java.util.List;

import cn.itcast.scm.entity.SysParam;

public interface SysParamMapper extends BaseMapper<SysParam>{
	public List<SysParam> selectList(String type);
	public List<SysParam> selectOtherTable(String sql);
}