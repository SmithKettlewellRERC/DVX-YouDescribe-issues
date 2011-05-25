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
 * CrewCast entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate_dvx.CrewCast
 * @author MyEclipse Persistence Tools
 */

public class CrewCastDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CrewCastDAO.class);
	// property constants
	public static final String CREW_CAST_FULL_NAME = "crewCastFullName";
	public static final String CREW_CAST_FIRST_NAME = "crewCastFirstName";
	public static final String CREW_CAST_MIDDLE_NAME = "crewCastMiddleName";
	public static final String CREW_CAST_LAST_NAME = "crewCastLastName";
	public static final String CREW_CAST_DESCRIPTION = "crewCastDescription";
	public static final String CREW_CAST_BIOGRAPHY = "crewCastBiography";

	public void save(CrewCast transientInstance) {
		log.debug("saving CrewCast instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CrewCast persistentInstance) {
		log.debug("deleting CrewCast instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CrewCast findById(java.lang.Integer id) {
		log.debug("getting CrewCast instance with id: " + id);
		try {
			CrewCast instance = (CrewCast) getSession().get(
					"hibernate_dvx.CrewCast", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CrewCast instance) {
		log.debug("finding CrewCast instance by example");
		try {
			List results = getSession()
					.createCriteria("hibernate_dvx.CrewCast").add(
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
		log.debug("finding CrewCast instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CrewCast as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCrewCastFullName(Object crewCastFullName) {
		return findByProperty(CREW_CAST_FULL_NAME, crewCastFullName);
	}

	public List findByCrewCastFirstName(Object crewCastFirstName) {
		return findByProperty(CREW_CAST_FIRST_NAME, crewCastFirstName);
	}

	public List findByCrewCastMiddleName(Object crewCastMiddleName) {
		return findByProperty(CREW_CAST_MIDDLE_NAME, crewCastMiddleName);
	}

	public List findByCrewCastLastName(Object crewCastLastName) {
		return findByProperty(CREW_CAST_LAST_NAME, crewCastLastName);
	}

	public List findByCrewCastDescription(Object crewCastDescription) {
		return findByProperty(CREW_CAST_DESCRIPTION, crewCastDescription);
	}

	public List findByCrewCastBiography(Object crewCastBiography) {
		return findByProperty(CREW_CAST_BIOGRAPHY, crewCastBiography);
	}

	public List findAll() {
		log.debug("finding all CrewCast instances");
		try {
			String queryString = "from CrewCast";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CrewCast merge(CrewCast detachedInstance) {
		log.debug("merging CrewCast instance");
		try {
			CrewCast result = (CrewCast) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CrewCast instance) {
		log.debug("attaching dirty CrewCast instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CrewCast instance) {
		log.debug("attaching clean CrewCast instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}