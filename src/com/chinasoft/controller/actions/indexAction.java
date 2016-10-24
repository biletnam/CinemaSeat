package com.chinasoft.controller.actions;

import java.util.List;

import com.chinasoft.model.entity.Movies;
import com.chinasoft.model.services.IMovieService;
import com.opensymphony.xwork2.ModelDriven;

public class indexAction  implements ModelDriven<Movies>{

	private Movies movie;
	private List<Movies> mlist;
	//private List<String> mlist;
	private IMovieService msi;
	
	private int pageTotal;
	
	
	
	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public IMovieService getMsi() {
		return msi;
	}

	public void setMsi(IMovieService msi) {
		this.msi = msi;
	}

	public List<Movies> getMlist() {
		return mlist;
	}

	public void setMlist(List<Movies> mlist) {
		this.mlist = mlist;
	}
	
	

	public Movies getMovie() {
		return movie;
	}



	public void setMovie(Movies movie) {
		this.movie = movie;
	}

	//查询所有movie
	public String showMovie()
	{
		
		mlist = msi.showMovies();
		
		return "success";
	}
	
	
	public String input()
	{
		return "input";
	}
	
	
	//显示后台
	public String showSys()
	{
		int total = msi.findPageTotal();
		
		pageTotal = (total % 12 == 0)? (total/12) : (total/12 + 1);
		return "sysmain";
	}
	
	@Override
	public Movies getModel() {
		// TODO Auto-generated method stub
		return movie;
	}

	
	
	
}
