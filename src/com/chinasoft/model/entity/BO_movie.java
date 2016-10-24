package com.chinasoft.model.entity;

import java.util.ArrayList;
import java.util.List;

public class BO_movie {
	
	private Movies movie;
	private List<Seasons> slist;
	private String amovie;
	
	
	public String getAmovie() {
		return amovie;
	}
	public void setAmovie(String amovie) {
		this.amovie = amovie;
	}
	public Movies getMovie() {
		return movie;
	}
	public void setMovie(Movies movie) {
		this.movie = movie;
	}
	public List<Seasons> getSlist() {
		return slist;
	}
	public void setSlist(List<Seasons> slist) {
		this.slist = slist;
	}
	
	
}
