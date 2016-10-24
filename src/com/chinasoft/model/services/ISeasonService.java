package com.chinasoft.model.services;

import java.util.List;

import com.chinasoft.model.entity.Seasons;

public interface ISeasonService {

	//根据mid查询
	public abstract List<Seasons> selSeasonByMid(String mid);
	
	//根据sid查询
	public abstract Seasons selSeasonBySid(String sid);
	
	//添加场次
	public abstract void addSeasons(Seasons season);
}
