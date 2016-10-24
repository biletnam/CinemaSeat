package com.chinasoft.model.services;

import com.chinasoft.model.entity.BO_SEATS;
import com.chinasoft.model.entity.Seats;

public interface ISeatService {

	//根据mid和sid查询
	public abstract Seats selSeatState(String mid, String sid);
	
	//买票
	public abstract boolean payTicket(BO_SEATS boseat);
	
	//添加座位信息
	public abstract void addSeat(Seats seat);
}
