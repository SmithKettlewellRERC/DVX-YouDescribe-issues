package hibernate_dvx;

import java.sql.Timestamp;

/**
 * AbstractMovieTrailer entity provides the base persistence definition of the
 * MovieTrailer entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMovieTrailer extends HibernateBaseClass implements
		java.io.Serializable {

	// Fields

	private Integer movieTrailerId;
	private Movie movie;
	private String movieTrailerUri;
	private Integer movieTrailerIndex;
	private Timestamp created;
	private Timestamp modified;

	// Constructors

	/** default constructor */
	public AbstractMovieTrailer() {
	}

	/** full constructor */
	public AbstractMovieTrailer(Movie movie, String movieTrailerUri,
			Integer movieTrailerIndex, Timestamp created, Timestamp modified) {
		this.movie = movie;
		this.movieTrailerUri = movieTrailerUri;
		this.movieTrailerIndex = movieTrailerIndex;
		this.created = created;
		this.modified = modified;
	}

	// Property accessors

	public Integer getMovieTrailerId() {
		return this.movieTrailerId;
	}

	public void setMovieTrailerId(Integer movieTrailerId) {
		this.movieTrailerId = movieTrailerId;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getMovieTrailerUri() {
		return this.movieTrailerUri;
	}

	public void setMovieTrailerUri(String movieTrailerUri) {
		this.movieTrailerUri = movieTrailerUri;
	}

	public Integer getMovieTrailerIndex() {
		return this.movieTrailerIndex;
	}

	public void setMovieTrailerIndex(Integer movieTrailerIndex) {
		this.movieTrailerIndex = movieTrailerIndex;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getModified() {
		return this.modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

}