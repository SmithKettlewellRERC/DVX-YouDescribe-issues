package hibernate_dvx;

import java.sql.Timestamp;
import java.util.Set;

/**
 * ZipCode entity. @author MyEclipse Persistence Tools
 */
public class ZipCode extends AbstractZipCode implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public ZipCode() {
	}

	/** full constructor */
	public ZipCode(State state, Geocode geocode, City city, Integer zipCode,
			Integer zipCodeExtended, Timestamp created, Timestamp modified,
			Set userDetails) {
		super(state, geocode, city, zipCode, zipCodeExtended, created,
				modified, userDetails);
	}

}
