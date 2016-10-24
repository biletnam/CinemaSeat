package com.chinasoft.model.services;

import com.chinasoft.model.entity.Accounts;

public interface IAccountService {

	//注册
	public abstract void regist(Accounts acc);
	
	//登录
	public abstract Accounts login(Accounts acc);
}
