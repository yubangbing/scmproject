package cn.itcast.scm.dao;

import java.util.List;

import cn.itcast.scm.entity.BuyOrderDetail;

public interface BuyOrderDetailMapper extends BaseMapper<BuyOrderDetail>{
	public void insertList(List<BuyOrderDetail> buyOrderDetails);
}