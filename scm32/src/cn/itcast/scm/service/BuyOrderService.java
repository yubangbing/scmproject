package cn.itcast.scm.service;

import cn.itcast.scm.entity.BuyOrder;

public interface BuyOrderService extends BaseService<BuyOrder>{
	public int insertBuyOrder(BuyOrder buyOrder) throws Exception;
}
