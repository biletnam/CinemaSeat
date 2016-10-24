package com.chinasoft.controller.actions;

import java.util.Map;

import com.chinasoft.model.entity.Accounts;
import com.chinasoft.model.services.IAccountService;
import com.chinasoft.model.services.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class registAction extends BasicAction implements ModelDriven<Accounts> {

		private Accounts account;
		private IAccountService asi;
		private IUserService ius;

		
		public IUserService getIus() {
			return ius;
		}

		public void setIus(IUserService ius) {
			this.ius = ius;
		}

		public IAccountService getAsi() {
			return asi;
		}

		public void setAsi(IAccountService asi) {
			this.asi = asi;
		}

		public Accounts getAccount() {
			return account;
		}

		public void setAccount(Accounts account) {
			this.account = account;
		}
		
		
		
		public String registAccount()
		{
			asi.regist(account);
			return SUCCESS;
		}
		
		
		public String Login()
		{
			Accounts accounts = asi.login(account);
			if(accounts == null)
			{
				return "notlogin";
			}
			
			short loginpower = ius.selPowerByAid(accounts.getAId());
			Map session = ActionContext.getContext().getSession();
			session.put("loginUser", accounts);
			session.put("loginpower", loginpower);
			
			
			return "login";
		}
		
		
		public String Logout()
		{
			Map session = ActionContext.getContext().getSession();
			session.clear();
			return "logout";
		}
		
		
		public String inputLogin()
		{
			return "inputLogin";
		}

		@Override
		public Accounts getModel() {
			// TODO Auto-generated method stub
			return account;
		}
		
}
