package cn.itcast.scm.dao;

import java.util.List;

import cn.itcast.scm.entity.Page;

public interface BaseMapper<T>  {
	   //���ʵ�������Ϣ����
	    int insert(T entity);
	   
	    //���ݶ���������ѯ,��������ȷ����ֱ�Ӹ�������
	    T selectByPk(T entity);
	   
	    //���ݶ�������ɾ��
	    int deleteByPk(T entity);
	    
	    //������������ɾ��
	    int deleteByPks(String[] pks);
	   
	    //���ݶ��������޸�
	    int updateByPk(T entity);
	   
	    //���ݶ���̬����SQL���
	    List<T> selectUseDyc(T entity);
	    
		//ͨ���ؼ��ַ�ҳ��ѯ�����б�
		public List<T> selectPageList(Page<T> page);
		
		//ͨ���ؼ��ַ�ҳ��ѯ�������ܼ�¼��
		public Integer selectPageCount(Page<T> page);
		
		//ͨ���ؼ��ֶ�������ҳ��ѯ�����б�
		public List<T> selectPageListUseDyc(Page<T> page);
			
			//ͨ���ؼ��ֶ�������ҳ��ѯ�������ܼ�¼��
		public Integer selectPageCountUseDyc(Page<T> page);
	}

