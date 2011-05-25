package hibernate_dvx;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Geocode entity. @author MyEclipse Persistence Tools
 */
public class Geocode extends AbstractGeocode implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Geocode() {
	}

	/** full constructor */
	public Geocode(float geocodeLatitude, float geocodeLongitude, Timestamp created,
			Timestamp modified, Set zipCodes) {
		super(geocodeLatitude, geocodeLongitude, created, modified, zipCodes);
	}

}
