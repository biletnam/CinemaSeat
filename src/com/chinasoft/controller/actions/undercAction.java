package com.chinasoft.controller.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.chinasoft.model.entity.BO_movie;
import com.chinasoft.model.entity.Movies;
import com.chinasoft.model.entity.Seasons;
import com.chinasoft.model.services.IMovieService;
import com.chinasoft.model.services.ISeasonService;
import com.opensymphony.xwork2.ActionContext;

public class undercAction {

	
	private IMovieService ims;
	private ISeasonService iss;
	
	private short pageIndex;
	
	private List<BO_movie> bomovielist;
	
	private String mid;
	
	
	
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public short getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(short pageIndex) {
		this.pageIndex = pageIndex;
	}
	public List<BO_movie> getBomovielist() {
		return bomovielist;
	}
	public void setBomovielist(List<BO_movie> bomovielist) {
		this.bomovielist = bomovielist;
	}
	public IMovieService getIms() {
		return ims;
	}
	public void setIms(IMovieService ims) {
		this.ims = ims;
	}
	public ISeasonService getIss() {
		return iss;
	}
	public void setIss(ISeasonService iss) {
		this.iss = iss;
	}
	
	
	
	public String showMovieSeasons()
	{
		
		List<Movies> movies = ims.findByPage((short)12,pageIndex, (short) (pageIndex+1));
		BO_movie bm = null;
		bomovielist = new ArrayList<BO_movie>();
		
		for(int i = 0 ; i < movies.size() ; i++)
		{
			bm = new BO_movie();
			List<Seasons> seasons = iss.selSeasonByMid(movies.get(i).getMId());
			for(int k = 0 ; k < seasons.size() ; k++)
			{
				seasons.get(k).setSBegintime(seasons.get(k).getSBegintime().substring(0,5));
				seasons.get(k).setSEndtime(seasons.get(k).getSEndtime().substring(0,5));
			}
			bm.setMovie(movies.get(i));
			bm.setAmovie("#"+movies.get(i).getMId());
			bm.setSlist(seasons);
			
			bomovielist.add(bm);
		}
		
		return "show";
	}
	
	
	public String undercMovie()
	{
		Movies movie = ims.showMovieById(mid);
		movie.setMUnderstate((short)1);
		ims.undercMovie(movie);
		
		return "underc";
	}
}


















