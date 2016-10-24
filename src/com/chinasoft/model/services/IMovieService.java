package com.chinasoft.model.services;

import java.util.List;

import com.chinasoft.model.entity.BO_movie;
import com.chinasoft.model.entity.Movies;

public interface IMovieService {

	//显示所有movie
	public abstract List<Movies> showMovies();
	
	//查询单个movie根据id
	public abstract Movies showMovieById(String mid);
	
	//上架电影
	public abstract boolean addMovie(BO_movie bomovie);
	
	//分页查询
	public abstract List<Movies> findByPage(short pageSize, short begin, short end);
	
	//查询总页数
	public abstract Integer findPageTotal();
	
	//电影下架
	public void undercMovie(Movies movie);
}
