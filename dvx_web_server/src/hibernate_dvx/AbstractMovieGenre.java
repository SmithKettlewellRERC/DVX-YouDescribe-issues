package hibernate_dvx;

import java.sql.Timestamp;

/**
 * AbstractMovieGenre entity provides the base persistence definition of the
 * MovieGenre entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMovieGenre extends HibernateBaseClass implements
		java.io.Serializable {

	// Fields

	private Integer movieGenreId;
	private String movieGenreDescription;
	private String movieGenreDescriptionLong;
	private Timestamp created;
	private Timestamp modified;

	// Constructors

	/** default constructor */
	public AbstractMovieGenre() {
	}

	/** full constructor */
	public AbstractMovieGenre(String movieGenreDescription,
			String movieGenreDescriptionLong, Timestamp created,
			Timestamp modified) {
		this.movieGenreDescription = movieGenreDescription;
		this.movieGenreDescriptionLong = movieGenreDescriptionLong;
		this.created = created;
		this.modified = modified;
	}

	// Property accessors

	public Integer getMovieGenreId() {
		return this.movieGenreId;
	}

	public void setMovieGenreId(Integer movieGenreId) {
		this.movieGenreId = movieGenreId;
	}

	public String getMovieGenreDescription() {
		return this.movieGenreDescription;
	}

	public void setMovieGenreDescription(String movieGenreDescription) {
		this.movieGenreDescription = movieGenreDescription;
	}

	public String getMovieGenreDescriptionLong() {
		return this.movieGenreDescriptionLong;
	}

	public void setMovieGenreDescriptionLong(String movieGenreDescriptionLong) {
		this.movieGenreDescriptionLong = movieGenreDescriptionLong;
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