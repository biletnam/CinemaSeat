package com.chinasoft.model.services;

import com.chinasoft.model.entity.Users;

public interface IUserService {

	//注册
	public abstract void regist(Users user);
	
	//根据aid查询user
	public abstract Users selUserByAid(String aid);
	
	//更新user信息
	public abstract void updateUser(Users user);
	
	//根据AID查询RPower
	public short selPowerByAid(String aid);
}
