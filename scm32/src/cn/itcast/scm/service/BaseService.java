package cn.itcast.scm.service;

import java.util.List;

import cn.itcast.scm.entity.Page;

public interface BaseService<T> {
	   //���ʵ�������Ϣ����
    int insert(T entity) throws Exception;
   
    //���ݶ���������ѯ
    T selectByPk(T entity);
   
    //���ݶ�������ɾ��
    int deleteByPk(T entity) throws Exception;
   
    //������������ɾ��
    int deleteByPks(String [] pks) throws Exception;
    
    //���ݶ��������޸�
    int updateByPk(T entity) throws Exception;
   //���ݶ���̬��ѯ�����б�
    List<T> selectUseDyc(T entity);
    
	//ͨ���ؼ��ַ�ҳ��ѯ
	public Page<T> selectPage(Page<T> page); 
	
	
	//ͨ����������ҳ��ѯ
	public Page<T> selectPageUseDyc(Page<T> page); 
}


