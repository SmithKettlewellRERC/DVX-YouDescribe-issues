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
 * MovieGenre entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate_dvx.MovieGenre
 * @author MyEclipse Persistence Tools
 */

public class MovieGenreDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MovieGenreDAO.class);
	// property constants
	public static final String MOVIE_GENRE_DESCRIPTION = "movieGenreDescription";
	public static final String MOVIE_GENRE_DESCRIPTION_LONG = "movieGenreDescriptionLong";

	public void save(MovieGenre transientInstance) {
		log.debug("saving MovieGenre instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MovieGenre persistentInstance) {
		log.debug("deleting MovieGenre instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MovieGenre findById(java.lang.Integer id) {
		log.debug("getting MovieGenre instance with id: " + id);
		try {
			MovieGenre instance = (MovieGenre) getSession().get(
					"hibernate_dvx.MovieGenre", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MovieGenre instance) {
		log.debug("finding MovieGenre instance by example");
		try {
			List results = getSession().createCriteria(
					"hibernate_dvx.MovieGenre").add(Example.create(instance))
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
		log.debug("finding MovieGenre instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from MovieGenre as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMovieGenreDescription(Object movieGenreDescription) {
		return findByProperty(MOVIE_GENRE_DESCRIPTION, movieGenreDescription);
	}

	public List findByMovieGenreDescriptionLong(Object movieGenreDescriptionLong) {
		return findByProperty(MOVIE_GENRE_DESCRIPTION_LONG,
				movieGenreDescriptionLong);
	}

	public List findAll() {
		log.debug("finding all MovieGenre instances");
		try {
			String queryString = "from MovieGenre";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MovieGenre merge(MovieGenre detachedInstance) {
		log.debug("merging MovieGenre instance");
		try {
			MovieGenre result = (MovieGenre) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MovieGenre instance) {
		log.debug("attaching dirty MovieGenre instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MovieGenre instance) {
		log.debug("attaching clean MovieGenre instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}