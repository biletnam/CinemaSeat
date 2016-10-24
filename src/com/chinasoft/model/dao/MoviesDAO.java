package com.chinasoft.model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.chinasoft.model.entity.BO_movie;
import com.chinasoft.model.entity.Movies;

/**
 * A data access object (DAO) providing persistence and search support for
 * Movies entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.chinasoft.model.entity.Movies
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class MoviesDAO {
	private static final Logger log = LoggerFactory.getLogger(MoviesDAO.class);
	// property constants
	public static final String _MNAME = "MName";
	public static final String _MCOUNTRY = "MCountry";
	public static final String _MSTATE = "MState";
	public static final String _MCATEGORY = "MCategory";
	public static final String _MDIRECTOR = "MDirector";
	public static final String _MACTORS = "MActors";
	public static final String _MFITAGE = "MFitage";
	public static final String _MTIME = "MTime";
	public static final String _MPICON = "MPicon";
	public static final String _MIICON = "MIicon";
	public static final String _MVIDEO = "MVideo";
	public static final String _MUNDERSTATE = "MUnderstate";

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

	public void save(Movies transientInstance) {
		log.debug("saving Movies instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Movies persistentInstance) {
		log.debug("deleting Movies instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Movies findById(java.lang.String id) {
		log.debug("getting Movies instance with id: " + id);
		try {
			Movies instance = (Movies) getCurrentSession().get(
					"com.chinasoft.model.entity.Movies", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Movies instance) {
		log.debug("finding Movies instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.chinasoft.model.entity.Movies")
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
		log.debug("finding Movies instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Movies as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMName(Object MName) {
		return findByProperty(_MNAME, MName);
	}

	public List findByMCountry(Object MCountry) {
		return findByProperty(_MCOUNTRY, MCountry);
	}

	public List findByMState(Object MState) {
		return findByProperty(_MSTATE, MState);
	}

	public List findByMCategory(Object MCategory) {
		return findByProperty(_MCATEGORY, MCategory);
	}

	public List findByMDirector(Object MDirector) {
		return findByProperty(_MDIRECTOR, MDirector);
	}

	public List findByMActors(Object MActors) {
		return findByProperty(_MACTORS, MActors);
	}

	public List findByMFitage(Object MFitage) {
		return findByProperty(_MFITAGE, MFitage);
	}

	public List findByMTime(Object MTime) {
		return findByProperty(_MTIME, MTime);
	}

	public List findByMPicon(Object MPicon) {
		return findByProperty(_MPICON, MPicon);
	}

	public List findByMIicon(Object MIicon) {
		return findByProperty(_MIICON, MIicon);
	}

	public List findByMVideo(Object MVideo) {
		return findByProperty(_MVIDEO, MVideo);
	}

	public List findByMUnderstate(Object MUnderstate) {
		return findByProperty(_MUNDERSTATE, MUnderstate);
	}

	public List findAll() {
		log.debug("finding all Movies instances");
		try {
			String queryString = "from Movies a where a.MUnderstate = 0 order by a.MReldate desc";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Movies merge(Movies detachedInstance) {
		log.debug("merging Movies instance");
		try {
			Movies result = (Movies) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Movies instance) {
		log.debug("attaching dirty Movies instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Movies instance) {
		log.debug("attaching clean Movies instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MoviesDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MoviesDAO) ctx.getBean("MoviesDAO");
	}
	
	
	
	
	//分页查询
	public List<Movies> findByPage(short pageSize, short begin, short end)
	{
		String sql = "from Movies a where a.MUnderstate = 0 order by a.MReldate desc";
		Query query = getCurrentSession().createQuery(sql);
		query.setFirstResult(begin * pageSize);
		query.setMaxResults(end * pageSize);
		
		List<Movies> list = query.list();
		return list;
	}
	
	
	//查询总页数
	public Integer findPageTotal()
	{
		String sql = "select count(a) from Movies a where a.MUnderstate = 0";// group by a.MId";
		Query query = getCurrentSession().createQuery(sql);
		
		Object obj = query.uniqueResult();
		
		String str = obj.toString();
		Integer total = Integer.valueOf(str);
		//Integer total = Integer.valueOf((String)obj);
		return total;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}