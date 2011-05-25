package hibernate_dvx;

import java.sql.Timestamp;
import java.util.Set;

/**
 * State entity. @author MyEclipse Persistence Tools
 */
public class State extends AbstractState implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public State() {
	}

	/** full constructor */
	public State(String stateName, String stateNameShort,
			Integer stateCountryFk, Timestamp created, Timestamp modified, Set zipCodes,
			Set cities, Set userDetails) {
		super(stateName, stateNameShort, stateCountryFk, created, modified,
				zipCodes, cities, userDetails);
	}

}
