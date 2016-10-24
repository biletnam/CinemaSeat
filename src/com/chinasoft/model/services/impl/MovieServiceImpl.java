package com.chinasoft.model.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.chinasoft.model.dao.MoviesDAO;
import com.chinasoft.model.entity.BO_movie;
import com.chinasoft.model.entity.Movies;
import com.chinasoft.model.entity.Seats;
import com.chinasoft.model.services.IMovieService;
import com.chinasoft.model.services.ISeasonService;
import com.chinasoft.model.services.ISeatService;
import com.chinasoft.util.DateTime;

public class MovieServiceImpl implements IMovieService {

	private MoviesDAO dao;
	private ISeasonService ssi;
	private ISeatService issi;
	
	

	public ISeatService getIssi() {
		return issi;
	}

	public void setIssi(ISeatService issi) {
		this.issi = issi;
	}

	public ISeasonService getSsi() {
		return ssi;
	}

	public void setSsi(ISeasonService ssi) {
		this.ssi = ssi;
	}

	public MoviesDAO getDao() {
		return dao;
	}

	public void setDao(MoviesDAO dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public List<Movies> showMovies() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	@Transactional
	public Movies showMovieById(String mid) {
		// TODO Auto-generated method stub
		return dao.findById(mid);
	}

	@Override
	@Transactional
	public boolean addMovie(BO_movie bomovie) {
		// TODO Auto-generated method stub
		bomovie.getMovie().setMReldate(DateTime.getDate("-"));
		bomovie.getMovie().setMUnderstate((short) 0);
		dao.save(bomovie.getMovie());
		
		String mid = bomovie.getMovie().getMId();
		
		//座位状态字符串
		String statetmpl = "";
		for(int k = 0 ; k < 18 ; k++)
		{
			statetmpl = statetmpl.concat("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0@");
		}
		
		//遍历场次并添加
		for(int i = 0 ; i < bomovie.getSlist().size(); i++)
		{
			if(bomovie.getSlist().get(i) != null)
			{
				if(bomovie.getSlist().get(i).getSShowdate() != null)
				{
					bomovie.getSlist().get(i).setMId(mid);
					ssi.addSeasons(bomovie.getSlist().get(i));
					
					//生成座位表
					String sid = bomovie.getSlist().get(i).getSId();
					Seats seat = new Seats();
					seat.setMId(mid);
					seat.setSId(sid);
					seat.setSeState(statetmpl);
					issi.addSeat(seat);
				}
			}
			
			
			
		}
		
		return true;
	}

	@Override
	@Transactional
	public List<Movies> findByPage(short pageSize, short begin, short end) {
		// TODO Auto-generated method stub
		return dao.findByPage(pageSize, begin, end);
	}

	@Override
	@Transactional
	public Integer findPageTotal() {
		// TODO Auto-generated method stub
		return dao.findPageTotal();
	}

	@Override
	@Transactional
	public void undercMovie(Movies movie) {
		// TODO Auto-generated method stub
		dao.merge(movie);
	}

}















