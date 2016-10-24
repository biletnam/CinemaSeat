package com.chinasoft.model.services.impl;

import org.springframework.transaction.annotation.Transactional;

import com.chinasoft.model.dao.SeatsDAO;
import com.chinasoft.model.entity.BO_SEATS;
import com.chinasoft.model.entity.Seats;
import com.chinasoft.model.entity.Users;
import com.chinasoft.model.services.ISeatService;
import com.chinasoft.model.services.IUserService;

public class SeatServiceImpl implements ISeatService {

	private SeatsDAO dao;
	private IUserService ius;
	
	
	public IUserService getIus() {
		return ius;
	}
	public void setIus(IUserService ius) {
		this.ius = ius;
	}
	public SeatsDAO getDao() {
		return dao;
	}
	public void setDao(SeatsDAO dao) {
		this.dao = dao;
	}


	@Override
	@Transactional
	public Seats selSeatState(String mid, String sid) {
		// TODO Auto-generated method stub
		return dao.selSeatState(mid, sid);
	}
	
	@Override
	@Transactional
	public boolean payTicket(BO_SEATS boseat) {
		// TODO Auto-generated method stub
		Seats seat = boseat.getSeat();
		Users user = ius.selUserByAid(boseat.getAccount().getAId());
		try {
			dao.merge(seat);
			
			user.setUMoney(user.getUMoney() - boseat.getSum());
			
			ius.updateUser(user);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
	@Override
	public void addSeat(Seats seat) {
		// TODO Auto-generated method stub
		dao.save(seat);
	}

}
