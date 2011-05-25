package hibernate_dvx;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Movie
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see hibernate_dvx.Movie
 * @author MyEclipse Persistence Tools
 */

public class MovieDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MovieDAO.class);
	// property constants
	public static final String MOVIE_NAME = "movieName";
	public static final String MOVIE_SBN_NUMBER = "movieSbnNumber";
	public static final String MOVIE_RATING_TEMP = "movieRatingTemp";
	public static final String MOVIE_RATING = "movieRating";
	public static final String MOVIE_QUOTE = "movieQuote";
	public static final String MOVIE_DESCRIPTION = "movieDescription";
	public static final String MOVIE_EXTRA_FEATURES = "movieExtraFeatures";
	public static final String MOVIE_RUNTIME = "movieRuntime";
	public static final String MOVIE_BUDGET = "movieBudget";
	public static final String MOVIE_REVENUE = "movieRevenue";
	public static final String MOVIE_WEBPAGE = "movieWebpage";

	public void save(Movie transientInstance) {
		log.debug("saving Movie instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Movie persistentInstance) {
		log.debug("deleting Movie instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Movie findById(java.lang.Integer id) {
		log.debug("getting Movie instance with id: " + id);
		try {
			Movie instance = (Movie) getSession()
					.get("hibernate_dvx.Movie", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Movie instance) {
		log.debug("finding Movie instance by example");
		try {
			List results = getSession().createCriteria("hibernate_dvx.Movie")
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
		log.debug("finding Movie instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Movie as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMovieName(Object movieName) {
		return findByProperty(MOVIE_NAME, movieName);
	}

	public List findByMovieSbnNumber(Object movieSbnNumber) {
		return findByProperty(MOVIE_SBN_NUMBER, movieSbnNumber);
	}

	public List findByMovieRatingTemp(Object movieRatingTemp) {
		return findByProperty(MOVIE_RATING_TEMP, movieRatingTemp);
	}

	public List findByMovieRating(Object movieRating) {
		return findByProperty(MOVIE_RATING, movieRating);
	}

	public List findByMovieQuote(Object movieQuote) {
		return findByProperty(MOVIE_QUOTE, movieQuote);
	}

	public List findByMovieDescription(Object movieDescription) {
		return findByProperty(MOVIE_DESCRIPTION, movieDescription);
	}

	public List findByMovieExtraFeatures(Object movieExtraFeatures) {
		return findByProperty(MOVIE_EXTRA_FEATURES, movieExtraFeatures);
	}

	public List findByMovieRuntime(Object movieRuntime) {
		return findByProperty(MOVIE_RUNTIME, movieRuntime);
	}

	public List findByMovieBudget(Object movieBudget) {
		return findByProperty(MOVIE_BUDGET, movieBudget);
	}

	public List findByMovieRevenue(Object movieRevenue) {
		return findByProperty(MOVIE_REVENUE, movieRevenue);
	}

	public List findByMovieWebpage(Object movieWebpage) {
		return findByProperty(MOVIE_WEBPAGE, movieWebpage);
	}

	public List findAll() {
		log.debug("finding all Movie instances");
		try {
			String queryString = "from Movie";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Movie merge(Movie detachedInstance) {
		log.debug("merging Movie instance");
		try {
			Movie result = (Movie) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Movie instance) {
		log.debug("attaching dirty Movie instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Movie instance) {
		log.debug("attaching clean Movie instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}