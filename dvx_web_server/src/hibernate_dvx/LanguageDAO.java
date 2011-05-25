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
 * Language entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate_dvx.Language
 * @author MyEclipse Persistence Tools
 */

public class LanguageDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(LanguageDAO.class);
	// property constants
	public static final String LANGUAGE_NAME = "languageName";
	public static final String LANGUAGE_NAME_SHORT = "languageNameShort";

	public void save(Language transientInstance) {
		log.debug("saving Language instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Language persistentInstance) {
		log.debug("deleting Language instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Language findById(java.lang.Integer id) {
		log.debug("getting Language instance with id: " + id);
		try {
			Language instance = (Language) getSession().get(
					"hibernate_dvx.Language", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Language instance) {
		log.debug("finding Language instance by example");
		try {
			List results = getSession()
					.createCriteria("hibernate_dvx.Language").add(
							Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Language instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Language as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLanguageName(Object languageName) {
		return findByProperty(LANGUAGE_NAME, languageName);
	}

	public List findByLanguageNameShort(Object languageNameShort) {
		return findByProperty(LANGUAGE_NAME_SHORT, languageNameShort);
	}

	public List findAll() {
		log.debug("finding all Language instances");
		try {
			String queryString = "from Language";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Language merge(Language detachedInstance) {
		log.debug("merging Language instance");
		try {
			Language result = (Language) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Language instance) {
		log.debug("attaching dirty Language instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Language instance) {
		log.debug("attaching clean Language instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}