package hibernate_dvx;

import java.sql.Timestamp;

/**
 * MovieCast entity. @author MyEclipse Persistence Tools
 */
public class MovieCast extends AbstractMovieCast implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public MovieCast() {
	}

	/** full constructor */
	public MovieCast(Movie movie, CrewCast crewCast,
			Integer movieCastRoleOrder, String movieCastRoleName,
			String movieCastRoleDescription, Timestamp created, Timestamp modified) {
		super(movie, crewCast, movieCastRoleOrder, movieCastRoleName,
				movieCastRoleDescription, created, modified);
	}

}
