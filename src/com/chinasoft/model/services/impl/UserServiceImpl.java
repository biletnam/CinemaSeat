package com.chinasoft.model.services.impl;

import org.springframework.transaction.annotation.Transactional;

import com.chinasoft.model.dao.UsersDAO;
import com.chinasoft.model.entity.Users;
import com.chinasoft.model.services.IUserService;

public class UserServiceImpl implements IUserService {

	private UsersDAO dao;
	
	
	public UsersDAO getDao() {
		return dao;
	}
	public void setDao(UsersDAO dao) {
		this.dao = dao;
	}


	@Override
	public void regist(Users user) {
		// TODO Auto-generated method stub
		dao.save(user);
	}
	@Override
	public Users selUserByAid(String aid) {
		// TODO Auto-generated method stub
		return (Users)(dao.findByAId(aid).get(0));
	}
	@Override
	public void updateUser(Users user) {
		// TODO Auto-generated method stub
		dao.merge(user);
	}
	
	
	@Override
	@Transactional
	public short selPowerByAid(String aid) {
		// TODO Auto-generated method stub
		return dao.selPowerByAid(aid);
	}

}
