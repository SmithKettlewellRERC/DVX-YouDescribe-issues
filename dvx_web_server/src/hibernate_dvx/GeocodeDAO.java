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
 * Geocode entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate_dvx.Geocode
 * @author MyEclipse Persistence Tools
 */

public class GeocodeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(GeocodeDAO.class);
	// property constants
	public static final String GEOCODE_LATITUDE = "geocodeLatitude";
	public static final String GEOCODE_LONGITUDE = "geocodeLongitude";

	public void save(Geocode transientInstance) {
		log.debug("saving Geocode instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Geocode persistentInstance) {
		log.debug("deleting Geocode instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Geocode findById(java.lang.Integer id) {
		log.debug("getting Geocode instance with id: " + id);
		try {
			Geocode instance = (Geocode) getSession().get(
					"hibernate_dvx.Geocode", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Geocode instance) {
		log.debug("finding Geocode instance by example");
		try {
			List results = getSession().createCriteria("hibernate_dvx.Geocode")
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
		log.debug("finding Geocode instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Geocode as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGeocodeLatitude(Object geocodeLatitude) {
		return findByProperty(GEOCODE_LATITUDE, geocodeLatitude);
	}

	public List findByGeocodeLongitude(Object geocodeLongitude) {
		return findByProperty(GEOCODE_LONGITUDE, geocodeLongitude);
	}

	public List findAll() {
		log.debug("finding all Geocode instances");
		try {
			String queryString = "from Geocode";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Geocode merge(Geocode detachedInstance) {
		log.debug("merging Geocode instance");
		try {
			Geocode result = (Geocode) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Geocode instance) {
		log.debug("attaching dirty Geocode instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Geocode instance) {
		log.debug("attaching clean Geocode instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}