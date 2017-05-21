package cn.itcast.scm.service;

import cn.itcast.scm.entity.Account;


public interface AccountService<T> extends BaseService<T>{

	Account selectByAccLogin(String accLogin);
}
