package com.chinasoft.controller.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.chinasoft.model.entity.Accounts;
import com.chinasoft.model.entity.BO_SEATS;
import com.chinasoft.model.entity.Movies;
import com.chinasoft.model.entity.Seasons;
import com.chinasoft.model.entity.Seats;
import com.chinasoft.model.services.IMovieService;
import com.chinasoft.model.services.ISeasonService;
import com.chinasoft.model.services.ISeatService;
import com.opensymphony.xwork2.ActionContext;

public class seatAction extends BasicAction {

	private String mid;
	private String sid;
	private ISeatService issi;
	private IMovieService msi;
	private ISeasonService ssi;
	
	private Seats seat;
	
	private String seatStr;
	
	private double sum;
	
	private Movies movie;
	private Seasons season;
	
	
	
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public Movies getMovie() {
		return movie;
	}
	public void setMovie(Movies movie) {
		this.movie = movie;
	}
	public Seasons getSeason() {
		return season;
	}
	public void setSeason(Seasons season) {
		this.season = season;
	}
	public IMovieService getMsi() {
		return msi;
	}
	public void setMsi(IMovieService msi) {
		this.msi = msi;
	}
	public ISeasonService getSsi() {
		return ssi;
	}
	public void setSsi(ISeasonService ssi) {
		this.ssi = ssi;
	}
	public String getSeatStr() {
		return seatStr;
	}
	public void setSeatStr(String seatStr) {
		this.seatStr = seatStr;
	}
	public Seats getSeat() {
		return seat;
	}
	public void setSeat(Seats seat) {
		this.seat = seat;
	}
	public ISeatService getIssi() {
		return issi;
	}
	public void setIssi(ISeatService issi) {
		this.issi = issi;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	
	
	//查询对应电影的座位信息
	public String showSeat()
	{
		seat = issi.selSeatState(mid, sid);
		
		return SUCCESS;
	}
	
	
	//出票
	public String createTicket()
	{
		String[] strs1 = new String[18];
		char[] chs1 = new char[18];
		
		//坐位坐标字符串集合
		List<Character> seatListRow = new ArrayList<Character>();
		List<Integer> seatListCol = new ArrayList<Integer>();
		
		for(int i = 0 ; i < strs1.length ; i++)
		{
			strs1[i] = seatStr.split("@")[i];
			chs1[i] = (char)(65+i);
			
			//因为是正方形  所以str1的length和str1[i]的length一样
			
			List<Integer> clist = getCharIndex(strs1[i].replace(",", ""), '2');
			for(int j = 0 ; j < clist.size() ; j++)
			{
				seatListRow.add(chs1[i]);
				seatListCol.add((clist.get(j)+1));
				
			}
			
		}
		
		
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("seatListRow", seatListRow);
		request.put("seatListCol", seatListCol);
		
		//获取场次和电影
		season = ssi.selSeasonBySid(sid);
		movie = msi.showMovieById(mid);
		
		sum = seatListRow.size() * season.getSPrice();
		request.put("sumPrice", sum);
		
		return "cretic";
	}
	
	
	//获取字符在字符串中的位置
	public List<Integer> getCharIndex(String str , char ch)
	{
		char[] c = new char[str.length()];
		c = str.toCharArray();
		
		List<Integer> clist = new ArrayList<Integer>();
		for(int i = 0 ; i < c.length ; i++)
		{
			if(c[i] == ch){
				clist.add(i);
			}
		}
		return clist;
	}
	
	
	
	//支付
	public String payTickets()
	{
		Seats oldSeats = issi.selSeatState(mid, sid);
		String seatStr = this.seatStr;
		
		List<Integer> clist = getCharIndex(seatStr.replace("@", "").replace(",", ""), '2');
		
		for(int i = 0 ; i < clist.size() ; i++)
		{
			//clist.get(i)
			String oldState = oldSeats.getSeState().replace("@", "").replace(",", "");
			if(String.valueOf(oldState.charAt(clist.get(i))).equals("1")) 
			{
				return "reserved";
			}
			
		}
		//
		for(int k = 0 ; k < oldSeats.getSeState().length() ; k++)
		{
			if(String.valueOf(oldSeats.getSeState().charAt(k)).equals("1") && String.valueOf(seatStr.charAt(k)).equals("0"))
			{
				seatStr = replaceByIndex(seatStr, k ,'1');
			}
		}
		
		
		oldSeats.setSeState(seatStr.replace("2", "1"));
		//
		BO_SEATS boseat = new BO_SEATS();
		
		Map session = ActionContext.getContext().getSession();
		
		boseat.setSeat(oldSeats);
		boseat.setSum(sum);
		//((Accounts)session.get("loginUser")).getAId()
		boseat.setAccount((Accounts) session.get("loginUser"));
		issi.payTicket(boseat);
		
		return "pay";
	}
	
	
	
	//替换字符串指定位置字符
	public String replaceByIndex(String s, int index , char after)
	{
		char[] cs = s.toCharArray();
		cs[index] = after;
		return new String(cs);
	}
}




























