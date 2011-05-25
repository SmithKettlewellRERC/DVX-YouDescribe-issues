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
 * MovieTrailer entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see hibernate_dvx.MovieTrailer
 * @author MyEclipse Persistence Tools
 */

public class MovieTrailerDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MovieTrailerDAO.class);
	// property constants
	public static final String MOVIE_TRAILER_URI = "movieTrailerUri";
	public static final String MOVIE_TRAILER_INDEX = "movieTrailerIndex";

	public void save(MovieTrailer transientInstance) {
		log.debug("saving MovieTrailer instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MovieTrailer persistentInstance) {
		log.debug("deleting MovieTrailer instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MovieTrailer findById(java.lang.Integer id) {
		log.debug("getting MovieTrailer instance with id: " + id);
		try {
			MovieTrailer instance = (MovieTrailer) getSession().get(
					"hibernate_dvx.MovieTrailer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MovieTrailer instance) {
		log.debug("finding MovieTrailer instance by example");
		try {
			List results = getSession().createCriteria(
					"hibernate_dvx.MovieTrailer").add(Example.create(instance))
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
		log.debug("finding MovieTrailer instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from MovieTrailer as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMovieTrailerUri(Object movieTrailerUri) {
		return findByProperty(MOVIE_TRAILER_URI, movieTrailerUri);
	}

	public List findByMovieTrailerIndex(Object movieTrailerIndex) {
		return findByProperty(MOVIE_TRAILER_INDEX, movieTrailerIndex);
	}

	public List findAll() {
		log.debug("finding all MovieTrailer instances");
		try {
			String queryString = "from MovieTrailer";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MovieTrailer merge(MovieTrailer detachedInstance) {
		log.debug("merging MovieTrailer instance");
		try {
			MovieTrailer result = (MovieTrailer) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MovieTrailer instance) {
		log.debug("attaching dirty MovieTrailer instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MovieTrailer instance) {
		log.debug("attaching clean MovieTrailer instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}