package com.chinasoft.model.services.impl;

import org.springframework.transaction.annotation.Transactional;

import com.chinasoft.model.dao.AccountsDAO;
import com.chinasoft.model.entity.Accounts;
import com.chinasoft.model.entity.Users;
import com.chinasoft.model.services.IAccountService;
import com.chinasoft.model.services.IUserService;

public class AccountServiceImpl implements IAccountService {

	private AccountsDAO dao;
	private IUserService usi;
	
	
	public IUserService getUsi() {
		return usi;
	}
	public void setUsi(IUserService usi) {
		this.usi = usi;
	}
	public AccountsDAO getDao() {
		return dao;
	}
	public void setDao(AccountsDAO dao) {
		this.dao = dao;
	}




	@Override
	@Transactional
	public void regist(Accounts acc) {
		// TODO Auto-generated method stub
	
			dao.save(acc);
			Users user = new Users();
			user.setAId(acc.getAId());
			user.setRId("8a61737f941311e6b4d7fde481d7b4fd");
			user.setUMoney(5000.00);
			
			usi.regist(user);
		
		
	}
	
	@Override
	@Transactional
	public Accounts login(Accounts acc) {
		// TODO Auto-generated method stub
		return dao.login(acc);
	}

}










