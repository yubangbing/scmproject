package cn.itcast.scm.dao;

import cn.itcast.scm.entity.Account;


public interface AccountMapper extends BaseMapper{
	//����acc_login����ѯ�Ƿ����
	Account selectByAccLogin(String accLogin);
}