package hibernate_dvx;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractCity entity provides the base persistence definition of the City
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCity extends HibernateBaseClass implements
		java.io.Serializable {

	// Fields

	private Integer cityId;
	private State state;
	private Country country;
	private String cityName;
	private Timestamp created;
	private Timestamp modified;
	private Set zipCodes = new HashSet(0);
	private Set userDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractCity() {
	}

	/** full constructor */
	public AbstractCity(State state, Country country, String cityName,
			Timestamp created, Timestamp modified, Set zipCodes, Set userDetails) {
		this.state = state;
		this.country = country;
		this.cityName = cityName;
		this.created = created;
		this.modified = modified;
		this.zipCodes = zipCodes;
		this.userDetails = userDetails;
	}

	// Property accessors

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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

	public Set getZipCodes() {
		return this.zipCodes;
	}

	public void setZipCodes(Set zipCodes) {
		this.zipCodes = zipCodes;
	}

	public Set getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(Set userDetails) {
		this.userDetails = userDetails;
	}

}