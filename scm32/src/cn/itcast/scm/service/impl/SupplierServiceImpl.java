package cn.itcast.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.scm.dao.SupplierMapper;
import cn.itcast.scm.entity.Page;
import cn.itcast.scm.entity.Supplier;
import cn.itcast.scm.service.SupplierService;
@Service("supplierService")
public class SupplierServiceImpl extends BaseServiceImpl<Supplier> implements SupplierService<Supplier> {
/*	@Autowired
	private SupplierMapper<Supplier> suppliermapper;
	
	@Override
	public int insert(Supplier entity) throws Exception {
		return suppliermapper.insert(entity);
	}

	@Override
	public Supplier selectByPk(Supplier entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPk(Supplier entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPk(Supplier entity) throws Exception {
		return suppliermapper.updateByPk(entity);
	}

	@Override
	public List<Supplier> selectUseDyc(Supplier entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Supplier> selectPage(Page<Supplier> page) {
		List<Supplier> list=suppliermapper.selectPageList(page);
		int count=suppliermapper.selectPageCount(page);
		page.setLists(list);
		page.setTotal(count);
		return page;
	}

	@Override
	public Page<Supplier> selectPageUseDyc(Page<Supplier> page) {
		page.setLists(suppliermapper.selectPageListUseDyc(page));
		page.setTotal(suppliermapper.selectPageCountUseDyc(page));
		return page;
	}

	@Override
	public int deleteByPks(String[] pks) throws Exception {
		return suppliermapper.deleteByPks(pks);
	}*/
}
