package cn.itcast.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.scm.dao.AccountMapper;
import cn.itcast.scm.entity.Account;
import cn.itcast.scm.entity.Page;
import cn.itcast.scm.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService<Account> {

	@Autowired
	private AccountMapper accountmapper;
	
	@Override
	public int insert(Account entity) throws Exception {
		int i =0 ;
		i = accountmapper.insert(entity);
//		int j=1/0;
		return i;
	}

	@Override
	public Account selectByPk(Account entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPk(Account entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPk(Account entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Account> selectUseDyc(Account entity) {
		List<Account> list=accountmapper.selectUseDyc(entity);
		return list;
	}

	@Override
	public Page<Account> selectPage(Page<Account> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Account> selectPageUseDyc(Page<Account> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPks(String[] pks) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


}
