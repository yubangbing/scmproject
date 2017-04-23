package cn.itcast.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.scm.dao.GoodsMapper;
import cn.itcast.scm.entity.Goods;
import cn.itcast.scm.entity.Page;
import cn.itcast.scm.service.GoodsService;
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService<Goods> {

	@Autowired
	private GoodsMapper goodsmapper;
	@Override
	public int insert(Goods entity) throws Exception {
		return goodsmapper.insert(entity);
	}

	@Override
	public Goods selectByPk(Goods entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPk(Goods entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPk(Goods entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Goods> selectUseDyc(Goods entity) {
		// TODO Auto-generated method stub
		return null;
	}

	//单条件分页查询
	@Override
	public Page<Goods> selectPage(Page<Goods> page) {
		page.setLists(goodsmapper.selectPageList(page));
		page.setTotal(goodsmapper.selectPageCount(page));
		return page;
	}

	@Override
	public Page<Goods> selectPageUseDyc(Page<Goods> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPks(String[] pks) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


}
