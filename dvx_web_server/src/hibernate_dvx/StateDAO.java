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
 * A data access object (DAO) providing persistence and search support for State
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see hibernate_dvx.State
 * @author MyEclipse Persistence Tools
 */

public class StateDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(StateDAO.class);
	// property constants
	public static final String STATE_NAME = "stateName";
	public static final String STATE_NAME_SHORT = "stateNameShort";
	public static final String STATE_COUNTRY_FK = "stateCountryFk";

	public void save(State transientInstance) {
		log.debug("saving State instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(State persistentInstance) {
		log.debug("deleting State instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public State findById(java.lang.Integer id) {
		log.debug("getting State instance with id: " + id);
		try {
			State instance = (State) getSession()
					.get("hibernate_dvx.State", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(State instance) {
		log.debug("finding State instance by example");
		try {
			List results = getSession().createCriteria("hibernate_dvx.State")
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
		log.debug("finding State instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from State as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStateName(Object stateName) {
		return findByProperty(STATE_NAME, stateName);
	}

	public List findByStateNameShort(Object stateNameShort) {
		return findByProperty(STATE_NAME_SHORT, stateNameShort);
	}

	public List findByStateCountryFk(Object stateCountryFk) {
		return findByProperty(STATE_COUNTRY_FK, stateCountryFk);
	}

	public List findAll() {
		log.debug("finding all State instances");
		try {
			String queryString = "from State";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public State merge(State detachedInstance) {
		log.debug("merging State instance");
		try {
			State result = (State) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(State instance) {
		log.debug("attaching dirty State instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(State instance) {
		log.debug("attaching clean State instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}