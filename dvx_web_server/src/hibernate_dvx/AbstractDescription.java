package hibernate_dvx;

import java.sql.Timestamp;

/**
 * AbstractDescription entity provides the base persistence definition of the
 * Description entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractDescription extends HibernateBaseClass implements
		java.io.Serializable {

	// Fields

	private Integer descriptionId;
	private Movie movie;
	private Author author;
	private String descriptionLong;
	private String descriptionShort;
	private Timestamp created;
	private Timestamp modified;

	// Constructors

	/** default constructor */
	public AbstractDescription() {
	}

	/** full constructor */
	public AbstractDescription(Movie movie, Author author,
			String descriptionLong, String descriptionShort, Timestamp created,
			Timestamp modified) {
		this.movie = movie;
		this.author = author;
		this.descriptionLong = descriptionLong;
		this.descriptionShort = descriptionShort;
		this.created = created;
		this.modified = modified;
	}

	// Property accessors

	public Integer getDescriptionId() {
		return this.descriptionId;
	}

	public void setDescriptionId(Integer descriptionId) {
		this.descriptionId = descriptionId;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getDescriptionLong() {
		return this.descriptionLong;
	}

	public void setDescriptionLong(String descriptionLong) {
		this.descriptionLong = descriptionLong;
	}

	public String getDescriptionShort() {
		return this.descriptionShort;
	}

	public void setDescriptionShort(String descriptionShort) {
		this.descriptionShort = descriptionShort;
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