package com.chinasoft.model.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import com.chinasoft.model.entity.Accounts;

/**
 * A data access object (DAO) providing persistence and search support for
 * Accounts entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.chinasoft.model.entity.Accounts
 * @author MyEclipse Persistence Tools
 */

public class AccountsDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AccountsDAO.class);
	// property constants
	public static final String _AACCOUNT = "AAccount";
	public static final String _APASSWORD = "APassword";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Accounts transientInstance) {
		log.debug("saving Accounts instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Accounts persistentInstance) {
		log.debug("deleting Accounts instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Accounts findById(java.lang.String id) {
		log.debug("getting Accounts instance with id: " + id);
		try {
			Accounts instance = (Accounts) getCurrentSession().get(
					"com.chinasoft.model.entity.Accounts", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Accounts instance) {
		log.debug("finding Accounts instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.chinasoft.model.entity.Accounts")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Accounts instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Accounts as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAAccount(Object AAccount) {
		return findByProperty(_AACCOUNT, AAccount);
	}

	public List findByAPassword(Object APassword) {
		return findByProperty(_APASSWORD, APassword);
	}

	public List findAll() {
		log.debug("finding all Accounts instances");
		try {
			String queryString = "from Accounts";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Accounts merge(Accounts detachedInstance) {
		log.debug("merging Accounts instance");
		try {
			Accounts result = (Accounts) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Accounts instance) {
		log.debug("attaching dirty Accounts instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Accounts instance) {
		log.debug("attaching clean Accounts instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AccountsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AccountsDAO) ctx.getBean("AccountsDAO");
	}
	
	
	
	
	//根据账号密码查找(登录)
	public Accounts login(Accounts acc)
	{
		String sql = "from Accounts a where a.AAccount = ? and a.APassword = ?";
		Query query = getCurrentSession().createQuery(sql);
		Accounts account = (Accounts) query.setString(0, acc.getAAccount()).setString(1, acc.getAPassword()).uniqueResult();
		return account;
		
	}
	
	
	
	
}


















