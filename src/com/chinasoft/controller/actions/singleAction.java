package com.chinasoft.controller.actions;

import java.util.List;

import com.chinasoft.model.entity.Movies;
import com.chinasoft.model.entity.Seasons;
import com.chinasoft.model.services.IMovieService;
import com.chinasoft.model.services.ISeasonService;
import com.opensymphony.xwork2.ModelDriven;

public class singleAction extends BasicAction implements ModelDriven<Movies>{

	private Movies movie;
	private String mid;
	private IMovieService msi;
	
	private List<Seasons> slist;
	private ISeasonService ssi;
	
	
	
	public List<Seasons> getSlist() {
		return slist;
	}
	public void setSlist(List<Seasons> slist) {
		this.slist = slist;
	}
	public ISeasonService getSsi() {
		return ssi;
	}
	public void setSsi(ISeasonService ssi) {
		this.ssi = ssi;
	}
	public IMovieService getMsi() {
		return msi;
	}
	public void setMsi(IMovieService msi) {
		this.msi = msi;
	}
	public Movies getMovie() {
		return movie;
	}
	public void setMovie(Movies movie) {
		this.movie = movie;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}

	//查询单个的movie和场次
	public String showMovieById()
	{
		movie = msi.showMovieById(mid);
		movie.setMReldate(movie.getMReldate().substring(0, 4));
		
		slist = ssi.selSeasonByMid(mid);
		
		for (int i = 0; i < slist.size(); i++) {
			slist.get(i).setSBegintime(slist.get(i).getSBegintime().substring(0,5));
			slist.get(i).setSEndtime(slist.get(i).getSEndtime().substring(0,5));
		}
		
		return SUCCESS;
	}
	

	@Override
	public Movies getModel() {
		// TODO Auto-generated method stub
		return movie;
	}

}








