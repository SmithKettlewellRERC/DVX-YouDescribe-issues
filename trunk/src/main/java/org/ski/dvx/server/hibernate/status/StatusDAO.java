package org.ski.dvx.server.hibernate.status;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.ski.dvx.server.hibernate.attribute.BaseHibernateDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Status entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.ski.dvx.server.hibernate.status.Status
 * @author MyEclipse Persistence Tools
 */

public class StatusDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(StatusDAO.class);
	// property constants
	public static final String STATUS_DESCRIPTION = "statusDescription";
	public static final String MODIFIED = "modified";
	public static final String CREATED = "created";

	public void save(Status transientInstance) {
		log.debug("saving Status instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Status persistentInstance) {
		log.debug("deleting Status instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Status findById(java.lang.Integer id) {
		log.debug("getting Status instance with id: " + id);
		try {
			Status instance = (Status) getSession().get(
					"org.ski.dvx.server.hibernate.status.Status", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Status instance) {
		log.debug("finding Status instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"org.ski.dvx.server.hibernate.status.Status")
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
		log.debug("finding Status instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Status as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStatusDescription(Object statusDescription) {
		return findByProperty(STATUS_DESCRIPTION, statusDescription);
	}

	public List findByModified(Object modified) {
		return findByProperty(MODIFIED, modified);
	}

	public List findByCreated(Object created) {
		return findByProperty(CREATED, created);
	}

	public List findAll() {
		log.debug("finding all Status instances");
		try {
			String queryString = "from Status";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Status merge(Status detachedInstance) {
		log.debug("merging Status instance");
		try {
			Status result = (Status) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Status instance) {
		log.debug("attaching dirty Status instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Status instance) {
		log.debug("attaching clean Status instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}