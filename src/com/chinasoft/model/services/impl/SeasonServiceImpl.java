package com.chinasoft.model.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.chinasoft.model.dao.SeasonsDAO;
import com.chinasoft.model.entity.Seasons;
import com.chinasoft.model.services.ISeasonService;

public class SeasonServiceImpl implements ISeasonService {

	private SeasonsDAO dao;
	
	
	public SeasonsDAO getDao() {
		return dao;
	}
	public void setDao(SeasonsDAO dao) {
		this.dao = dao;
	}
	
	@Override
	@Transactional
	public List<Seasons> selSeasonByMid(String mid) {
		// TODO Auto-generated method stub
		return dao.findByMId(mid);
	}
	@Override
	@Transactional
	public Seasons selSeasonBySid(String sid) {
		// TODO Auto-generated method stub
		return dao.findById(sid);
	}
	@Override
	public void addSeasons(Seasons season) {
		// TODO Auto-generated method stub
		dao.save(season);
	}

}
