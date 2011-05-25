package hibernate_dvx;

import java.sql.Timestamp;
import java.util.Set;

/**
 * City entity. @author MyEclipse Persistence Tools
 */
public class City extends AbstractCity implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public City() {
	}

	/** full constructor */
	public City(State state, Country country, String cityName, Timestamp created,
			Timestamp modified, Set zipCodes, Set userDetails) {
		super(state, country, cityName, created, modified, zipCodes,
				userDetails);
	}

}
