package hibernate_dvx;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractCrewCast entity provides the base persistence definition of the
 * CrewCast entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCrewCast extends HibernateBaseClass implements
		java.io.Serializable {

	// Fields

	private Integer crewCastId;
	private Author author;
	private String crewCastFullName;
	private String crewCastFirstName;
	private String crewCastMiddleName;
	private String crewCastLastName;
	private Date crewCastBirthday;
	private String crewCastDescription;
	private String crewCastBiography;
	private Timestamp created;
	private Timestamp modified;
	private Set movieCasts = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractCrewCast() {
	}

	/** full constructor */
	public AbstractCrewCast(Author author, String crewCastFullName,
			String crewCastFirstName, String crewCastMiddleName,
			String crewCastLastName, Date crewCastBirthday,
			String crewCastDescription, String crewCastBiography,
			Timestamp created, Timestamp modified, Set movieCasts) {
		this.author = author;
		this.crewCastFullName = crewCastFullName;
		this.crewCastFirstName = crewCastFirstName;
		this.crewCastMiddleName = crewCastMiddleName;
		this.crewCastLastName = crewCastLastName;
		this.crewCastBirthday = crewCastBirthday;
		this.crewCastDescription = crewCastDescription;
		this.crewCastBiography = crewCastBiography;
		this.created = created;
		this.modified = modified;
		this.movieCasts = movieCasts;
	}

	// Property accessors

	public Integer getCrewCastId() {
		return this.crewCastId;
	}

	public void setCrewCastId(Integer crewCastId) {
		this.crewCastId = crewCastId;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getCrewCastFullName() {
		return this.crewCastFullName;
	}

	public void setCrewCastFullName(String crewCastFullName) {
		this.crewCastFullName = crewCastFullName;
	}

	public String getCrewCastFirstName() {
		return this.crewCastFirstName;
	}

	public void setCrewCastFirstName(String crewCastFirstName) {
		this.crewCastFirstName = crewCastFirstName;
	}

	public String getCrewCastMiddleName() {
		return this.crewCastMiddleName;
	}

	public void setCrewCastMiddleName(String crewCastMiddleName) {
		this.crewCastMiddleName = crewCastMiddleName;
	}

	public String getCrewCastLastName() {
		return this.crewCastLastName;
	}

	public void setCrewCastLastName(String crewCastLastName) {
		this.crewCastLastName = crewCastLastName;
	}

	public Date getCrewCastBirthday() {
		return this.crewCastBirthday;
	}

	public void setCrewCastBirthday(Date crewCastBirthday) {
		this.crewCastBirthday = crewCastBirthday;
	}

	public String getCrewCastDescription() {
		return this.crewCastDescription;
	}

	public void setCrewCastDescription(String crewCastDescription) {
		this.crewCastDescription = crewCastDescription;
	}

	public String getCrewCastBiography() {
		return this.crewCastBiography;
	}

	public void setCrewCastBiography(String crewCastBiography) {
		this.crewCastBiography = crewCastBiography;
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

	public Set getMovieCasts() {
		return this.movieCasts;
	}

	public void setMovieCasts(Set movieCasts) {
		this.movieCasts = movieCasts;
	}

}