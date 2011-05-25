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
 * A data access object (DAO) providing persistence and search support for
 * UserDetail entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate_dvx.UserDetail
 * @author MyEclipse Persistence Tools
 */

public class UserDetailDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UserDetailDAO.class);
	// property constants
	public static final String USER_DETAIL_FIRST_NAME = "userDetailFirstName";
	public static final String USER_DETAIL_LAST_NAME = "userDetailLastName";
	public static final String USER_DETAIL_EMAIL = "userDetailEmail";
	public static final String USER_DETAIL_ADDRESS1 = "userDetailAddress1";
	public static final String USER_DETAIL_ADDRESS2 = "userDetailAddress2";
	public static final String USER_DETAIL_WORK_PHONE_NUMBER = "userDetailWorkPhoneNumber";
	public static final String USER_DETAIL_HOME_PHONE_NUMBER = "userDetailHomePhoneNumber";
	public static final String USER_DETAIL_MOBIL_PHONE_NUMBER = "userDetailMobilPhoneNumber";
	public static final String USER_DETAIL_ACTIVE = "userDetailActive";

	public void save(UserDetail transientInstance) {
		log.debug("saving UserDetail instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserDetail persistentInstance) {
		log.debug("deleting UserDetail instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserDetail findById(java.lang.Integer id) {
		log.debug("getting UserDetail instance with id: " + id);
		try {
			UserDetail instance = (UserDetail) getSession().get(
					"hibernate_dvx.UserDetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserDetail instance) {
		log.debug("finding UserDetail instance by example");
		try {
			List results = getSession().createCriteria(
					"hibernate_dvx.UserDetail").add(Example.create(instance))
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
		log.debug("finding UserDetail instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserDetail as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserDetailFirstName(Object userDetailFirstName) {
		return findByProperty(USER_DETAIL_FIRST_NAME, userDetailFirstName);
	}

	public List findByUserDetailLastName(Object userDetailLastName) {
		return findByProperty(USER_DETAIL_LAST_NAME, userDetailLastName);
	}

	public List findByUserDetailEmail(Object userDetailEmail) {
		return findByProperty(USER_DETAIL_EMAIL, userDetailEmail);
	}

	public List findByUserDetailAddress1(Object userDetailAddress1) {
		return findByProperty(USER_DETAIL_ADDRESS1, userDetailAddress1);
	}

	public List findByUserDetailAddress2(Object userDetailAddress2) {
		return findByProperty(USER_DETAIL_ADDRESS2, userDetailAddress2);
	}

	public List findByUserDetailWorkPhoneNumber(Object userDetailWorkPhoneNumber) {
		return findByProperty(USER_DETAIL_WORK_PHONE_NUMBER,
				userDetailWorkPhoneNumber);
	}

	public List findByUserDetailHomePhoneNumber(Object userDetailHomePhoneNumber) {
		return findByProperty(USER_DETAIL_HOME_PHONE_NUMBER,
				userDetailHomePhoneNumber);
	}

	public List findByUserDetailMobilPhoneNumber(
			Object userDetailMobilPhoneNumber) {
		return findByProperty(USER_DETAIL_MOBIL_PHONE_NUMBER,
				userDetailMobilPhoneNumber);
	}

	public List findByUserDetailActive(Object userDetailActive) {
		return findByProperty(USER_DETAIL_ACTIVE, userDetailActive);
	}

	public List findAll() {
		log.debug("finding all UserDetail instances");
		try {
			String queryString = "from UserDetail";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserDetail merge(UserDetail detachedInstance) {
		log.debug("merging UserDetail instance");
		try {
			UserDetail result = (UserDetail) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserDetail instance) {
		log.debug("attaching dirty UserDetail instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserDetail instance) {
		log.debug("attaching clean UserDetail instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}