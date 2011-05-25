package hibernate_dvx;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractContinent entity provides the base persistence definition of the
 * Continent entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractContinent extends HibernateBaseClass implements
		java.io.Serializable {

	// Fields

	private Integer continentId;
	private String continentName;
	private Timestamp created;
	private Timestamp modified;
	private Set countries = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractContinent() {
	}

	/** full constructor */
	public AbstractContinent(String continentName, Timestamp created,
			Timestamp modified, Set countries) {
		this.continentName = continentName;
		this.created = created;
		this.modified = modified;
		this.countries = countries;
	}

	// Property accessors

	public Integer getContinentId() {
		return this.continentId;
	}

	public void setContinentId(Integer continentId) {
		this.continentId = continentId;
	}

	public String getContinentName() {
		return this.continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getModified() {
		return this.modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public Set getCountries() {
		return this.countries;
	}

	public void setCountries(Set countries) {
		this.countries = countries;
	}

}