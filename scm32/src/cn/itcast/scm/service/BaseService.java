package cn.itcast.scm.service;

import java.util.List;

import cn.itcast.scm.entity.Page;

public interface BaseService<T> {
	   //添加实体对象信息到表
    int insert(T entity) throws Exception;
   
    //根据对象主键查询
    T selectByPk(T entity);
   
    //根据对象主键删除
    int deleteByPk(T entity) throws Exception;
   
    //根具主键数组删除
    int deleteByPks(String [] pks) throws Exception;
    
    //根据对象主键修改
    int updateByPk(T entity) throws Exception;
   //根据对象动态查询对象列表
    List<T> selectUseDyc(T entity);
    
	//通过关键字分页查询
	public Page<T> selectPage(Page<T> page); 
	
	
	//通过多条件分页查询
	public Page<T> selectPageUseDyc(Page<T> page); 
}


