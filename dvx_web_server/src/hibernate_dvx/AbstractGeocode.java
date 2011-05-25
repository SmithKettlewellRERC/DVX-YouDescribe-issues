package hibernate_dvx;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractGeocode entity provides the base persistence definition of the
 * Geocode entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractGeocode extends HibernateBaseClass implements
		java.io.Serializable {

	// Fields

	private Integer geocodeId;
	private Float geocodeLatitude;
	private Float geocodeLongitude;
	private Timestamp created;
	private Timestamp modified;
	private Set zipCodes = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractGeocode() {
	}

	/** full constructor */
	public AbstractGeocode(Float geocodeLatitude, Float geocodeLongitude,
			Timestamp created, Timestamp modified, Set zipCodes) {
		this.geocodeLatitude = geocodeLatitude;
		this.geocodeLongitude = geocodeLongitude;
		this.created = created;
		this.modified = modified;
		this.zipCodes = zipCodes;
	}

	// Property accessors

	public Integer getGeocodeId() {
		return this.geocodeId;
	}

	public void setGeocodeId(Integer geocodeId) {
		this.geocodeId = geocodeId;
	}

	public Float getGeocodeLatitude() {
		return this.geocodeLatitude;
	}

	public void setGeocodeLatitude(Float geocodeLatitude) {
		this.geocodeLatitude = geocodeLatitude;
	}

	public Float getGeocodeLongitude() {
		return this.geocodeLongitude;
	}

	public void setGeocodeLongitude(Float geocodeLongitude) {
		this.geocodeLongitude = geocodeLongitude;
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

}