package hibernate_dvx;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Movie entity. @author MyEclipse Persistence Tools
 */
public class Movie extends AbstractMovie implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Movie() {
	}

	/** full constructor */
	public Movie(Country country, Status status, Rating rating,
			String movieName, String movieSbnNumber, Timestamp movieReleased,
			String movieRatingTemp, Integer movieRating, String movieQuote,
			String movieDescription, String movieExtraFeatures,
			Integer movieRuntime, Integer movieBudget, Integer movieRevenue,
			String movieWebpage, Timestamp created, Timestamp modified,
			Set movieChapters, Set descriptions, Set posters,
			Set movieTrailers, Set movieCasts) {
		super(country, status, rating, movieName, movieSbnNumber,
				movieReleased, movieRatingTemp, movieRating, movieQuote,
				movieDescription, movieExtraFeatures, movieRuntime,
				movieBudget, movieRevenue, movieWebpage, created, modified,
				movieChapters, descriptions, posters, movieTrailers, movieCasts);
	}

}
