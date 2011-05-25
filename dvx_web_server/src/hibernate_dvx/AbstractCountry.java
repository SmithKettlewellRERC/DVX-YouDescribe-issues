package hibernate_dvx;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractCountry entity provides the base persistence definition of the
 * Country entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCountry extends HibernateBaseClass implements
		java.io.Serializable {

	// Fields

	private Integer countryId;
	private Continent continent;
	private String countryName;
	private String countryNameShort;
	private Timestamp created;
	private Timestamp modified;
	private Set cities = new HashSet(0);
	private Set movies = new HashSet(0);
	private Set userDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractCountry() {
	}

	/** full constructor */
	public AbstractCountry(Continent continent, String countryName,
			String countryNameShort, Timestamp created, Timestamp modified,
			Set cities, Set movies, Set userDetails) {
		this.continent = continent;
		this.countryName = countryName;
		this.countryNameShort = countryNameShort;
		this.created = created;
		this.modified = modified;
		this.cities = cities;
		this.movies = movies;
		this.userDetails = userDetails;
	}

	// Property accessors

	public Integer getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Continent getContinent() {
		return this.continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryNameShort() {
		return this.countryNameShort;
	}

	public void setCountryNameShort(String countryNameShort) {
		this.countryNameShort = countryNameShort;
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

	public Set getCities() {
		return this.cities;
	}

	public void setCities(Set cities) {
		this.cities = cities;
	}

	public Set getMovies() {
		return this.movies;
	}

	public void setMovies(Set movies) {
		this.movies = movies;
	}

	public Set getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(Set userDetails) {
		this.userDetails = userDetails;
	}

}