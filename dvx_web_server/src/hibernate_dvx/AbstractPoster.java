package hibernate_dvx;

import java.sql.Timestamp;

/**
 * AbstractPoster entity provides the base persistence definition of the Poster
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPoster extends HibernateBaseClass implements
		java.io.Serializable {

	// Fields

	private Integer posterId;
	private Movie movie;
	private String posterName;
	private String posterUrl;
	private Timestamp created;
	private Timestamp modified;

	// Constructors

	/** default constructor */
	public AbstractPoster() {
	}

	/** full constructor */
	public AbstractPoster(Movie movie, String posterName, String posterUrl,
			Timestamp created, Timestamp modified) {
		this.movie = movie;
		this.posterName = posterName;
		this.posterUrl = posterUrl;
		this.created = created;
		this.modified = modified;
	}

	// Property accessors

	public Integer getPosterId() {
		return this.posterId;
	}

	public void setPosterId(Integer posterId) {
		this.posterId = posterId;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getPosterName() {
		return this.posterName;
	}

	public void setPosterName(String posterName) {
		this.posterName = posterName;
	}

	public String getPosterUrl() {
		return this.posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
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