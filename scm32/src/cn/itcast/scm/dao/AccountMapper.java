package cn.itcast.scm.dao;

import cn.itcast.scm.entity.Account;


public interface AccountMapper extends BaseMapper{
	//根据acc_login来查询是否存在
	Account selectByAccLogin(String accLogin);
}