package hibernate_dvx;

import java.sql.Timestamp;

/**
 * MovieTrailer entity. @author MyEclipse Persistence Tools
 */
public class MovieTrailer extends AbstractMovieTrailer implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public MovieTrailer() {
	}

	/** full constructor */
	public MovieTrailer(Movie movie, String movieTrailerUri,
			Integer movieTrailerIndex, Timestamp created, Timestamp modified) {
		super(movie, movieTrailerUri, movieTrailerIndex, created, modified);
	}

}
