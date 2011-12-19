package org.ski.dvx.server.hibernate.city;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.ski.dvx.server.hibernate.attribute.BaseHibernateDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for City
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see org.ski.dvx.server.hibernate.city.City
 * @author MyEclipse Persistence Tools
 */

public class CityDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CityDAO.class);
	// property constants
	public static final String CITY_NAME = "cityName";
	public static final String CITY_ZIP_CODE_FK = "cityZipCodeFk";
	public static final String CITY_STATE_FK = "cityStateFk";
	public static final String CITY_COUNTRY_FK = "cityCountryFk";
	public static final String CITY_GEO_CODE_FK = "cityGeoCodeFk";
	public static final String CITY_POPULATION = "cityPopulation";
	public static final String MODIFIED = "modified";
	public static final String CREATED = "created";

	public void save(City transientInstance) {
		log.debug("saving City instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(City persistentInstance) {
		log.debug("deleting City instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public City findById(java.lang.Integer id) {
		log.debug("getting City instance with id: " + id);
		try {
			City instance = (City) getSession().get(
					"org.ski.dvx.server.hibernate.city.City", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(City instance) {
		log.debug("finding City instance by example");
		try {
			List results = getSession()
					.createCriteria("org.ski.dvx.server.hibernate.city.City")
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
		log.debug("finding City instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from City as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCityName(Object cityName) {
		return findByProperty(CITY_NAME, cityName);
	}

	public List findByCityZipCodeFk(Object cityZipCodeFk) {
		return findByProperty(CITY_ZIP_CODE_FK, cityZipCodeFk);
	}

	public List findByCityStateFk(Object cityStateFk) {
		return findByProperty(CITY_STATE_FK, cityStateFk);
	}

	public List findByCityCountryFk(Object cityCountryFk) {
		return findByProperty(CITY_COUNTRY_FK, cityCountryFk);
	}

	public List findByCityGeoCodeFk(Object cityGeoCodeFk) {
		return findByProperty(CITY_GEO_CODE_FK, cityGeoCodeFk);
	}

	public List findByCityPopulation(Object cityPopulation) {
		return findByProperty(CITY_POPULATION, cityPopulation);
	}

	public List findByModified(Object modified) {
		return findByProperty(MODIFIED, modified);
	}

	public List findByCreated(Object created) {
		return findByProperty(CREATED, created);
	}

	public List findAll() {
		log.debug("finding all City instances");
		try {
			String queryString = "from City";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public City merge(City detachedInstance) {
		log.debug("merging City instance");
		try {
			City result = (City) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(City instance) {
		log.debug("attaching dirty City instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(City instance) {
		log.debug("attaching clean City instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}