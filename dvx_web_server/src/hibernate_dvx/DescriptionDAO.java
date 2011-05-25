package hibernate_dvx;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Description entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see hibernate_dvx.Description
 * @author MyEclipse Persistence Tools
 */

public class DescriptionDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DescriptionDAO.class);
	// property constants
	public static final String DESCRIPTION_LONG = "descriptionLong";
	public static final String DESCRIPTION_SHORT = "descriptionShort";

	public void save(Description transientInstance) {
		log.debug("saving Description instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Description persistentInstance) {
		log.debug("deleting Description instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Description findById(java.lang.Integer id) {
		log.debug("getting Description instance with id: " + id);
		try {
			Description instance = (Description) getSession().get(
					"hibernate_dvx.Description", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Description instance) {
		log.debug("finding Description instance by example");
		try {
			List results = getSession().createCriteria(
					"hibernate_dvx.Description").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Description instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Description as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDescriptionLong(Object descriptionLong) {
		return findByProperty(DESCRIPTION_LONG, descriptionLong);
	}

	public List findByDescriptionShort(Object descriptionShort) {
		return findByProperty(DESCRIPTION_SHORT, descriptionShort);
	}

	public List findAll() {
		log.debug("finding all Description instances");
		try {
			String queryString = "from Description";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Description merge(Description detachedInstance) {
		log.debug("merging Description instance");
		try {
			Description result = (Description) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Description instance) {
		log.debug("attaching dirty Description instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Description instance) {
		log.debug("attaching clean Description instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}