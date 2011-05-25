package hibernate_dvx;

import java.sql.Timestamp;
import java.util.Set;

/**
 * CrewCast entity. @author MyEclipse Persistence Tools
 */
public class CrewCast extends AbstractCrewCast implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public CrewCast() {
	}

	/** full constructor */
	public CrewCast(Author author, String crewCastFullName,
			String crewCastFirstName, String crewCastMiddleName,
			String crewCastLastName, Timestamp crewCastBirthday,
			String crewCastDescription, String crewCastBiography, Timestamp created,
			Timestamp modified, Set movieCasts) {
		super(author, crewCastFullName, crewCastFirstName, crewCastMiddleName,
				crewCastLastName, crewCastBirthday, crewCastDescription,
				crewCastBiography, created, modified, movieCasts);
	}

}
