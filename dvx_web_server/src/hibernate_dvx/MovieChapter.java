package hibernate_dvx;

import java.sql.Time;
import java.sql.Timestamp;
/**
 * MovieChapter entity. @author MyEclipse Persistence Tools
 */
public class MovieChapter extends AbstractMovieChapter implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public MovieChapter() {
	}

	/** full constructor */
	public MovieChapter(Movie movie, String movieChapterDescription,
			String movieChapterName, Time movieChapterStartTime,
			Time movieChapterEndTime, Timestamp created, Timestamp modified) {
		super(movie, movieChapterDescription, movieChapterName,
				movieChapterStartTime, movieChapterEndTime, created, modified);
	}

}
