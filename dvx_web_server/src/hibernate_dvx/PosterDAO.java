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
 * Poster entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate_dvx.Poster
 * @author MyEclipse Persistence Tools
 */

public class PosterDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(PosterDAO.class);
	// property constants
	public static final String POSTER_NAME = "posterName";
	public static final String POSTER_URL = "posterUrl";

	public void save(Poster transientInstance) {
		log.debug("saving Poster instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Poster persistentInstance) {
		log.debug("deleting Poster instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Poster findById(java.lang.Integer id) {
		log.debug("getting Poster instance with id: " + id);
		try {
			Poster instance = (Poster) getSession().get("hibernate_dvx.Poster",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Poster instance) {
		log.debug("finding Poster instance by example");
		try {
			List results = getSession().createCriteria("hibernate_dvx.Poster")
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
		log.debug("finding Poster instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Poster as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPosterName(Object posterName) {
		return findByProperty(POSTER_NAME, posterName);
	}

	public List findByPosterUrl(Object posterUrl) {
		return findByProperty(POSTER_URL, posterUrl);
	}

	public List findAll() {
		log.debug("finding all Poster instances");
		try {
			String queryString = "from Poster";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Poster merge(Poster detachedInstance) {
		log.debug("merging Poster instance");
		try {
			Poster result = (Poster) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Poster instance) {
		log.debug("attaching dirty Poster instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Poster instance) {
		log.debug("attaching clean Poster instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}