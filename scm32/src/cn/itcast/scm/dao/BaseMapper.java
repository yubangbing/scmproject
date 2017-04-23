package cn.itcast.scm.dao;

import java.util.List;

import cn.itcast.scm.entity.Page;

public interface BaseMapper<T>  {
	   //添加实体对象信息到表
	    int insert(T entity);
	   
	    //根据对象主键查询,主键还不确定，直接给个对象
	    T selectByPk(T entity);
	   
	    //根据对象主键删除
	    int deleteByPk(T entity);
	    
	    //根具主键数组删除
	    int deleteByPks(String[] pks);
	   
	    //根据对象主键修改
	    int updateByPk(T entity);
	   
	    //根据对象动态生成SQL语句
	    List<T> selectUseDyc(T entity);
	    
		//通过关键字分页查询数据列表
		public List<T> selectPageList(Page<T> page);
		
		//通过关键字分页查询，返回总记录数
		public Integer selectPageCount(Page<T> page);
		
		//通过关键字多条件分页查询数据列表
		public List<T> selectPageListUseDyc(Page<T> page);
			
			//通过关键字多条件分页查询，返回总记录数
		public Integer selectPageCountUseDyc(Page<T> page);
	}

