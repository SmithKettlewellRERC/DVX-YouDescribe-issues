package hibernate_dvx;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Continent entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate_dvx.Continent
 * @author MyEclipse Persistence Tools
 */

public class ContinentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ContinentDAO.class);
	// property constants
	public static final String CONTINENT_NAME = "continentName";

	public void save(Continent transientInstance) {
		log.debug("saving Continent instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Continent persistentInstance) {
		log.debug("deleting Continent instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Continent findById(java.lang.Integer id) {
		log.debug("getting Continent instance with id: " + id);
		try {
			Continent instance = (Continent) getSession().get(
					"hibernate_dvx.Continent", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Continent instance) {
		log.debug("finding Continent instance by example");
		try {
			List results = getSession().createCriteria(
					"hibernate_dvx.Continent").add(Example.create(instance))
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
		log.debug("finding Continent instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Continent as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByContinentName(Object continentName) {
		return findByProperty(CONTINENT_NAME, continentName);
	}

	public List findAll() {
		log.debug("finding all Continent instances");
		try {
			String queryString = "from Continent";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Continent merge(Continent detachedInstance) {
		log.debug("merging Continent instance");
		try {
			Continent result = (Continent) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Continent instance) {
		log.debug("attaching dirty Continent instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Continent instance) {
		log.debug("attaching clean Continent instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}