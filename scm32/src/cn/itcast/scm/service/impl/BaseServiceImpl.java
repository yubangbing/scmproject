package cn.itcast.scm.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.scm.dao.AccountMapper;
import cn.itcast.scm.dao.BaseMapper;
import cn.itcast.scm.dao.GoodsMapper;
import cn.itcast.scm.dao.SupplierMapper;
import cn.itcast.scm.entity.Page;
import cn.itcast.scm.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T>{
	protected BaseMapper<T> baseMapper;
	@Autowired
	protected  SupplierMapper supplierMapper;
	@Autowired
	protected  AccountMapper accountMapper;
	@Autowired
	protected  GoodsMapper goodsMapper;
	

	@PostConstruct//�ڹ��췽���󣬳���ǰִ��
	private void initBaseMapper() throws Exception{
		//��������߼�����Ҫ���з��������������ʹ�ù淶
				//this�ؼ���ָ����������ָ���ǵ��ô˷�����ʵ���ࣨ���ࣩ
				System.out.println("=======this :"+this);
				System.out.println("=======���������Ϣ��"+this.getClass().getSuperclass());
				System.out.println("=======����ͷ��͵���Ϣ��"+this.getClass().getGenericSuperclass());
				
				ParameterizedType type =(ParameterizedType) this.getClass().getGenericSuperclass();
				//��ȡ��һ��������class
				Class clazz = (Class)type.getActualTypeArguments()[0];
				System.out.println("=======class:"+clazz);
				//ת��Ϊ����������ص�Mapper�������������Supplier  supplierMapper
				String localField = clazz.getSimpleName().substring(0,1).toLowerCase()+clazz.getSimpleName().substring(1)+"Mapper";
				System.out.println("=======localField:"+localField);
				//getDeclaredField:����ʹ���ڰ���˽�С�Ĭ�ϡ��ܱ����������ֶΣ����������̳е��ֶ�
				Field field=this.getClass().getSuperclass().getDeclaredField(localField);
				System.out.println("=======field:"+field);
				System.out.println("=======field��Ӧ�Ķ���:"+field.get(this));
				Field baseField = this.getClass().getSuperclass().getDeclaredField("baseMapper");
				
				System.out.println("=======baseField:"+baseField);
				System.out.println("=======baseField��Ӧ�Ķ���:"+baseField.get(this));	
				//field.get(this)��ȡ��ǰthis��field�ֶε�ֵ�����磺Supplier�����У�baseMapper��ָ��Ķ���Ϊ��������SupplierMapper���������Ͷ����ѱ�springʵ������������		
				baseField.set(this, field.get(this));		
				System.out.println("========baseField��Ӧ�Ķ���:"+baseMapper);

	}	
	@Override
	public int insert(T entity) throws Exception {
		return baseMapper.insert(entity);
	}
	@Override
	public T selectByPk(T entity) {
		return baseMapper.selectByPk(entity);
	}
	@Override
	public int deleteByPk(T entity) throws Exception {
		return baseMapper.deleteByPk(entity);
	}
	@Override
	public int deleteByPks(String[] pks) throws Exception {
		return baseMapper.deleteByPks(pks);
	}
	@Override
	public int updateByPk(T entity) throws Exception {
		return baseMapper.updateByPk(entity);
	}
	@Override
	public List<T> selectUseDyc(T entity) {
		return baseMapper.selectUseDyc(entity);
	}
	@Override
	public Page<T> selectPage(Page<T> page) {
		page.setLists(baseMapper.selectPageList(page));
		page.setTotal(baseMapper.selectPageCount(page));
		return page;
	}
	@Override
	public Page<T> selectPageUseDyc(Page<T> page) {
		page.setLists(baseMapper.selectPageListUseDyc(page));
		page.setTotal(baseMapper.selectPageCountUseDyc(page));
		return page;
	}
}
