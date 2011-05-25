package hibernate_dvx;

import java.sql.Timestamp;

/**
 * Poster entity. @author MyEclipse Persistence Tools
 */
public class Poster extends AbstractPoster implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Poster() {
	}

	/** full constructor */
	public Poster(Movie movie, String posterName, String posterUrl,
			Timestamp created, Timestamp modified) {
		super(movie, posterName, posterUrl, created, modified);
	}

}
