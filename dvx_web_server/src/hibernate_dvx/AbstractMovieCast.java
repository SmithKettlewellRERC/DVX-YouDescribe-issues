package hibernate_dvx;

import java.sql.Timestamp;

/**
 * AbstractMovieCast entity provides the base persistence definition of the
 * MovieCast entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMovieCast extends HibernateBaseClass implements
		java.io.Serializable {

	// Fields

	private Integer movieCastId;
	private Movie movie;
	private CrewCast crewCast;
	private Integer movieCastRoleOrder;
	private String movieCastRoleName;
	private String movieCastRoleDescription;
	private Timestamp created;
	private Timestamp modified;

	// Constructors

	/** default constructor */
	public AbstractMovieCast() {
	}

	/** full constructor */
	public AbstractMovieCast(Movie movie, CrewCast crewCast,
			Integer movieCastRoleOrder, String movieCastRoleName,
			String movieCastRoleDescription, Timestamp created,
			Timestamp modified) {
		this.movie = movie;
		this.crewCast = crewCast;
		this.movieCastRoleOrder = movieCastRoleOrder;
		this.movieCastRoleName = movieCastRoleName;
		this.movieCastRoleDescription = movieCastRoleDescription;
		this.created = created;
		this.modified = modified;
	}

	// Property accessors

	public Integer getMovieCastId() {
		return this.movieCastId;
	}

	public void setMovieCastId(Integer movieCastId) {
		this.movieCastId = movieCastId;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public CrewCast getCrewCast() {
		return this.crewCast;
	}

	public void setCrewCast(CrewCast crewCast) {
		this.crewCast = crewCast;
	}

	public Integer getMovieCastRoleOrder() {
		return this.movieCastRoleOrder;
	}

	public void setMovieCastRoleOrder(Integer movieCastRoleOrder) {
		this.movieCastRoleOrder = movieCastRoleOrder;
	}

	public String getMovieCastRoleName() {
		return this.movieCastRoleName;
	}

	public void setMovieCastRoleName(String movieCastRoleName) {
		this.movieCastRoleName = movieCastRoleName;
	}

	public String getMovieCastRoleDescription() {
		return this.movieCastRoleDescription;
	}

	public void setMovieCastRoleDescription(String movieCastRoleDescription) {
		this.movieCastRoleDescription = movieCastRoleDescription;
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