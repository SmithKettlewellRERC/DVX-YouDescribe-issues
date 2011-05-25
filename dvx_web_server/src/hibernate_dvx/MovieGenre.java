package hibernate_dvx;

import java.sql.Timestamp;

/**
 * MovieGenre entity. @author MyEclipse Persistence Tools
 */
public class MovieGenre extends AbstractMovieGenre implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public MovieGenre() {
	}

	/** full constructor */
	public MovieGenre(String movieGenreDescription,
			String movieGenreDescriptionLong, Timestamp created, Timestamp modified) {
		super(movieGenreDescription, movieGenreDescriptionLong, created,
				modified);
	}

}
