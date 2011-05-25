package hibernate_dvx;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Continent entity. @author MyEclipse Persistence Tools
 */
public class Continent extends AbstractContinent implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Continent() {
	}

	/** full constructor */
	public Continent(String continentName, Timestamp created, Timestamp modified,
			Set countries) {
		super(continentName, created, modified, countries);
	}

}
