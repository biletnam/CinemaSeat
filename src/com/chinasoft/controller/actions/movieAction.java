package com.chinasoft.controller.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.chinasoft.model.entity.BO_movie;
import com.chinasoft.model.entity.Seasons;
import com.chinasoft.model.services.IMovieService;
import com.chinasoft.model.services.impl.MovieServiceImpl;
import com.chinasoft.util.DateTime;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class movieAction implements ModelDriven<BO_movie> {

	private BO_movie bomovie;
	private IMovieService msi;

	
	//文件相关
	private File myfile = new File("/CinemaSeat/images/defaultimg.jpg");
	private String myfileFileName;
	private String myfileContentType;
	
	private long filelength;
	private String disposition;
	//-----------
	
	
	
	public IMovieService getMsi() {
		return msi;
	}
	public void setMsi(IMovieService msi) {
		this.msi = msi;
	}
	public BO_movie getBomovie() {
		return bomovie;
	}
	public void setBomovie(BO_movie bomovie) {
		this.bomovie = bomovie;
	}

	
	
	
	public File getMyfile() {
		return myfile;
	}
	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}
	public String getMyfileFileName() {
		return myfileFileName;
	}
	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}
	public String getMyfileContentType() {
		return myfileContentType;
	}
	public void setMyfileContentType(String myfileContentType) {
		this.myfileContentType = myfileContentType;
	}
	public long getFilelength() {
		return filelength;
	}
	public void setFilelength(long filelength) {
		this.filelength = filelength;
	}
	public String getDisposition() {
		return disposition;
	}
	public void setDisposition(String disposition) {
		this.disposition = disposition;
	}
	
	
	public String addMovie()
	{
		ServletContext application = (ServletContext) ActionContext.getContext().get(ServletActionContext.SERVLET_CONTEXT);
		
		String sqliconurl = null;
		
		String filepath = application.getRealPath("uploads");
		String pathtime = DateTime.getAccDateTime("");
		String pathradomint = String.valueOf(Math.random()).substring(2, 5);
		String myfileName = filepath + "/" + pathtime + pathradomint + ".jpg" ;
		
		
		sqliconurl = "/CinemaSeat/uploads/"+pathtime + pathradomint+".jpg";
			
		try {
			
			File newDir = new File(filepath);
			if(!newDir.exists())
			{
				newDir.mkdir();
			}
			
			/*myfile = new File(myfileName);*/
			FileInputStream fis = new FileInputStream(myfile);
			FileOutputStream fos = new FileOutputStream(new File(myfileName));
			
			byte[] b = new byte[1024];
			
			int content = 0;
			while((content = fis.read(b,0,1024)) != -1)
			{
				fos.write(b);
			}
			fos.flush();
			
			fis.close();
			fos.close();
			
			bomovie.getMovie().setMPicon(sqliconurl);
			msi.addMovie(bomovie);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return "addmovie";
	}

	public String input()
	{
		return "input";
	}
	
	
	
	
	@Override
	public BO_movie getModel() {
		// TODO Auto-generated method stub
		return bomovie;
	}

}
