package hibernate_dvx;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Author entity. @author MyEclipse Persistence Tools
 */
public class Author extends AbstractAuthor implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Author() {
	}

	/** minimal constructor */
	public Author(Timestamp created) {
		super(created);
	}

	/** full constructor */
	public Author(User user, Timestamp created, Timestamp modified, Set crewCasts,
			Set descriptions) {
		super(user, created, modified, crewCasts, descriptions);
	}

}
