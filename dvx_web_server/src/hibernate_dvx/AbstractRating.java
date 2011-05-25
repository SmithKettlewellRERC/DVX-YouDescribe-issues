package hibernate_dvx;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractRating entity provides the base persistence definition of the Rating
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractRating extends HibernateBaseClass implements
		java.io.Serializable {

	// Fields

	private Integer ratingId;
	private String ratingName;
	private String ratingNameShort;
	private Timestamp created;
	private Timestamp modified;
	private Set movies = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractRating() {
	}

	/** minimal constructor */
	public AbstractRating(Integer ratingId) {
		this.ratingId = ratingId;
	}

	/** full constructor */
	public AbstractRating(Integer ratingId, String ratingName,
			String ratingNameShort, Timestamp created, Timestamp modified,
			Set movies) {
		this.ratingId = ratingId;
		this.ratingName = ratingName;
		this.ratingNameShort = ratingNameShort;
		this.created = created;
		this.modified = modified;
		this.movies = movies;
	}

	// Property accessors

	public Integer getRatingId() {
		return this.ratingId;
	}

	public void setRatingId(Integer ratingId) {
		this.ratingId = ratingId;
	}

	public String getRatingName() {
		return this.ratingName;
	}

	public void setRatingName(String ratingName) {
		this.ratingName = ratingName;
	}

	public String getRatingNameShort() {
		return this.ratingNameShort;
	}

	public void setRatingNameShort(String ratingNameShort) {
		this.ratingNameShort = ratingNameShort;
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

	public Set getMovies() {
		return this.movies;
	}

	public void setMovies(Set movies) {
		this.movies = movies;
	}

}