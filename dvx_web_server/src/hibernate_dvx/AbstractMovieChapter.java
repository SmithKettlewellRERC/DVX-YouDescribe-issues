package hibernate_dvx;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * AbstractMovieChapter entity provides the base persistence definition of the
 * MovieChapter entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMovieChapter extends HibernateBaseClass implements
		java.io.Serializable {

	// Fields

	private Integer movieChapterId;
	private Movie movie;
	private String movieChapterDescription;
	private String movieChapterName;
	private Time movieChapterStartTime;
	private Time movieChapterEndTime;
	private Timestamp created;
	private Timestamp modified;

	// Constructors

	/** default constructor */
	public AbstractMovieChapter() {
	}

	/** full constructor */
	public AbstractMovieChapter(Movie movie, String movieChapterDescription,
			String movieChapterName, Time movieChapterStartTime,
			Time movieChapterEndTime, Timestamp created, Timestamp modified) {
		this.movie = movie;
		this.movieChapterDescription = movieChapterDescription;
		this.movieChapterName = movieChapterName;
		this.movieChapterStartTime = movieChapterStartTime;
		this.movieChapterEndTime = movieChapterEndTime;
		this.created = created;
		this.modified = modified;
	}

	// Property accessors

	public Integer getMovieChapterId() {
		return this.movieChapterId;
	}

	public void setMovieChapterId(Integer movieChapterId) {
		this.movieChapterId = movieChapterId;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getMovieChapterDescription() {
		return this.movieChapterDescription;
	}

	public void setMovieChapterDescription(String movieChapterDescription) {
		this.movieChapterDescription = movieChapterDescription;
	}

	public String getMovieChapterName() {
		return this.movieChapterName;
	}

	public void setMovieChapterName(String movieChapterName) {
		this.movieChapterName = movieChapterName;
	}

	public Time getMovieChapterStartTime() {
		return this.movieChapterStartTime;
	}

	public void setMovieChapterStartTime(Time movieChapterStartTime) {
		this.movieChapterStartTime = movieChapterStartTime;
	}

	public Time getMovieChapterEndTime() {
		return this.movieChapterEndTime;
	}

	public void setMovieChapterEndTime(Time movieChapterEndTime) {
		this.movieChapterEndTime = movieChapterEndTime;
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