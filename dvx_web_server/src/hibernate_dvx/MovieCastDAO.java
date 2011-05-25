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
 * MovieCast entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate_dvx.MovieCast
 * @author MyEclipse Persistence Tools
 */

public class MovieCastDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MovieCastDAO.class);
	// property constants
	public static final String MOVIE_CAST_ROLE_ORDER = "movieCastRoleOrder";
	public static final String MOVIE_CAST_ROLE_NAME = "movieCastRoleName";
	public static final String MOVIE_CAST_ROLE_DESCRIPTION = "movieCastRoleDescription";

	public void save(MovieCast transientInstance) {
		log.debug("saving MovieCast instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MovieCast persistentInstance) {
		log.debug("deleting MovieCast instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MovieCast findById(java.lang.Integer id) {
		log.debug("getting MovieCast instance with id: " + id);
		try {
			MovieCast instance = (MovieCast) getSession().get(
					"hibernate_dvx.MovieCast", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MovieCast instance) {
		log.debug("finding MovieCast instance by example");
		try {
			List results = getSession().createCriteria(
					"hibernate_dvx.MovieCast").add(Example.create(instance))
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
		log.debug("finding MovieCast instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from MovieCast as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMovieCastRoleOrder(Object movieCastRoleOrder) {
		return findByProperty(MOVIE_CAST_ROLE_ORDER, movieCastRoleOrder);
	}

	public List findByMovieCastRoleName(Object movieCastRoleName) {
		return findByProperty(MOVIE_CAST_ROLE_NAME, movieCastRoleName);
	}

	public List findByMovieCastRoleDescription(Object movieCastRoleDescription) {
		return findByProperty(MOVIE_CAST_ROLE_DESCRIPTION,
				movieCastRoleDescription);
	}

	public List findAll() {
		log.debug("finding all MovieCast instances");
		try {
			String queryString = "from MovieCast";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MovieCast merge(MovieCast detachedInstance) {
		log.debug("merging MovieCast instance");
		try {
			MovieCast result = (MovieCast) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MovieCast instance) {
		log.debug("attaching dirty MovieCast instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MovieCast instance) {
		log.debug("attaching clean MovieCast instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}