package com.chinasoft.controller.actions;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BasicAction extends ActionSupport {

	@Override
	public String input()
	{
		return INPUT;
	}
	
}
