package hibernate_dvx;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractStatus entity provides the base persistence definition of the Status
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStatus extends HibernateBaseClass implements
		java.io.Serializable {

	// Fields

	private Integer statusId;
	private String statusDescription;
	private Timestamp created;
	private Timestamp modified;
	private Set movies = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractStatus() {
	}

	/** full constructor */
	public AbstractStatus(String statusDescription, Timestamp created,
			Timestamp modified, Set movies) {
		this.statusDescription = statusDescription;
		this.created = created;
		this.modified = modified;
		this.movies = movies;
	}

	// Property accessors

	public Integer getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusDescription() {
		return this.statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
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